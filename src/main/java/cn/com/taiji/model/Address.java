package cn.com.taiji.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String address;
	 @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	 @JoinColumn(name="person_id",referencedColumnName="id",nullable=false)
	 private Person person;
	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address(String address) {
		super();
		this.address = address;
	}


}