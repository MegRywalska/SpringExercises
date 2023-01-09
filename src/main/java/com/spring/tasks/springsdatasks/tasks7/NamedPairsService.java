package com.spring.tasks.springsdatasks.tasks7;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
@Builder
@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class NamedPairsService {

    private NamedPairs namedPairs;
    private String name;
    private Map<String, String>pairs;

    public NamedPairs getNamedEmptyPairs(String name){

        return NamedPairs.builder()
                .name(name)
                .pairs(Map.of())
                .build();

    }

    public static NamedPairsService fromNamedPairsService(NamedPairs namedPairs){
        return NamedPairsService.builder()
                .name(namedPairs.getName())
                .pairs(namedPairs.getPairs())
                .build();

    }


}
