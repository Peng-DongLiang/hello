package com.pdl.dao.Imp;

import com.pdl.dao.AccountDao;
import com.pdl.dao.AccountDao1;
import com.pdl.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao1")
public class AccountDaoImp3 implements AccountDao1 {

    @Autowired()
    @Qualifier("runner")
    private QueryRunner runner;




    public void save(Account account) {
        try {
            runner.update("insert into account set (name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Account account) {
        try {
            runner.update("delect from account where id=?",account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account query(Integer account_Id) {
        try {

            return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),account_Id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Account> findAll() {
        try {
            System.out.println("566789999");
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
