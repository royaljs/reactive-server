package dev.jiwonlee.reactiveserver.service;

public interface ReactiveService {

    public String restTemplate();

    public String asyncRestTemplate();

    public String future();

    public String completableFuture();

    public String listenableFuture();

    public String deferedResult();

    public String webclient();

}
