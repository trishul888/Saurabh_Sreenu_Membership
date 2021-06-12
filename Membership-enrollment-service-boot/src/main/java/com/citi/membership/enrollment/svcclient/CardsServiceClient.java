/**@Copyright 2021. All rights are reserved,you should disclose the infromation,  
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.svcclient;

import java.util.List;

import com.citi.membership.enrollment.model.CardDetailsRequest;
import com.citi.membership.enrollment.model.CardDetailsResponse;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
public interface CardsServiceClient {

	List<String> getCards(String cardNum);
	CardDetailsResponse getCardDetails(String cardNum);
	CardDetailsResponse getAllCardDetails(CardDetailsRequest cardDetailsRequest);
}
