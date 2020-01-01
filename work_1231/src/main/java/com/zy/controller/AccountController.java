package com.zy.controller;

import com.zy.model.Account;
import com.zy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zy
 * @Date 2020-01-01 22:32
 */
@Controller
public class AccountController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @Autowired
    private AccountService service;

    @GetMapping("account/list")
    @ResponseBody
    public List<Account> list(){
        return service.list();
    }

    @GetMapping("account/{id}")
    @ResponseBody
    public Account getById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @PostMapping("account/add")
    @ResponseBody
    public boolean add(@RequestBody Account account){
        System.out.println("account"+account);
        return service.save(account);
    }

    @PutMapping("account/update")
    @ResponseBody
    public boolean update(@RequestBody Account account){
        return service.updateById(account);
    }

    @DeleteMapping("account/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable("id") int id){
        return service.removeById(id);
    }
}
