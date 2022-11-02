package com.wyf.controller;

import com.wyf.domain.Account;
import com.wyf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 查询所有用户信息
    @RequestMapping("/findAll")
    public String findAll(Model model){

        // 模拟
        /*List<Account> accountList = new ArrayList<Account>();
        Account account = new Account();
        account.setId(1);
        account.setName("张飞");
        account.setMoney(1000d);

        Account account2 = new Account();
        account2.setId(2);
        account2.setName("关羽");
        account2.setMoney(1000d);

        accountList.add(account);
        accountList.add(account2);*/
        List<Account> accountList = accountService.findAll();

        // 将list集合保存到model域中
        model.addAttribute("list",accountList);
        return "list"; // 配置视图解析器
    }

    // 添加用户
    @RequestMapping("/save")
    public String save(Account account){ // 因为前台name的属性值对应我们实体类Account的属性值，所以我们可以直接封装到实体类中
        accountService.save(account);

        return "redirect:/account/findAll"; // 当前台添加数据成功后重定向到查询所有的方法
    }

    // 通过id查询用户信息:实现数据回显
    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
        // 数据回显
       Account account = accountService.findById(id);

       // 保存到model中
        model.addAttribute("account",account);

        return "update";
    }

    // 更新用户信息
    @RequestMapping("/update")
    public String update(Account account){

        accountService.update(account);

        return "redirect:/account/findAll";
    }

    // 批量删除
    @RequestMapping("/deleteBatch")
    public String deleteBatch(Integer[] ids){
        accountService.deleteBatch(ids);

        return "redirect:/account/findAll";
    }

}
