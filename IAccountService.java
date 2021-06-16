package com.trg.boot.service;
import java.util.List;

import com.trg.boot.entity.BankAccount;
import com.trg.boot.entity.Wallet;


public interface IAccountService {

	public Wallet addAccount(BankAccount bacc);
	public Wallet removeAccount(int bacc);
	public Wallet viewAccount(int bacc);
	public BankAccount viewBankAccount(int bacc);
	public List<BankAccount> viewAllAccounts();
	

}
