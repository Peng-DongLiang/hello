package test;

import com.pdl.Service.AccountService;
import com.pdl.Service.Imp.AccountServiceImp;
import com.pdl.config.JdbcConfig;
import com.pdl.config.SpringConfig;
import com.pdl.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
//ContextConfiguration用于告知spring 的运行器,spring和ioc的建立是通过注解还是xml,并说明位置
@ContextConfiguration(locations= {"classpath:bean.xml"})
@ContextConfiguration(classes = JdbcConfig.class)
public class AccountTest {
    @Autowired
    private AccountService as;
    @Test
    public void findAll(){
       // ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
        AccountService o =(AccountService) context.getBean("accountService");
        List<Account> all = o.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
    @Test
    public void findone(){
        //ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        //AccountService o =(AccountService) context.getBean("accountService");
        Account query = as.query(1);
        System.out.println(query);
    }
    @Test
    public void update(){
        Account account = new Account();
        account.setId(1);
        account.setName("xixi");
        account.setMoney(3000f);
        //ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService o=(AccountService)context.getBean("accountService");
        o.update(account);
    }
}
