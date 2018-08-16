package com.app.bank.AppController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.bank.dao.BankAccountCollection;
import com.app.bank.pojo.CurrentAccount;
import com.app.bank.pojo.SavingsAccount;
import com.app.bank.service.BankAccountService;

@Controller
class BankAccountController {
	
	private BankAccountService service;
	Collection<SavingsAccount> bank=service.showSavings();
	SavingsAccount savingAccount;
	BankAccountCollection bankDao;
	private Map<Integer,SavingsAccount> savingList = new HashMap<>();
	private Map<Integer,CurrentAccount> currentList = new HashMap<>();
	Collection<SavingsAccount> bankList;
	Collection<SavingsAccount> bank1;
	double balance;
	
	//Model is used to transfer data from one jsp to other jsp
	@RequestMapping("/showCustomer")
	public String viewSaving(Model model) {
		bankList=service.showSavings();
		model.addAttribute("bank",bankList);
		
		return "showCustomer";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(@RequestParam("accNo") int accountNumber ,@RequestParam("amount") double amount,Model model )
	{
		bank1=service.showSavings();
		 for(SavingsAccount sav1:bank1)
		 {
			 if(sav1.getAccountNo()==accountNumber)
			 {
				 balance=service.withdraw(accountNumber,amount);
				 model.addAttribute("banker", bank1);
			 }
			 
		
		}
		 return "withdrawSuccess";
	}
	
	@RequestMapping("/deposit")
	public String deposit(@RequestParam("accNo") int accountNumber ,@RequestParam("amount") double amount,Model model )
	{
		bank1=service.showSavings();
		 for(SavingsAccount sav1:bank1)
		 {
			 if(sav1.getAccountNo()==accountNumber)
			 {
				 balance=service.withdraw(accountNumber,amount);
				 model.addAttribute("banker", bank1);
			 }
			 
		
		}
		 return "withdrawSuccess";
	}
}