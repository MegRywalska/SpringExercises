package com.spring.tasks.springsdatasks.tasks7;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class NamedPairsService {

    private NamedPairs namedPairs;

    public NamedPairsService getNamedEmptyPairs(String name){

//        return NamedPairs.builder()
//                .name(name)
//                .pairs(Map.of())
//                .build();
//
        return null;
    }
}
