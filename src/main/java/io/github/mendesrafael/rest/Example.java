package io.github.mendesrafael.rest;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
 
import java.net.URI; 
import java.math.BigDecimal; 
 
public class Example { 
    // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "AC242bfd00d6785abbe305758f0e01e049"; 
    public static final String AUTH_TOKEN = "80520a0703117ccf89c6ad330e7023fd"; 
 
    public static void main(String[] args) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+5589981061554"),  
                "MGde8b143a9764797721cd2ede221b4729", 
                "Your message")      
            .create(); 
 
        System.out.println(message.getBody()); 
    } 
}