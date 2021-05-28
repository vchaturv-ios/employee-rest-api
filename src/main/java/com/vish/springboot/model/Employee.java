package com.vish.springboot.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicUpdate
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
	@Column(name = "emp_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "pan_number")
	private String panNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "joining_date")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private Date joiningDate;
	

}
