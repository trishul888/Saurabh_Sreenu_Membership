/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply. 
 *
 * 
 * 
 */
package com.citi.membership.enrollment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @author     ::asus
 * @Date       ::@May 17, 2021
 * @Description::EnrollmentResponse.java
 * @Tags       ::
 */
@Data
@JsonInclude(value = Include.NON_NULL)
public class EnrollmentResponse {
	private StatusBlock statusBlock;
	private String enrollmentStatus;
	private String description;
	private String ackNum;
}
