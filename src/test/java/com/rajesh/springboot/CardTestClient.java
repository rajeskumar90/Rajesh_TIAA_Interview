package com.rajesh.springboot;




import org.springframework.web.client.RestTemplate;

import com.rajesh.springboot.model.Card;
 

public class CardTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/SpringBootRestApi/api";
    /* POST */
    private static void createCardNumberForVisa(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Card card = restTemplate.getForObject(REST_SERVICE_URI+"/card/visa/", Card.class);
        System.out.println(card.getCardNumber());
    }
     
    /* POST */
    private static void createCardNumberForMaster(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Card card = restTemplate.getForObject(REST_SERVICE_URI+"/card/master/", Card.class);
        System.out.println(card.getCardNumber());
    }
    
    /* POST */
    private static void createCardNumberForDiscover(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Card card = restTemplate.getForObject(REST_SERVICE_URI+"/card/discover/", Card.class);
        System.out.println(card.getCardNumber());
    }
    
    
    /* POST */
    private static void createCardNumberForAmerican(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Card card = restTemplate.getForObject(REST_SERVICE_URI+"/card/american/", Card.class);
        System.out.println(card.getCardNumber());
    }
    /* POST */
    private static void createCardExpiryDate(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Card card = restTemplate.getForObject(REST_SERVICE_URI+"/card/master/", Card.class);
        System.out.println(card.getCardNumber());
    }


 
    public static void main(String args[]){
    	 createCardNumberForVisa();
    	createCardNumberForAmerican();
    	createCardNumberForDiscover();
    	createCardNumberForMaster();
    	createCardExpiryDate();
    }
}