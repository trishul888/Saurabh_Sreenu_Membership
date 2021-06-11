/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply. 
 *
 * 
 * 
 */
package com.citi.membership.enrollment.svcclient;

import com.citi.membership.enrollment.model.CardDetailsResponse;

/**
 * @author     ::asus
 * @Date       ::@May 19, 2021
 * @Description::CardServiceClientMainTest.java
 * @Tags       ::
 */
public class CardServiceClientMainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CardsServiceClientImpl svcClient=new CardsServiceClientImpl();
		CardDetailsResponse response=svcClient.getCardDetails("056789123456789");
		System.out.println("Response "+response);

	}

}
