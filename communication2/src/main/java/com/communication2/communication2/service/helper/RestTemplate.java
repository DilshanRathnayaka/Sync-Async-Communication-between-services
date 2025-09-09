package com.communication2.communication2.service.helper;

public interface RestTemplate {

    <T> T get(String url, Class<T> responseType);
}
