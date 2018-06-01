package com.sinochem.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinochem.sms.boot.SmsApiProperties;
import com.sinochem.sms.boot.SmsNetProperties;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SmsSendRepository {

    private static final Logger logger = LoggerFactory.getLogger(SmsSendRepository.class);

    private final SmsApiProperties apiProperties;
    private OkHttpClient client;

    public SmsSendRepository(SmsApiProperties apiProperties, SmsNetProperties netProperties) {
        this.apiProperties = apiProperties;

        client = new OkHttpClient.Builder()
                .connectTimeout(netProperties.getConnectTimeoutMillis(), TimeUnit.MILLISECONDS)
                .readTimeout(netProperties.getReadTimeoutMillis(), TimeUnit.MILLISECONDS)
                .writeTimeout(netProperties.getWriteTimeoutMillis(), TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(netProperties.isRetryOnConnectionFailure())
                .followRedirects(netProperties.isFollowRedirects())
                .build();
    }

    public boolean sendCode(String templateId, String mobile) throws IOException {
        logger.info("send sms code to mobile {}", mobile);
        final String nonce = randNonce(apiProperties.getNonceLength());
        final String curTime = String.valueOf(System.currentTimeMillis() / 1000);
        final String checkSum = CheckSumBuilder.getCheckSum(apiProperties.getAppSecret(), nonce, curTime);

        FormBody.Builder body = new FormBody.Builder(Charset.forName("UTF-8"))
                .add("mobile", mobile)
                .add("codeLen", String.valueOf(apiProperties.getCodeLength()));
        if (templateId != null
                && templateId.trim().length() > 0) {
            body.add("templateid", templateId);
        }

        Request request = new Request.Builder()
                .url(apiProperties.getSendUrl())
                .addHeader("AppKey", apiProperties.getAppKey())
                .addHeader("Nonce", nonce)
                .addHeader("CurTime", curTime)
                .addHeader("CheckSum", checkSum)
                .post(body.build())
                .build();

        Response response = client.newCall(request).execute();
        if (response.code() == HttpURLConnection.HTTP_OK) {
            String bodyString = response.body().string();
            logger.info("send sms code response {}", bodyString);
            ResponseBody responseBody = new ObjectMapper().readValue(bodyString, ResponseBody.class);
            return responseBody.getCode() == 200;
        }
        return false;
    }

    public boolean verifyCode(String mobile, String code) throws IOException {
        logger.info("verify sms code, mobile {}, code {}", mobile, code);
        final String nonce = randNonce(apiProperties.getNonceLength());
        final String curTime = String.valueOf(System.currentTimeMillis() / 1000);
        final String checkSum = CheckSumBuilder.getCheckSum(apiProperties.getAppSecret(), nonce, curTime);

        RequestBody body = new FormBody.Builder(Charset.forName("UTF-8"))
                .add("mobile", mobile)
                .add("code", code)
                .build();

        Request request = new Request.Builder()
                .url(apiProperties.getVerifyUrl())
                .addHeader("AppKey", apiProperties.getAppKey())
                .addHeader("Nonce", nonce)
                .addHeader("CurTime", curTime)
                .addHeader("CheckSum", checkSum)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        if (response.code() == HttpURLConnection.HTTP_OK) {
            String bodyString = response.body().string();
            logger.info("verify sms code response {}", bodyString);
            ResponseBody responseBody = new ObjectMapper().readValue(bodyString, ResponseBody.class);
            return responseBody.getCode() == 200;
        }
        return true;
    }

    private String randNonce(int length) {
        final StringBuilder builder = new StringBuilder();
        final Random random = new Random();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(2);
            switch (number) {
                case 0: {
                    final int value = (int) Math.round(Math.random() * 25 + 97);
                    builder.append((char) value);
                    break;
                }
                case 1: {
                    builder.append(random.nextInt(10));
                    break;
                }
            }
        }
        return builder.toString();
    }

}
