package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Zip;

@Service
@Transactional
public class ZipService {

    @Autowired
    RestTemplate restTemplate;
    
    private static final String URL = "http://192.168.100.59:8080/sample-credit-card-web-api/credit-card/payment"
    		+ "?user_id={userId}"
    		+ "?order_number={orderNumber}"
    		+ "?amount={amount}"
    		+ "?card_number={cardNumber}"
    		+ "?card_exp_year={cardExpYear}"
    		+ "?card_exp_month={cardExpMonth}"
    		+ "?card_name={cardName}"
    		+ "?card_cvv={cardCvv}";

    
    public Zip service(Integer userId, int orderNumber, Integer amount , Integer cardNumber, Integer cardExpYear, Integer cardExpMonth, String cardName, Integer cardCvv) {
//    public Zip service(Integer userId, Integer orderNumber, Integer amount , Integer cardExpYear, Integer cardExpMonth, String cardName, Integer cardCvv) {
        return restTemplate.getForObject(URL, Zip.class, userId, orderNumber, amount, cardNumber, cardExpYear, cardExpMonth, cardName, cardCvv);
    }
}
