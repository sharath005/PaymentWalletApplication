package com.trg.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trg.boot.entity.BankAccount;
import com.trg.boot.entity.Wallet;






@Repository
public interface IAccountRepository extends JpaRepository<BankAccount,Integer> {
	
	BankAccount findByWallet(Wallet w);
	
	BankAccount findById(int bid);
	
	

}
