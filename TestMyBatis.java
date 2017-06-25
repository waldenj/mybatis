package com.walden.test;

import com.walden.entity.Order;
import com.walden.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class TestMyBatis {
    private SqlSessionFactory ssf;
    private Reader reader;

    @Before
    public void init(){
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test//一对多关联查询
    public void selectPersonById()throws Exception{
        SqlSession session = ssf.openSession();
        Person person = session.selectOne("com.walden.entity.PersonMapper.selectAllByPersonId", "001");
        System.out.println(person.getOrders());
    }

    @Test//多对一关联查询
    public void selectOrderById()throws Exception{
        SqlSession session = ssf.openSession();
        Order order = session.selectOne("com.walden.entity.OrderMapper.selectAllByOrderId", "O_00001");
        System.out.println(order.getPerson().getName());
    }
}
