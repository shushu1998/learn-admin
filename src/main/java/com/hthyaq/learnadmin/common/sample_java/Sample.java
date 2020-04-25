package com.hthyaq.learnadmin.common.sample_java;

import java.net.*;
import java.io.*;
import java.util.*;



public class Sample {
    
    static String access_key = "f3181d2b65bb4353959d60091aaec79b"; //用户需要修改为自己的access_key
    static String secret_key = "9ad6d40ce1d740198e741445aa0c175f"; //用户需要修改为自己的secret_key
    static String user_key = "4981c75e536b97e79a6b261426493b74"; //用户需要修改为自己的user_key
    static String user_secret = "167271c92fc8e246e5e392e2ac77b638"; //用户需要修改为自己的user_secret
    static String host = "yuqing.baidu.com"; //此处为固定值，不需要修改

  
	public static String sendPost(String host, String uri, String author, Map<String, String> param_dict) {
        //该函数不需要修改
        PrintWriter out = null;
		BufferedReader br = null;
		String result = "";
        String params = "";
		try {
            for (String key : param_dict.keySet()) {
                if (params != "") {
                    params = params + "&";
                }
                params = params + key + "=" + param_dict.get(key);
            }
            String url = "http://" + host + uri;
			URL realURL = new URL(url);
			URLConnection conn = realURL.openConnection();
            conn.setRequestProperty("host", host);
            conn.setRequestProperty("authorization", author);
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//获取URLConnection对象对应的输入流
			out = new PrintWriter(conn.getOutputStream());
			//发送请求参数
            out.print(params);
			out.flush();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            result = br.readLine();
		} catch (Exception e) {
			System.out.println("程序出现异常"+e);
			e.printStackTrace();
		}
		finally {
            try {
                if(br != null) {
				    br.close();
			    }
				if(out != null) {
					out.close();
				}
				} catch (IOException e) {
					e.printStackTrace();
				}
        }
		return result;
		
	}

    public static void main(String[] args) throws UnsupportedEncodingException {
        //此处需要用户根据具体是创建、删除、修改、查询等进行修改
        String uri = "/openapi/getresult";
        //生成token，不需要修改
        long timestamp = Integer.valueOf(String.valueOf(System.currentTimeMillis()/1000));
        Token token_instance = new Token();
        String token = token_instance.getToken(user_key, user_secret, timestamp);
        System.out.println("token is: " + token);
        //生成authorization，不需要修改
        Authorization author_instance = new Authorization();
        String author = author_instance.getAuthor(access_key, secret_key, uri, host);
        System.out.println("author is: " + author);
        //发送请求，需要用户根据自己的API类型自行修改parameters_dict，此处为API类型为realtime_flow的示例
        Map<String, String> parameters_dict = new HashMap<String, String>();
       parameters_dict.put("task_id", "222776");
        parameters_dict.put("api_type", "realtime_flow");
        //parameters_dict.put("level", "3");
        parameters_dict.put("user_key", user_key);
        parameters_dict.put("token", token);
        parameters_dict.put("timestamp", timestamp+"");
//        String params_dict = "{\"media_type\":[\"news\",\"weibo\"],\"history\":\"1\",\"required_keywords\":[\"上海\",\"北京\"],\"optional_keywords\":[\"职业病\"],\"filter_keywords\":[],\"api_dict\":{\n" +
//                "  \"realtime_flow\": {" +
//                "    \"switch\": \"1\"," +
//                "    \"config\": {\n" +
//                "      \"sentiment_analysis\": \"0\", " +
//                "      \"abstract_extract\": \"1\"," +
//                "      \"geo_extract\": \"1\"," +
//                "      \"similar_merge\": \"1\"" +
//                "    }\n" +
//                "  },\n" +
//                "  \"event_timeline\": {" +
//                "    \"switch\": \"0\"\n" +
//                "  },\n" +
//                "  \"spread_analysis\": {" +
//                "    \"switch\": \"0\"\n" +
//                "  },\n" +
//                "  \"opinion_analysis\": {" +
//                "    \"switch\": \"0\" \n" +
//                "  }\n" +
//                "} }";
//        String quoteString = URLEncoder.encode(params_dict, "utf-8");
//        parameters_dict.put("params_dict", quoteString);
        String response = sendPost(host, uri, author, parameters_dict);

        System.out.println("Get Result: " + response);
    }
}

