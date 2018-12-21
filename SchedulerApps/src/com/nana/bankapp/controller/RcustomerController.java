package com.nana.bankapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nana.bankapp.model.Rcustomer;
import com.nana.bankapp.services.RcustomerService;

@Controller
public class RcustomerController {
	
	@Autowired
	RcustomerService rcustomerService;
	
	@RequestMapping("/newrcustomer")
	public String newRcustomer(Model model) {
		System.out.println("masuk new customer");
		model.addAttribute("rcustomer", new Rcustomer());
		return "rcustomer_add_form";
	}
	
	@RequestMapping(value = "/savercustomer", method = RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute("rcustomer") Rcustomer rcustomer, BindingResult result) {
		System.out.println("masuk add customer");
		if (result.hasErrors() ) {
			return "rcustomer_add_form";
		} else {
			rcustomerService.saveRcustomer(rcustomer);
			return "redirect:/rcustomer_list";
		}		
	}
	
	@GetMapping("/rcustomer_list")
	public String listAccounts(Model model) {
		System.out.println("masuk list customer");
		List<Rcustomer> rcustomer = rcustomerService.getRcustomers();
		model.addAttribute("rcustomer", rcustomer);
		return "rcustomer_list";
	}

	@GetMapping("/rcustomeredit")
	public String updateRcustomer(@RequestParam("customer_id") String customer_id, Model model) {
		System.out.println("masuk customer edit");
		Rcustomer rcustomer = rcustomerService.getRcustomer(customer_id);
		model.addAttribute("rcustomer", rcustomer);
		return "rcustomer_add_form";
	}
	
	@GetMapping("/rcustomerdelete")
	public String deleteAccount(@RequestParam("customer_id") String customer_id, Model model) {
		System.out.println("masuk customer delete " + customer_id);
		rcustomerService.deleteRcustomer(customer_id);
		return "redirect:/rcustomer_list";
	}
	
	/*	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";
	} */
	
}
