package com.devcdper.paymentManagement;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class KakaoPay {

	 private static final String HOST = "https://kapi.kakao.com";
	
	 private static KakaoPayReadyVO kakaoPayReadyVO;
	 private KakaoPayApprovalVO kakaoPayApprovalVO;
	    
	 
	 public String kakaoPayReady(String partner_order_id
			 ,String partner_user_id
			 ,String item_name
			 ,String quantity
			 ,String total_amount
			 						) {
        RestTemplate restTemplate = new RestTemplate();
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "f01c5df0e3e4f19de39d4086db3756e4");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", partner_order_id);
        params.add("partner_user_id", partner_user_id);
        params.add("item_name", item_name);
        params.add("quantity", quantity);
        params.add("total_amount", total_amount);
        params.add("tax_free_amount", "100");
        params.add("approval_url", "http://localhost/kakaoPayComplete");
        params.add("cancel_url", "http://localhost/myCoachingClient");
        params.add("fail_url", "http://localhost/myCoachingClient");
 
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
 
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            System.out.println(("" + kakaoPayReadyVO));
            return kakaoPayReadyVO.getNext_redirect_pc_url();
 
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/kakaoPayComplete";
        
    }
	    
	    
	    
	public KakaoPayApprovalVO kakaoPayApproval(String pg_token,
												String partner_order_id
												 ,String partner_user_id
												 ,String total_amount
												) {
		 
	    System.out.println("kakaoPayApproval............................................");
	        
	    RestTemplate restTemplate = new RestTemplate();
	 
	    // 서버로 요청할 Header
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "KakaoAK " + "f01c5df0e3e4f19de39d4086db3756e4");
	    headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
	 
	        // 서버로 요청할 Body
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	    params.add("cid", "TC0ONETIME");
	    params.add("tid", kakaoPayReadyVO.getTid());
	    params.add("partner_order_id", partner_order_id);
	    params.add("partner_user_id", partner_user_id);
	    params.add("pg_token", pg_token);
	    params.add("total_amount", total_amount);
	    
	    HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
	    
	    try {
	        kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
	        System.out.println("" + kakaoPayApprovalVO);
	      
	        return kakaoPayApprovalVO;
	    
	    } catch (RestClientException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (URISyntaxException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	 
}
