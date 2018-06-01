package com.sinochem.sms.boot;

import com.sinochem.sms.SmsSendRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {SmsApiProperties.class, SmsNetProperties.class})
@Configuration
public class SmsAutoConfiguration {

    @Bean
    public SmsSendRepository smsRepository(SmsApiProperties apiProperties, SmsNetProperties netProperties) {
        return new SmsSendRepository(apiProperties, netProperties);
    }

}
