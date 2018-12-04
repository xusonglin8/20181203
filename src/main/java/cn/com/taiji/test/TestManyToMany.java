package cn.com.taiji.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cn.com.taiji.model.Address;
import cn.com.taiji.model.Person;
import cn.com.taiji.model.Student;

public class TestManyToMany {

	public static void main(String[] args) {
		new TestManyToMany().testInsert();
	}
       
	
	  public void testInsert() { 
	  // 1.获得Factory 
	  EntityManagerFactory factory =Persistence.createEntityManagerFactory("test2"); 
	  // 2.获取Manager 
	  EntityManager manager = factory.createEntityManager(); 
	  // 3.获得事务，并开启uiwu 
	  EntityTransaction transaction = manager.getTransaction(); 
	  transaction.begin();
     // 4.执行sql
	  Person person=new Person("xusonglin",new Address("beijing"));
	 manager.persist(person); //
	// 5.提交事务，关闭资源 
	 transaction.commit(); 
	 manager.close(); 
	 factory.close(); 
	 }
	
	
	 public void testInsert2() { 
		 // 1.获得Factory 
		 Map properties = new HashMap<String, Object>(); 
		 properties.put("hibernate.format_sql", "false");
	     EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA", properties); 
	     // 2.获取Manager 
	     EntityManager manager =factory.createEntityManager(); 
	  // 3.获得事务，并开启uiwu 
	  EntityTransaction transaction = manager.getTransaction(); 
	  transaction.begin(); 
	  // 4.执行sql
	  Student student = new Student("haha");
	  manager.persist(student);
	  //5.提交事务，关闭资源 
	  transaction.commit();
	  manager.close(); 
	  factory.close(); 
	  }
	 
	
	public void testInsert3() {
		// 1.获得Factory
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA"); 
		// 2.获取Manager 
		EntityManager manager = factory.createEntityManager();
		Query query=manager.createQuery("insert into Person(address,name) values(:address,:name)")
				.setParameter(1, "beijing")
				.setParameter(2, "xusonglin");
		   
	}

	// 根据id查询 find 相当于hibernate get方法
	
	  public void testFind() { // 1.获得Factory 
		  EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA"); 
		  // 2.获取Manager 
		  EntityManager manager = factory.createEntityManager(); 
		  // 3. 获得事务，并开启事务 
		  EntityTransaction transaction = manager.getTransaction(); 
		  transaction.begin(); 
		  // 4.执行sql
	  Address address = manager.find(Address.class, "1");
	  System.out.println(address); 
	  // 5.提交事务，关闭资源
	  transaction.commit();
	  manager.close(); 
	  factory.close(); 
	  }
	 
	// 根据id查询 getReference 相当于hibernate load方法
	// find和getReference的区别----与hibernate中get和load的区别一样---懒加载--id没有对应值时报异常

	
	 public void testGet() { // 1.获得Factory 
		 EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA"); 
		 // 2.获取Manager 
		 EntityManager manager = factory.createEntityManager(); 
	 // 3.获得事务，并开启事务 
		 EntityTransaction transaction = manager.getTransaction(); 
		 
		 transaction.begin(); 
		 // 4.执行sql
	 Address address = manager.getReference(Address.class, "1");
	 System.out.println(address); 
	 // 5.提交事务，关闭资源 
	 transaction.commit();
	 manager.close(); 
	 factory.close(); 
	 }
	 

	// 修改数据
	
	  public void testUpdate() { // 1.获得Factory 
		  EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		  // 2.获取Manager 
		  EntityManager manager = factory.createEntityManager(); 
		  // 3.获得事务，并开启事务 
		  EntityTransaction transaction = manager.getTransaction(); 
		  transaction.begin(); 
		  // 4.执行sql
	  Address address = manager.find(Address.class, "1");
	  address.setAddress("beijing"); 
	  // 5.提交事务，关闭资源
	  transaction.commit();
	  manager.close();
	  factory.close();
	  }
	 

	// 删除数据 remove 相当于hibernate delete方法
	// remove方法只能移除执久化对象，不能删除游离对象 public
	
	  void testRemove() { 
		  // 1.获得Factory 
		  EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA"); 
		  // 2.获取Manager 
		  EntityManager manager = factory.createEntityManager(); 
		  // 3.获得事务，并开启事务 
		  EntityTransaction transaction = manager.getTransaction(); 
		  transaction.begin(); 
		  // 4.执行sql
	  Address address = manager.find(Address.class, "2");
	  manager.remove(address);
	  // 5.提交事务，关闭资源
	  transaction.commit(); 
	  manager.close(); 
	  factory.close(); 
	  }
	 
}
