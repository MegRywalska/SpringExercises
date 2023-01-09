package com.spring.tasks.springsdatasks.tasks7;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.spring.tasks.springsdatasks.tasks7.NamedPairsService.fromNamedPairsService;

@RequiredArgsConstructor
@RequestMapping("/app/pairs")
@Controller
public class NamedPairsController {

    private NamedPairsService namedPairsService;

    @GetMapping("/{name}")
    public NamedPairsService getNamedPairsJSON(@PathVariable final String name){
        return fromNamedPairsService(namedPairsService.getNamedEmptyPairs(name)) ;
    }
}
