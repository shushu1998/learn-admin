package com.hthyaq.learnadmin.common.sample_java;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Authorization {


    public String getAuthor(String access_key, String secret_key, String uri, String host) {
        String auth = "";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("host", host);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, -8);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        String df_s = df.format(cal.getTime());
        String sf_s = sf.format(cal.getTime());
        String timestamp = df_s + "T" + sf_s + "Z";
        Signer signer = new Signer();
        signer.withAccessKey(access_key)
                .withSecretKey(secret_key)
                .withTimestamp(timestamp) //当前utc时间, 格式YYYY-MM-DDTHH:mm:ssZ
                .withMethod("POST") // method POST GET PUT DELETE....
                .withVersion("1") // now must be 1
                .withExpire(1800) //过期时间
                .withUri(uri) // uri path
                .withSignHeaders(headers); // 只传递需要签名的header, host 是必须的
        try {
            auth = signer.genAuthorization();
        } catch (SignerException e) {
            System.out.println(e.getMessage());
        }
        return auth;
    }
}
