package com.hthyaq.learnadmin.common.sample_java;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;



public class Signer {

    private String ak = "";
    private String sk = "";
    private String version = "1";
    private String timestamp = "";
    private int expirationPeriodInSeconds = 0;
    private String method = "";
    private String uri = "";
    private Map<String, List<String>> params = new TreeMap<String, List<String>>();
    private Map<String, String> headers = new TreeMap<String, String>(); // only sign headers

    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String DEFAULT_HASH = "HmacSHA256";
    private static final Pattern ENCODED_CHARACTERS_PATTERN;

    static {
        StringBuilder pattern = new StringBuilder();
        pattern.append(Pattern.quote("+"))
                .append("|")
                .append(Pattern.quote("*"))
                .append("|")
                .append(Pattern.quote("%7E"))
                .append("|")
                .append(Pattern.quote("%2F"));
        ENCODED_CHARACTERS_PATTERN = Pattern.compile(pattern.toString());
    }

    public String genAuthorization() {
        String signature = genSignature();
        String authStr = "bce-auth-v"
                + this.version + "/" + this.ak
                + "/" + this.timestamp + "/"
                + String.valueOf(this.expirationPeriodInSeconds)
                + "/" + getSignHeaderNames() + "/"
                + signature;
        return authStr;
    }
    public String genSignature() {
        String signingKey = genSigningKey();
        if (this.method == null || this.method.isEmpty()) {
            System.out.println("method is null or empty");
            throw new SignerException("method is null or empty");
        }
        String autStr = this.method + "\n"
                + getCanonicalURI() + "\n"
                + getCanonicalParam() + "\n"
                + getCanonicalHeaders();
        return sha256Hex(signingKey, autStr);
    }
    public Signer withAccessKey(String ak) {
        if (ak != null) {
            this.ak = ak;
        } else {
            this.ak = "";
        }
        return this;
    }
    public Signer withSecretKey(String sk) {
        this.sk = sk;
        return this;
    }
    public Signer withVersion(String version) {
        this.version = version;
        return this;
    }
    public Signer withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    public Signer withExpire(int expiration) {
        this.expirationPeriodInSeconds = expiration;
        return this;
    }
    public Signer withMethod(String method) {
        if (method != null) {
            this.method = method.toUpperCase();
        }
        return this;
    }
    public Signer withUri(String uri) {
        this.uri = uri;
        return this;
    }
    public Signer withParams(Map<String, String> signParams) {
        this.params = normalizeParams(signParams);
        return this;
    }
    public void addParam(String key, String value) {
        if (key == null || key.toLowerCase().equals("authorization")) {
            return;
        }
        List<String> valueList = this.params.get(key);
        if (valueList == null) {
            valueList = new ArrayList<String>();
            this.params.put(urlEncode(key, false), valueList);
        }
        valueList.add(urlEncode(value, false));
    }
    public Signer withExtParams(Map<String, List<String>> signParams) {
        this.params = normalizeExtParams(signParams);
        return this;
    }
    public Signer withSignHeaders(Map<String, String> signHeaders) {
        this.headers = normalizeHeaders(signHeaders);
        return this;
    }
    public static String sha256Hex(String signingKey, String stringToSign) {
        try {
            Mac mac = Mac.getInstance(DEFAULT_HASH);
            mac.init(new SecretKeySpec(signingKey.getBytes(DEFAULT_ENCODING), DEFAULT_HASH));
            return bytesToHex(mac.doFinal(stringToSign.getBytes(DEFAULT_ENCODING)));
        } catch (Exception ex) {
            System.out.println("sha256 exception for (" + signingKey + "," + stringToSign + ")");
            throw new SignerException("sha256Hex excetion, error message is : " + ex.getMessage());
        }
    }
    private static String bytesToHex(byte[] data) {
        if (data == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (byte aData : data) {
            String hex = Integer.toHexString(aData);
            if (hex.length() == 1) {
                // Append leading zero.
                sb.append("0");
            } else if (hex.length() == 8) {
                // Remove ff prefix from negative numbers.
                hex = hex.substring(6);
            }
            sb.append(hex);
        }
        return sb.toString().toLowerCase(Locale.getDefault());
    }
    public String genSigningKey() {
        if (this.ak == null || this.ak.isEmpty()) {
            System.out.println("access key is null or empty");
            throw new SignerException("access key is null or empty");
        }
        if (this.sk == null || this.sk.isEmpty()) {
            System.out.println("secret key is null or empty");
            throw new SignerException("secret key is null or empty");
        }
        if (this.timestamp == null || this.timestamp.isEmpty()) {
            System.out.println("timestamp is null or empty");
            throw new SignerException("timestamp is null or empty");
        }
        String authStr = "bce-auth-v" + this.version + "/" + this.ak + "/"
                + this.timestamp + "/" + String.valueOf(this.expirationPeriodInSeconds);
        return sha256Hex(this.sk, authStr);
    }
    private String urlEncode(final String value, final boolean path) {
        if (value == null) {
            return "";
        }
        try {
            String encoded = URLEncoder.encode(value, DEFAULT_ENCODING);
            Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(encoded);
            StringBuffer sb = new StringBuffer(encoded.length());
            while (matcher.find()) {
                String replacement = matcher.group(0);
                if ("+".equals(replacement)) {
                    replacement = "%20";
                } else if ("*".equals(replacement)) {
                    replacement = "%2A";
                } else if ("%7E".equals(replacement)) {
                    replacement = "~";
                } else if (path && "%2F".equals(replacement)) {
                    replacement = "/";
                }
                matcher.appendReplacement(sb, replacement);
            }
            matcher.appendTail(sb);
            return sb.toString();
        } catch (UnsupportedEncodingException ex) {
            System.out.println("url encode error [" + value + "]");
            throw new SignerException("url encode error, error merssage is : " + ex.getMessage());
        }
    }
    private SortedMap<String, List<String>> normalizeParams(Map<String, String> signParams) {
        SortedMap<String, List<String>> sorted = new TreeMap<String, List<String>>();
        if (signParams != null) {
            for (Map.Entry<String, String> queryString : signParams.entrySet()) {
                if (queryString.getKey() == null || queryString.getKey().toLowerCase().equals("authorization")) {
                    continue;
                }
                List<String> valueList = new ArrayList<String>();
                valueList.add(urlEncode(queryString.getValue(), false));
                sorted.put(urlEncode(queryString.getKey(), false), valueList);
            }
        }
        return sorted;
    }
    private SortedMap<String, List<String>> normalizeExtParams(Map<String, List<String>> signParams) {
        SortedMap<String, List<String>> sorted = new TreeMap<String, List<String>>();
        if (signParams != null) {
            for (Map.Entry<String, List<String>> queryString : signParams.entrySet()) {
                if (queryString.getKey() == null || queryString.getKey().toLowerCase().equals("authorization")) {
                    continue;
                }
                List<String> valueList = queryString.getValue();
                if (valueList == null) {
                    continue;
                }
                Iterator<String> itr = valueList.iterator();
                List<String> newValueList = new ArrayList<String>();
                while (itr.hasNext()) {
                    String value = itr.next();
                    if (value != null) {
                        newValueList.add(urlEncode(value, false));
                    }
                }
                sorted.put(urlEncode(queryString.getKey(), false), newValueList);
            }
        }
        return sorted;
    }
    public String getCanonicalParam() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, List<String>>> pairs = this.params.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, List<String>> pair = pairs.next();
            List<String> valueList = pair.getValue();
            if (valueList.size() == 0) {
                sb.append(pair.getKey() + "=");
            }
            Collections.sort(valueList);
            Iterator<String> itr = valueList.iterator();
            while (itr.hasNext()) {
                String value = itr.next();
                sb.append(pair.getKey());
                sb.append("=");
                sb.append(value);
                if (itr.hasNext()) {
                    sb.append("&");
                }
            }
            if (pairs.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }
    public String getCanonicalURI() {
        if (this.uri == null || this.uri.isEmpty()) {
            System.out.println("uri is null or empty");
            throw new SignerException("uri is null or empty");
        } else {
            String value = urlEncode(this.uri, true);
            if (value.startsWith("/")) {
                return value;
            } else {
                return "/".concat(value);
            }
        }
    }
    private SortedMap<String, String> normalizeHeaders(Map<String, String> signHeaders) {
        SortedMap<String, String> sorted = new TreeMap<String, String>();
        if (signHeaders != null) {
            for (Map.Entry<String, String> stringStringEntry : signHeaders.entrySet()) {
                if (stringStringEntry.getKey() == null) {
                    continue;
                }
                String key = stringStringEntry.getKey().toLowerCase();
                if (key.isEmpty()) {
                    continue;
                }
                sorted.put(key,
                        urlEncode(stringStringEntry.getValue().trim(), false));
            }
        }
        return sorted;
    }
    private String getSignHeaderNames() {
        if (this.headers != null) {
            StringBuilder sb = new StringBuilder("");
            Iterator<Map.Entry<String, String>> pairs = this.headers.entrySet().iterator();
            while (pairs.hasNext()) {
                Map.Entry<String, String> pair = pairs.next();
                sb.append(pair.getKey());
                if (pairs.hasNext()) {
                    sb.append(";");
                }
            }
            return sb.toString();
        }
        return "";
    }
    public String getCanonicalHeaders() {
        if (!this.headers.containsKey("host")) {
            System.out.println("no host in headers");
            throw new SignerException("no host in headers");
        }
        StringBuilder sb = new StringBuilder("");
        List<String> kvList = new ArrayList<String>();
        Iterator<Map.Entry<String, String>> pairs = this.headers.entrySet().iterator();
        while (pairs.hasNext()) {
            StringBuilder kv = new StringBuilder("");
            Map.Entry<String, String> pair = pairs.next();
            if (!pair.getValue().isEmpty()) {
                kv.append(urlEncode(pair.getKey(), false));
                kv.append(":");
                kv.append(pair.getValue());
                kvList.add(kv.toString());
            }
        }
        Iterator<String> itr = kvList.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next());
            if (itr.hasNext()) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
