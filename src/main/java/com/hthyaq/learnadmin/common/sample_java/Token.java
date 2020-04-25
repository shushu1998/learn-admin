package com.hthyaq.learnadmin.common.sample_java;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;
import java.util.*;

public class Token {
    public String getToken(String user_key, String user_secret, long timestamp) {
        String data = user_key + timestamp;
        String hmac = encode(data, user_secret);
        return hmac;
    }
    
    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
    
    private static String encode(String data, String key) {
        String token = null;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            token = toHexString(mac.doFinal(data.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }
}
