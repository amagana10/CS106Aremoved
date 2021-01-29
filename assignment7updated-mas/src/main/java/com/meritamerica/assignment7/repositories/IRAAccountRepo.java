package com.meritamerica.assignment7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.assignment7.models.IRAAccount;

public interface IRAAccountRepo extends JpaRepository<IRAAccount, Long> {

}
