/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 */
package com.citi.membership.enrollment.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author     :: asus
 * @Date       ::May 23, 2021	
 * @Description::Enrollment.java
 */
@Data
@Entity
@Table(name = "enrollment")
public class Enrollment {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "cvv_num")
	private String cvv_Number;
	
	@Column(name = "exp_date")
	private String expiryDate;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last _name")
	private String lastName;
	
	@Column(name = "mobile_num")
	private String mobileNumber;
	
	@Column(name = "email_id")
	private String emailId;
			
    @Column(name = "dob")
	private String dateOfBirth;
    
    @Column(name = "enrolledDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enrollmentDate;
	
}
