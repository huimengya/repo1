package com.wyf.dao;

import com.wyf.domain.Account;

import java.util.List;

public interface AccountDao {
    // 查询所有用户
    public List<Account> findAll();

    // 添加用户
    void save(Account account);

    Account findById(Integer id);

    void update(Account account);

    void deleteBatch(Integer[] ids);
}
