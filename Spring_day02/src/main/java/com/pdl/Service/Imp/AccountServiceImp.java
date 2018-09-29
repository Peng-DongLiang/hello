package com.pdl.Service.Imp;

import com.pdl.Service.AccountService;
import com.pdl.dao.AccountDao;
import com.pdl.dao.AccountDao1;
import com.pdl.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImp implements AccountService {
    @Autowired()
   // @Qualifier("accountDao")
    private AccountDao1 accountDao;


    public void save(Account account) {
        accountDao.save(account);
    }

    public void delete(Account account) {
        accountDao.delete(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public Account query(Integer account_Id) {
        return accountDao.query(account_Id);
    }

    public List<Account> findAll() {

        return accountDao.findAll();
    }
}
