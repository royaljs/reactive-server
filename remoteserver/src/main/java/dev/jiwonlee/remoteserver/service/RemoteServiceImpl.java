package dev.jiwonlee.remoteserver.service;

import org.springframework.stereotype.Service;

@Service
public class RemoteServiceImpl implements RemoteService {

    @Override
    public String test() throws InterruptedException {
        /**
         * 원격 서비스 비즈니스 로직 처리 1초 가정
         */
        Thread.sleep(1000);
        return "OK";
    }

}
