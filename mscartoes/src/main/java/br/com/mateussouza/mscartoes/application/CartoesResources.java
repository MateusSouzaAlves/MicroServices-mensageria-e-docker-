package br.com.mateussouza.mscartoes.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
public class CartoesResources {

    @GetMapping
    public String status(){
        return "ok";
    }
}
