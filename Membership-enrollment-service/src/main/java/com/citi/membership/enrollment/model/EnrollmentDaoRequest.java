/**@Copyright 2021. All rights are reserved,you should disclose the infromation,  
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.model;

import lombok.Data;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
@Data
public class EnrollmentDaoRequest {
	
	private String clientId;
	private String channelId;
	private String msgts;
	private String cardNum;
	private String cvv;
	private String expDate;
	private String nameOnCard;
	private String firstName;
	private String lastName;
	private String dob;
	private String emailId;
	private String mobNum;
	private String enrollmentDate;
	

}
