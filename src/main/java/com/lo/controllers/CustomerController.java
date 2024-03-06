package com.lo.controllers;

import com.lo.entities.Customer;
import com.lo.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerServiceImpl service;

    @GetMapping
    public String findAll(Model model) {
        double total = 0;
        List<Customer> customers = service.findAll();
        model.addAttribute("customers", customers);
        for (Customer c : customers) {
            total += c.getBalance();
        }
        model.addAttribute("total", total);
        return "Customer";
    }

    @GetMapping("/new")
    public String formView(Model m) {
        m.addAttribute("newCustomer", new Customer());
        return "Customer";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Customer c) {
        service.save(c);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id,Model model) {
        Customer customer = service.findById(id);
        model.addAttribute("editCustomer", customer);
        model.addAttribute("editAction","customers/edit/" + id);
        return "Customer";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("editCustomer") Customer customer){
        service.update(id,customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/customers";
    }
}
