package com.jeenguyen.demo.web.model;

/**
 * Created by jeebb on 24/11/2014.
 */
public class RefreshTokenResult {

    private String accessToken;
    private Boolean isSuccess = true;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
