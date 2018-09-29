package com.pdl.Service;

import com.pdl.domain.Account;

import java.util.List;

public interface AccountService {
    //增加
    void save(Account account);
    //删除
    void delete(Account account);
    //修改
    void update(Account account);
    //条件查询
    Account query(Integer account_Id);
    //查询所有
    List<Account> findAll();
}
