package com.meritamerica.assignment5.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.exceptions.ExceedsCombinedBalanceLimitException;
import com.meritamerica.assignment5.exceptions.NegativeAmountException;
import com.meritamerica.assignment5.exceptions.NotFoundException;
import com.meritamerica.assignment5.exceptions.RequiredException;
import com.meritamerica.assignment5.models.*;
import com.meritamerica.assignment5.services.MeritBankService;


@RestController
public class MeritBankController {
	
	@Autowired
	MeritBankService service;

	public List<AccountHolder> accountHolders = new ArrayList<>();
	public List<CDOffering> cdOfferings = new ArrayList<>();
	
	// Getting list of account holders
	
	@GetMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolders(){
		return service.getAccountHolders();
	}
	
	// Posting an account holder
	
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
		service.addAccountHolder(accountHolder);
		accountHolders.add(accountHolder);
		return accountHolder;
	}
	
	// Getting account holder by id
	
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccountHolderById(
			@PathVariable(name = "id") long id) throws NotFoundException {
		if (id > accountHolders.size()) {
			throw new NotFoundException("No such id!");
		}
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				return acct;
			}
		}
		return service.getAccountHolderById(id);
	}
	
	// Checking Account Stuff
	
	@PostMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount addCheckingAccount(
			@PathVariable(name = "id") long id,
			@RequestBody @Valid CheckingAccount checkingAccount) throws Exception, NotFoundException {
		if (id > accountHolders.size()) {
			throw new NotFoundException("No such id!");
		}
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				if (checkingAccount.getBalance() < 0) throw new Exception("Negative balance not allowed!");
				else if (acct.getCombinedBalance() > 250000) throw new Exception("Cannot exceed $250,000 across all accounts!");
				checkingAccount.setAccountHolder(acct);
				acct.checkingAccounts.add(checkingAccount);
			}
		}
		service.addCheckingAccount(checkingAccount, id);
		return checkingAccount;
		
	}
	
	@GetMapping("/AccountHolders/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		if (id > accountHolders.size()) throw new NotFoundException("No such id!");
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				return acct.checkingAccounts;
			}
		}
		
		return accountHolders.get((int) id).getCheckingAccounts();
	}
	
	// Savings Account Stuff

	@PostMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount addSavingsAccount(
			@PathVariable(name = "id") long id,
			@RequestBody @Valid SavingsAccount savingsAccount) throws Exception, NotFoundException {
		if (id > accountHolders.size()) {
			throw new NotFoundException("No such id!");
		}
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				if (savingsAccount.getBalance() < 0) throw new Exception("Negative balance not allowed!");
				else if (acct.getCombinedBalance() > 250000) throw new Exception("Cannot exceed $250,000 across all accounts!");
				savingsAccount.setAccountHolder(acct);
				acct.savingsAccounts.add(savingsAccount);
			}
		}
		service.addSavingsAccount(savingsAccount, id);
		return savingsAccount;
		
	}
	
	@GetMapping("/AccountHolders/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		if (id > accountHolders.size()) throw new NotFoundException("No such id!");
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				return acct.savingsAccounts;
			}
		}
		
		return accountHolders.get((int) id).getSavingsAccounts();
	}
	
	// CDAccount Stuff
	
	@PostMapping(value = "/AccountHolders/{id}/CDAccounts")
	public CDAccount addCDAccount(
			@PathVariable(name = "id") long id,
			@RequestBody @Valid CDAccount cdAccount) throws Exception, NotFoundException {
		if (id > accountHolders.size()) {
			throw new NotFoundException("No such id!");
		}
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				if (cdAccount.getBalance() < 0) throw new Exception("Negative balance not allowed!");
				else if (acct.getCombinedBalance() > 250000) throw new Exception("Cannot exceed $250,000 across all accounts!");
				cdAccount.setAccountHolder(acct);
				acct.cdAccounts.add(cdAccount);
			}
		}
		service.addCDAccount(cdAccount, id);
		return cdAccount;
		
	}
	
	@GetMapping("/AccountHolders/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getCDAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		if (id > accountHolders.size()) throw new NotFoundException("No such id!");
		for (AccountHolder acct : accountHolders) {
			if (acct.getId() == id) {
				return acct.cdAccounts;
			}
		}
		
		return accountHolders.get((int) id).getCDAccounts();
	}
	
	// CD Offerings
	
	@PostMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOffering createCDOffering(@RequestBody CDOffering cdOffering) {
		cdOfferings.add(cdOffering);
		return service.addCDOffering(cdOffering);
	}
	
	@GetMapping("/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOffering> getCDOfferings() { 
		return service.getCDOfferings();
	}
	
}
