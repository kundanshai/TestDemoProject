package com.simple.TestDemoProject.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employeeInfo")
public class EmployeeInfo implements Serializable, Comparable<EmployeeInfo> {

	private static final long serialVersionUID = 4339390401310668816L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emdId;
	@Column(name = "first_Name")
	private String firstName;
	@Column(name = "last_Name")
	private String lastName;
	@Column(name = "email_Id", unique = true)
	private String emailId;
	@Column(name = "dob")
	private Date dateOfBirth;
	@Column(name = "phone_Number", length = 20)
	private String phoneNumber;
	private String address;
	private String gender;
	@OneToMany(targetEntity=Address.class,cascade=CascadeType.ALL)
	private List<Address> listAddress = new ArrayList<>();
    @JoinColumn
    
	public Integer getEmdId() {
		return emdId;
	}

	public void setEmdId(Integer emdId) {
		this.emdId = emdId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public static Comparator<EmployeeInfo> firstNameComprator = new Comparator<EmployeeInfo>() {
		@Override
		public int compare(EmployeeInfo emp1, EmployeeInfo emp2) {
			return emp1.getFirstName().compareTo(emp2.getFirstName());
		}

	};

	@Override
	public int compareTo(EmployeeInfo emp) {
		return this.getEmdId() - emp.getEmdId();
	}

	public List<Address> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}

}
