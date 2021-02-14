package com.meritamerica.assignment7.services;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment7.repositories.*;
import com.meritamerica.assignment7.models.*;
import com.meritamerica.assignment7.security.*;

@Service
public class MeritBankService {
      // IRA
	@Autowired
	IRAAccountRepo IRAAccountRepo;
	
	@Autowired
	IRARegularRepo iRARegularRepo;
	
	@Autowired
	IRARothRepo iRARothRepo;
	 
	@Autowired
	IRARolloverRepo iRARolloverRepo;
	
	@Autowired
	AccountHolderRepo accountHolderRepo;
	
	@Autowired
	CDAccountRepo cdAccountRepo;
	
	@Autowired
	CheckingAccountRepo checkingAccountRepo;
	
	@Autowired
	SavingsAccountRepo savingsAccountRepo;
	
	@Autowired
	CDOfferingRepo cdOfferingRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	JwtUtil jwtUtil;
	
	public AccountHolder addAccountHolder(AccountHolder accountHolder) {
		return accountHolderRepo.save(accountHolder);
	}
	
	public List<AccountHolder> getAccountHolders(){
		return accountHolderRepo.findAll();
	}
	
	public AccountHolder getAccountHolderById(long id) {
		return accountHolderRepo.getOne(id);
	}
	
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount, long id) {
		return savingsAccountRepo.save(savingsAccount);
	}
	
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccountRepo.findAll();
	}
	// IRA
	public IRAAccount addIRAAccounts(IRAAccount IRAAccounts, long id) {
		return IRAAccountRepo.save(IRAAccounts);
	}
	
	public IRARollover addIRARollover(IRARollover iRARollover, long id) {
		return iRARolloverRepo.save(iRARollover);
	}
	
	public IRARegular addIRARegular(IRARegular iRARegular, long id) {
		return iRARegularRepo.save(iRARegular);
	}
	
	public IRARoth addIRARoth(IRARoth iRARoth, long id) {
		return iRARothRepo.save(iRARoth);
	}
	
//	public List<IRAAccount> getIRAAccountss(){
//		return IRAAccountRepo.findAll();
//	}
//	
	
	//CD
	public CDAccount addCDAccount(CDAccount cdAccount, long id) {
		return cdAccountRepo.save(cdAccount);
	}
	
	public List<CDAccount> getCDAccounts(){
		return cdAccountRepo.findAll();
	}
	
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount, long id) {
		return checkingAccountRepo.save(checkingAccount);
	}
	
	public List<CheckingAccount> getCheckingAccounts(){
		return checkingAccountRepo.findAll();
	}
	
	public CDOffering addCDOffering(CDOffering cdOffering) {
		return cdOfferingRepo.save(cdOffering);
	}
	
	public List<CDOffering> getCDOfferings(){
		return cdOfferingRepo.findAll();
	}

	public ResponseEntity<?> registerUser(@Valid SignupRequest signUpRequest) {
		// TODO Auto-generated method stub
		if (userRepo.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Username is already taken!");
		}
		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getPassword());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepo.findByName(ERole.AccountHolder)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepo.findByName(ERole.admin)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "AccountHolder":
					Role userRole = roleRepo.findByName(ERole.AccountHolder)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});

		}

		user.setActive(signUpRequest.isActive());
		user.setRoles(roles);
		userRepo.save(user);

		return ResponseEntity.ok("User registered successfully!");
	}
	
	
	
	public void transferTransaction(long sourceAccount, long targetAccount, double amount) {
		// get source and target accounts from db
		CheckingAccount sourceAcc = this.checkingAccountRepo.findById(sourceAccount)
			.orElseThrow(()-> new RuntimeException("Account with id " + sourceAccount + " Not Found"));
		CheckingAccount targetAcc = this.checkingAccountRepo.findById(targetAccount)
		.orElseThrow(()-> new RuntimeException("Account with id " + targetAccount + " Not Found"));
		// check for valid transaction
		if(amount <= 0 || sourceAcc.getBalance() < amount)
			throw new RuntimeException("Not enough balance");
		// do the transaction
		sourceAcc.withdraw(amount);
		targetAcc.deposit(amount);
		checkingAccountRepo.save(sourceAcc);
		checkingAccountRepo.save(targetAcc);
	}
	
	
	
}