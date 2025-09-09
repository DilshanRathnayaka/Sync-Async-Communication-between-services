package com.communication2.communication2.service.helper.impl;

import com.communication2.communication2.service.helper.RestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestTemplateImpl implements RestTemplate {

    private final org.springframework.web.client.RestTemplate restTemplate;

    public <T> T get(String url, Class<T> responseType) {
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), responseType).getBody();
    }

    public <T> T post(String url, Class<T> responseType) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(new HttpHeaders()), responseType).getBody();
    }

    //... other methods
}
