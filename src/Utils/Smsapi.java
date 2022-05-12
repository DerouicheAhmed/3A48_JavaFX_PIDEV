/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class Smsapi {
    public static final String ACCOUNT_SID = "AC48c65c5b32f135d15b065a16efe84f09";
    public static final String AUTH_TOKEN = "6ab7a4d4f2ccd725aaf3997c22f27178";

    public static void sendSMS(String num, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(num),new PhoneNumber("+15074787872"), msg).create();

        System.out.println(message.getSid());

    }
}
