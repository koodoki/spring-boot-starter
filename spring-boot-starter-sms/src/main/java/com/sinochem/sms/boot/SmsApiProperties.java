package com.sinochem.sms.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.sms.api")
public class SmsApiProperties {

    /**
     * 发送验证码接口
     */
    private String sendUrl = "https://api.netease.im/sms/sendcode.action";
    /**
     * 校验验证码接口
     */
    private String verifyUrl = "https://api.netease.im/sms/verifycode.action";
    /**
     * 开发者平台分配的app key
     */
    private String appKey = "";
    /**
     * 开发者平台分配的app secret
     */
    private String appSecret = "";

    /**
     * 短信验证码长度；范围4～10
     */
    private int codeLength = 4;

    private int nonceLength = 16;

    public String getSendUrl() {
        return sendUrl;
    }

    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl;
    }

    public String getVerifyUrl() {
        return verifyUrl;
    }

    public void setVerifyUrl(String verifyUrl) {
        this.verifyUrl = verifyUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public int getNonceLength() {
        return nonceLength;
    }

    public void setNonceLength(int nonceLength) {
        this.nonceLength = nonceLength;
    }
}
