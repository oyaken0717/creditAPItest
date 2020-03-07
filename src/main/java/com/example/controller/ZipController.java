package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Zip;
import com.example.service.ZipService;

@Controller
@RequestMapping("")
public class ZipController {
	
	@Autowired
	private ZipService zipService;

	//■	RestTemplate: Web API)を呼び出すためのメソッドを提供するクラス
	@Bean
	RestTemplate RestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	//■①<form name="user_id">から情報がくる。 
	@RequestMapping(value="/confirm",method=RequestMethod.POST)
	public String confirm(
			//■②@RequestParam("user_id")で受け取る。
			//■③②がInteger userIdに入る。
			@RequestParam("user_id") Integer userId
			,@RequestParam("order_number") Integer orderNumber
			,@RequestParam("amount") Integer amount
			,@RequestParam("card_number") Integer cardNumber
			,@RequestParam("card_exp_year") Integer cardExpYear
			,@RequestParam("card_exp_month") Integer cardExpMonth
			,@RequestParam("card_name") String cardName
			,@RequestParam("card_cvv") Integer cardCvv
			) {
		Zip zip = zipService.service(userId,orderNumber,amount,cardNumber,cardExpYear,cardExpMonth,cardName,cardCvv);
		if("success".equals(zip.getStatus())) {
			System.out.println("成功");
			return "finish";			
		}
		return "finish";
	}
}
//		System.out.println(userId);
//		System.out.println(orderNumber);
//		System.out.println(amount);
//		System.out.println(cardNumber);
//		System.out.println(cardExpYear);
//		System.out.println(cardExpMonth);
//		System.out.println(cardName);
//		System.out.println(cardCvv);
