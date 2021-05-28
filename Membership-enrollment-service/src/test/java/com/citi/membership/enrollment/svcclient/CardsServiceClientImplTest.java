/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 */
package com.citi.membership.enrollment.svcclient;

import static org.junit.Assert.*;
import static org.mockito.Matchers.matches;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.citi.membership.enrollment.model.CardDetails;
import com.citi.membership.enrollment.model.CardDetailsResponse;

/**
 * @author     :: asus
 * @Date       ::May 28, 2021	
 * @Description::CardsServiceClientImplTest.java
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(RestTemplate.class)
public class CardsServiceClientImplTest {

	@InjectMocks
	CardsServiceClientImpl cardServiceClientImpl;
	@Mock
	RestTemplate restTemplate;

	/**
	 * Test method for {@link com.citi.membership.enrollment.svcclient.CardsServiceClientImpl#getCardDetails(java.lang.String)}.
	 */
	@Test
	public void testGetCardDetails() {

		Mockito.when(restTemplate.exchange(Matchers.anyString(),
				Matchers.eq(HttpMethod.GET),
				Matchers.<HttpEntity<HttpHeaders>>any(), 
				Matchers.any(Class.class))).thenReturn(buildResponse());
		
		CardDetailsResponse cardDetailsResponse=cardServiceClientImpl.getCardDetails("2566454656255");
		 
		assertNotNull(cardDetailsResponse);
		assertEquals("pa",cardDetailsResponse.getCardDetails().get(0).getProductType());
	}


	/**
	 * @return
	 */
	private ResponseEntity<CardDetailsResponse> buildResponse() {
		System.out.println("CardsServiceClientImplTest.buildResponse()");
		CardDetailsResponse cardDetailsResponse=new CardDetailsResponse();
		List<CardDetails> cardDetailsList=new ArrayList<>();
		CardDetails cardDetails=new CardDetails();
		cardDetails.setCardNum("3233236233266");
		cardDetails.setExpDate("22/2/212");
		cardDetails.setFName("saurabh");
		cardDetails.setLname("patre");
		cardDetails.setPastDue(true);
		cardDetails.setPrimary(true);
		cardDetails.setProductType("pa");
		cardDetails.setStatus("active");
		
		cardDetailsList.add(cardDetails);
		cardDetailsResponse.setCardDetails(cardDetailsList);
		HttpHeaders responseHeaders=new HttpHeaders();
		responseHeaders.set("MyResponseHeader","MyValue");
		return new ResponseEntity<CardDetailsResponse>(cardDetailsResponse,responseHeaders,HttpStatus.CREATED);
	}


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
}
