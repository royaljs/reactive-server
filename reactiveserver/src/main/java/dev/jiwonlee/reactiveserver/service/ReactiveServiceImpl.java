package dev.jiwonlee.reactiveserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class ReactiveServiceImpl implements ReactiveService {

    private RestTemplate restTemplate;

    @Autowired
    public ReactiveServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String restTemplate() {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> request = new HttpEntity<>(header);
        ResponseEntity<String> responseDto = restTemplate
                .exchange(
                        "/",
                        HttpMethod.GET,
                        request,
                        String.class);
        return responseDto.getBody();
    }

    @Override
    public String asyncRestTemplate() {
        return null;
    }

    @Override
    public String future() {
        return null;
    }

    @Override
    public String completableFuture() {
        return null;
    }

    @Override
    public String listenableFuture() {
        return null;
    }

    @Override
    public String deferedResult() {
        return null;
    }

    @Override
    public String webclient() {
        return null;
    }

}
