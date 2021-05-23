/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply. 
 *
 * 
 * 
 */
package com.citi.membership.enrollment.model;

import lombok.Data;

/**
 * @author     ::asus
 * @Date       ::@May 17, 2021
 * @Description::EnrollmentRequest.java
 * @Tags       ::
 */
@Data
public class EnrollmentRequest {
	private ClientInfo clientInfo;
	private CustomerInfo customerInfo;
}
