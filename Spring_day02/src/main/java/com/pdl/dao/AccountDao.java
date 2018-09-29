package com.pdl.dao;

import com.pdl.domain.Account;
import net.sf.ehcache.terracotta.TerracottaClientRejoinListener;

import java.util.List;

public interface AccountDao {
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
