package com.spring.tasks.springsdatasks.tasks8;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class RandomBooleanProviderController {

    private final RandomBooleanProvider randomBooleanProvider;

    @GetMapping("/random-boolean")
    public boolean getRandomBoolean(){
        return randomBooleanProvider.getValue();
    }
}
