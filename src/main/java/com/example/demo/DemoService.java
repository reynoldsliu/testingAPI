package com.example.demo;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	public static Map<String, Float> currenciesTWDbased = new HashMap<String,Float>();
	public static Map<String, Float> currenciesJPYbased = new HashMap<String,Float>();
	public static Map<String, Float> currenciesUSDbased = new HashMap<String,Float>();
	
	
	public static Map<String,Map> currencies = new HashMap<String,Map>();
	
	static {
		currenciesTWDbased.put("TWD",1.0f);
		currenciesTWDbased.put("JPY",3.669f);
		currenciesTWDbased.put("USD",0.03281f);
		
		currenciesJPYbased.put("TWD",0.26956f);
		currenciesJPYbased.put("JPY",1.0f);
		currenciesJPYbased.put("USD",0.00885f);
		
		currenciesUSDbased.put("TWD",30.444f);
		currenciesUSDbased.put("JPY",111.801f);
		currenciesUSDbased.put("USD",1.0f);
		
		currencies.put("TWD",currenciesTWDbased);
		currencies.put("JPY",currenciesJPYbased);
		currencies.put("USD",currenciesUSDbased);
	}
	
	private enum FromType {
		TWD,JPY,USD;
	}
	private enum ToType {
		TWD,JPY,USD;
	}
	private Float transformCurrency;
	
	public Float getTransformCurrency(String fromType,String toType) {
		return (Float) currencies.get(fromType).get(toType);
	}
	
	public DemoVO getResult(String from,String to,String amount) {
		Float amountF = string2Float(amount);
//		FromType fromType = FromType.valueOf(from);
//        ToType toType = ToType.valueOf(to);
		amountF = amountF*getTransformCurrency(from,to);
		return new DemoVO(to,float2FormatString(amountF));
	}
	private Float string2Float(String input) {
        // 使用正则表达式提取数字
        String numberString = input.replaceAll("[^0-9.]", "");

        Float number = Float.parseFloat(numberString);
        return number;
	}
	private String float2FormatString(Float number) {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        String formattedNumber = df.format(number);
		return formattedNumber;
	}
	
	
}
