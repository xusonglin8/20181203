package cn.com.taiji.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Son {
@Id	
private String name;
@Column(name="age",length=2)
private int age;
@ManyToOne(cascade = { CascadeType.ALL })
@JoinColumn(name="father_id")
private Father father;
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
public Father getFather() {
	return father;
}
public void setFather(Father father) {
	this.father = father;
}
public Son(String name, int age, Father father) {
	super();
	this.name = name;
	this.age = age;
	this.father = father;
}
public Son() {
	super();
}

}
