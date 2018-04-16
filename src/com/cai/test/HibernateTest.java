package com.cai.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cai.dao.UserDao;
import com.cai.domain.User;
import com.cai.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Test
	public void fun1(){
		/*Configuration cgf=new Configuration().configure();
		 *这个加载配置是记载hibernate，加载文件从hibernate.cfg.xml 开始
		 */
		Configuration cgf=new Configuration().configure();
		SessionFactory sessionFactory = cgf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="from User  ";
		User user=new User();
		user.setUser_code("Linda");
		user.setUser_password("233");
		user.setUser_name("怜星");
//		Query query = session.createQuery(hql);
//		List list = query.list();
//		System.out.println(list);
		session.save(user);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	
	@Test
	public  void fun2(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="from User  ";
		User user=new User();
		user.setUser_code("Linda");
		user.setUser_password("233");
		user.setUser_name("love");
//		Query query = session.createQuery(hql);
//		List list = query.list();
//		System.out.println(list);
		session.save(user);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	@Resource(name="userDao")
	UserDao userDao;
	
	@Test	//	测试dao层
	public void fun3(){
		User user = userDao.getById(1l);
		System.out.println(user);
	}
	@Resource(name="userService")
	UserService userService;
	@Test	//测试controller层
	public void fun4(){
		DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		List<User> list = userService.getPageList(dc, 0, 5);
		System.out.println(list);
	}
}





