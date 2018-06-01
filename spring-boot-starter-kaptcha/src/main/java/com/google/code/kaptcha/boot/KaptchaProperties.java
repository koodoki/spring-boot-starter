package com.google.code.kaptcha.boot;

import com.google.code.kaptcha.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.kaptcha")
public class KaptchaProperties {

    private String urlMappings = "/captcha.jpg";

    private String sessionKey = Constants.KAPTCHA_SESSION_KEY;
    private String sessionDate = Constants.KAPTCHA_SESSION_DATE;

    private boolean border = false;
    private String borderColor = "black";
    private String borderThickness = "1";

    private String noiseColor = "black";
    private String noiseImpl = "com.google.code.kaptcha.impl.DefaultNoise";

    private String obscurificatorImpl = "com.google.code.kaptcha.impl.WaterRipple";

    private String producerImpl = "com.google.code.kaptcha.impl.DefaultKaptcha";

    private String textProducerImpl = "com.google.code.kaptcha.text.impl.DefaultTextCreator";
    private String textProducerCharString = "abcdefghijklmnopqrstuvwxyz0123456789";
    private String textProducerCharLength = "5";
    private String textProducerCharSpace = "2";
    private String textProducerFontNames = "Arial,Courier";
    private String textProducerFontColor = "black";
    private String textProducerFontSize = "40";

    private String wordImpl = "com.google.code.kaptcha.text.impl.DefaultWordRenderer";

    private String backgroundImpl = "com.google.code.kaptcha.impl.DefaultBackground";
    private String backgroundClearFrom = "lightGray";
    private String backgroundClearTo = "white";

    private String imageWidth = "200";
    private String imageHeight = "50";

    public String getUrlMappings() {
        return urlMappings;
    }

    public void setUrlMappings(String urlMappings) {
        this.urlMappings = urlMappings;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public boolean getBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(String borderThickness) {
        this.borderThickness = borderThickness;
    }

    public String getNoiseColor() {
        return noiseColor;
    }

    public void setNoiseColor(String noiseColor) {
        this.noiseColor = noiseColor;
    }

    public String getNoiseImpl() {
        return noiseImpl;
    }

    public void setNoiseImpl(String noiseImpl) {
        this.noiseImpl = noiseImpl;
    }

    public String getObscurificatorImpl() {
        return obscurificatorImpl;
    }

    public void setObscurificatorImpl(String obscurificatorImpl) {
        this.obscurificatorImpl = obscurificatorImpl;
    }

    public String getProducerImpl() {
        return producerImpl;
    }

    public void setProducerImpl(String producerImpl) {
        this.producerImpl = producerImpl;
    }

    public String getTextProducerImpl() {
        return textProducerImpl;
    }

    public void setTextProducerImpl(String textProducerImpl) {
        this.textProducerImpl = textProducerImpl;
    }

    public String getTextProducerCharString() {
        return textProducerCharString;
    }

    public void setTextProducerCharString(String textProducerCharString) {
        this.textProducerCharString = textProducerCharString;
    }

    public String getTextProducerCharLength() {
        return textProducerCharLength;
    }

    public void setTextProducerCharLength(String textProducerCharLength) {
        this.textProducerCharLength = textProducerCharLength;
    }

    public String getTextProducerCharSpace() {
        return textProducerCharSpace;
    }

    public void setTextProducerCharSpace(String textProducerCharSpace) {
        this.textProducerCharSpace = textProducerCharSpace;
    }

    public String getTextProducerFontNames() {
        return textProducerFontNames;
    }

    public void setTextProducerFontNames(String textProducerFontNames) {
        this.textProducerFontNames = textProducerFontNames;
    }

    public String getTextProducerFontColor() {
        return textProducerFontColor;
    }

    public void setTextProducerFontColor(String textProducerFontColor) {
        this.textProducerFontColor = textProducerFontColor;
    }

    public String getTextProducerFontSize() {
        return textProducerFontSize;
    }

    public void setTextProducerFontSize(String textProducerFontSize) {
        this.textProducerFontSize = textProducerFontSize;
    }

    public String getWordImpl() {
        return wordImpl;
    }

    public void setWordImpl(String wordImpl) {
        this.wordImpl = wordImpl;
    }

    public String getBackgroundImpl() {
        return backgroundImpl;
    }

    public void setBackgroundImpl(String backgroundImpl) {
        this.backgroundImpl = backgroundImpl;
    }

    public String getBackgroundClearFrom() {
        return backgroundClearFrom;
    }

    public void setBackgroundClearFrom(String backgroundClearFrom) {
        this.backgroundClearFrom = backgroundClearFrom;
    }

    public String getBackgroundClearTo() {
        return backgroundClearTo;
    }

    public void setBackgroundClearTo(String backgroundClearTo) {
        this.backgroundClearTo = backgroundClearTo;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }
}
