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
 * @Date       ::@May 19, 2021
 * @Description::CardDetails.java
 * @Tags       ::
 */
@Data
@JsonInclude(value = Include.NON_NULL)
public class CardDetails {
	private String cardNum;
	private boolean primary;
	private String productType;
	private String expDate;
	private String status;
	private boolean pastDue;
	private String fName;
	private String lname;
}
