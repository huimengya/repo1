package com.wyf.test;

import com.wyf.domain.Account;
import com.wyf.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAll(){
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
}
