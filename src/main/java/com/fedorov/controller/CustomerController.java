package com.fedorov.controller;

import com.fedorov.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("customer")
public class CustomerController {


    // add a initbinder .. to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for my validation - it's all about whitespase

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingresult) {
        System.out.println("Last name: |" + theCustomer.getLastName() + "|");

//        binding my error code
        System.out.println("Binding result: " + theBindingresult);
        System.out.println("\n\n\n\n");

        if(theBindingresult.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }



    }





}


