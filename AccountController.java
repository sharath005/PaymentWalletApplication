package com.trg.boot.controller;

import java.util.List;

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
      public ResponseEntity<String> addAccount(@RequestBody BankAccount bacc){
    	  Wallet wa = ia.addAccount(bacc);
    	  if (wa != null) 
    		  return new ResponseEntity<>("Your account added",HttpStatus.OK);
    	  
    	  return new ResponseEntity<>("Account not found to be added!!",HttpStatus.BAD_REQUEST);
	  
    	  
      }
      
      @DeleteMapping("{bacc}")
      public ResponseEntity<?> removeAccount(@PathVariable  int bacc){
    	  Wallet ra = ia.removeAccount(bacc);
    	  if (ra != null)
    		  return new ResponseEntity<>("Account is deleted for the wallet",HttpStatus.OK);
    	  return new ResponseEntity<>("Account not found to be deleted!!",HttpStatus.BAD_REQUEST);
      }
      
      
      @GetMapping("/viewaccount/{bacc}")
      public ResponseEntity<?> viewAccount(@PathVariable("bacc") int bacc){
    	  Wallet va = ia.viewAccount(bacc);
    	  
    	  if(va != null)
    		  return new ResponseEntity<>(va , HttpStatus.OK);
    	  return new ResponseEntity<>("Account not found", HttpStatus.BAD_REQUEST);
    	
    	  
      }
      @GetMapping("/viewbankaccount/{bacc}")
      public ResponseEntity<?> viewBankAccount(@PathVariable("bacc")  int bacc){
    	  BankAccount va = ia.viewBankAccount(bacc);
    	  
    	  if(va != null)
    		  return new ResponseEntity<>(va , HttpStatus.OK);
    	  return new ResponseEntity<>("Account not found", HttpStatus.BAD_REQUEST);
    	  
      }
      
  @GetMapping()
      public ResponseEntity<?> viewAllAccount(){
    	  List<BankAccount> ba = ia.viewAllAccounts();
    	  if (ba != null) 
    		  return new ResponseEntity<>(ba ,HttpStatus.OK);
    	  
    	  return new ResponseEntity<>("Account not displayed",HttpStatus.BAD_REQUEST);
	  
    	  
      }
	
      
      
      
      
      
      
      
      
	
}
