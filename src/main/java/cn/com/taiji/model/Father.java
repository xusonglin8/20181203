package cn.com.taiji.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Father {
	
@Id
@Column(name="id")
 private String name ;
@Column(name="age",length=2)
 private int age;
@OneToMany(mappedBy="father")
private List<Son> sonList;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Father(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}
public Father() {
	super();
}

 
 
}
