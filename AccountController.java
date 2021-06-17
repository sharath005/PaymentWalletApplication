package com.trg.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trg.boot.entity.BankAccount;
import com.trg.boot.entity.Wallet;
import com.trg.boot.service.IAccountService;

@RestController
@RequestMapping("account")
public class AccountController {
     	
      @Autowired
      IAccountService ia;
      
      @PostMapping()
      public ResponseEntity<String> addAccount(@Valid@RequestBody BankAccount bacc){
    	  Wallet wa = ia.addAccount(bacc);
    	  return new ResponseEntity<>("Account added successfully!!",HttpStatus.OK);
	  
    	  
      }
      
      @DeleteMapping("{bacc}")
      public ResponseEntity<?> removeAccount(@PathVariable  int bacc){
    	  Wallet ra = ia.removeAccount(bacc);
    		  return new ResponseEntity<>("Account is deleted from the wallet",HttpStatus.OK);
    	  
      }
      
      
      @GetMapping("/viewaccount/{bacc}")
      public ResponseEntity<?> viewAccount(@PathVariable("bacc") int bacc){
    	  Wallet va = ia.viewAccount(bacc);
    	  
    	  
    		  return new ResponseEntity<>(va , HttpStatus.OK);
    	
    	
    	  
      }
      @GetMapping("/viewbankaccount/{bacc}")
      public ResponseEntity<?> viewBankAccount(@PathVariable("bacc")  int bacc){
    	  BankAccount va = ia.viewBankAccount(bacc);
    	  
    	 
    		  return new ResponseEntity<>(va , HttpStatus.OK);
    	 
    	  
      }
      
  @GetMapping()
      public ResponseEntity<?> viewAllAccount(){
    	  List<BankAccount> ba = ia.viewAllAccounts();
    	 
    		  return new ResponseEntity<>(ba ,HttpStatus.OK);
    	  
    	
    	  
      }
	
      
      
      
      
      
      
      
      
	
}

