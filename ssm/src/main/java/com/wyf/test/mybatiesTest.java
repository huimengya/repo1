package com.wyf.test;

import com.wyf.dao.AccountDao;
import com.wyf.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatiesTest {

    @Test
    public void testFindAll() throws IOException {
        // 加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获取sqlsession工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SQLsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取接口对应的mapper代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);

        List<Account> all = mapper.findAll();

        for (Account account : all) {
            System.out.println(account);
        }
    }
}
