package com.wyf.service;

import com.wyf.domain.Account;

import java.util.List;

public interface AccountService {
    // 查询所有用户
    public List<Account> findAll();

    void save(Account account);

    Account findById(Integer id);

    void update(Account account);

    void deleteBatch(Integer[] ids);
}
