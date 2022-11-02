package com.wyf.service.impl;

import com.wyf.dao.AccountDao;
import com.wyf.domain.Account;
import com.wyf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // 表示该类的所有方法都要进行事务控制
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        // 演示：spring在ssm中的单独使用
        //  System.out.println("findAll执行啦...");

        // spring整合mybatis
        List<Account> all = accountDao.findAll();

        return all;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);

    }

    @Override
    public Account findById(Integer id) {
        Account account = accountDao.findById(id);
        return account;
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        accountDao.deleteBatch(ids);
    }
}
