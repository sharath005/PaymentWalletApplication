package com.trg.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trg.boot.entity.BankAccount;
import com.trg.boot.entity.Wallet;
import com.trg.boot.exceptions.InvalidUserInputException;
import com.trg.boot.repository.IAccountRepository;
import com.trg.boot.repository.WalletRepository;

@Service
public class IAccountServiceImpl implements IAccountService{
	@Autowired
    IAccountRepository ia;
	
	@Autowired
	WalletRepository wrepo;

	@Override
	public Wallet addAccount(BankAccount bacc) {
		Wallet w=bacc.getWallet();
		
		
	    if(wrepo.existsById(w.getWalletId())) {
	    	ia.save(bacc);
	    	return w;
	    }
	    throw new InvalidUserInputException("No Wallet Found");
	   	}

	   
	    
	    
	    
	    
	@Override
	public Wallet removeAccount(int bacc) {
		boolean b=ia.existsById(bacc);
		if(!b)
			throw new InvalidUserInputException("Bank account with Accno "+bacc+"not present");
		else {
			BankAccount ba=ia.findById(bacc);
			Wallet w=ba.getWallet();
			ba.setWallet(null);
			ia.delete(ba);
			return w;			
		}
	}

	@Override
	public Wallet viewAccount(int bacc) {
		boolean b=ia.existsById(bacc);
		if(!b)
			throw new InvalidUserInputException("Bank account with Accno "+bacc+"not present");
		else {
			BankAccount ba=ia.findById(bacc);
			Wallet w=ba.getWallet();
			if(!wrepo.existsById(w.getWalletId()))
				throw new NullPointerException("Wallet not found");
			else
				return w;
		}
	}
	
	@Override
	public BankAccount viewBankAccount(int bacc) {
		boolean b=ia.existsById(bacc);
		if(!b)
			throw new InvalidUserInputException("Bank account with Accno "+bacc+"not present");
		else {
			BankAccount ba=ia.findById(bacc);
			Wallet w=ba.getWallet();
			if(!wrepo.existsById(w.getWalletId()))
				throw new NullPointerException("Wallet not found");
			else
				return ba;
		}
	}
	
	
	
	
	
	
	
	@Override
	public List<BankAccount> viewAllAccounts() {
	return	ia.findAll();
	
		
	}
	

}
