package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employee_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "hourly_pay")
	private double hourly_pay;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, double hourlyPay) {
		super();
		this.first_name = firstName;
		this.last_name = lastName;
		this.hourly_pay = hourlyPay;
	}
	
	public long getId() {
		return employee_id;
	}
	public void setId(long employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public double getHourly_pay() {
		return hourly_pay;
	}
	public void setHourly_pay(double hourly_pay) {
		this.hourly_pay = hourly_pay;
	}
	
}
