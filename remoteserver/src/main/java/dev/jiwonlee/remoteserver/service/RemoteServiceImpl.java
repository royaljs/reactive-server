package dev.jiwonlee.remoteserver.service;

import org.springframework.stereotype.Service;

@Service
public class RemoteServiceImpl implements RemoteService {

    @Override
    public String test() throws InterruptedException {
        Thread.sleep(1000);
        return "OK";
    }

}
