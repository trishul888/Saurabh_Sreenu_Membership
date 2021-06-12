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
public class EnrollmentDaoResponse {
	
	private String responseCode;
	private String responseMsg;
	private String enrollmentStatus;
	private String ackNum;
	private String discription;
}
