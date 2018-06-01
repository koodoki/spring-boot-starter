package com.google.code.kaptcha.boot;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnClass(value = KaptchaServlet.class)
@EnableConfigurationProperties(value = KaptchaProperties.class)
@Configuration
public class KaptchaAutoConfiguration {

    @Bean
    public ServletRegistrationBean kaptchaServlet(KaptchaProperties properties) {
        final ServletRegistrationBean bean = new ServletRegistrationBean(new KaptchaServlet());
        bean.addUrlMappings(resolve(properties.getUrlMappings()));

        bean.addInitParameter(Constants.KAPTCHA_BORDER, properties.getBorder() ? "yes" : "no");
        bean.addInitParameter(Constants.KAPTCHA_BORDER_COLOR, properties.getBorderColor());
        bean.addInitParameter(Constants.KAPTCHA_BORDER_THICKNESS, properties.getBorderThickness());

        bean.addInitParameter(Constants.KAPTCHA_NOISE_COLOR, properties.getNoiseColor());
        bean.addInitParameter(Constants.KAPTCHA_NOISE_IMPL, properties.getNoiseImpl());

        bean.addInitParameter(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, properties.getObscurificatorImpl());

        bean.addInitParameter(Constants.KAPTCHA_PRODUCER_IMPL, properties.getProducerImpl());

        bean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_IMPL, properties.getTextProducerImpl());
        bean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, properties.getTextProducerCharString());
        bean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, properties.getTextProducerCharLength());
        bean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, properties.getTextProducerCharSpace());
        bean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, properties.getTextProducerFontNames());
        bean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, properties.getTextProducerFontColor());
        bean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, properties.getTextProducerFontSize());

        bean.addInitParameter(Constants.KAPTCHA_WORDRENDERER_IMPL, properties.getWordImpl());

        bean.addInitParameter(Constants.KAPTCHA_BACKGROUND_IMPL, properties.getBackgroundImpl());
        bean.addInitParameter(Constants.KAPTCHA_BACKGROUND_CLR_FROM, properties.getBackgroundClearFrom());
        bean.addInitParameter(Constants.KAPTCHA_BACKGROUND_CLR_TO, properties.getBackgroundClearTo());

        bean.addInitParameter(Constants.KAPTCHA_IMAGE_WIDTH, properties.getImageWidth());
        bean.addInitParameter(Constants.KAPTCHA_IMAGE_HEIGHT, properties.getImageHeight());

        bean.addInitParameter(Constants.KAPTCHA_SESSION_CONFIG_KEY, properties.getSessionKey());
        bean.addInitParameter(Constants.KAPTCHA_SESSION_CONFIG_DATE, properties.getSessionDate());

        return bean;
    }

    private static String[] resolve(String urlMappings) {
        return urlMappings.split(",");
    }
}
