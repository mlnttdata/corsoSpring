package com.ntt.demo1.Controller;

import com.ntt.demo1.Domain.Canale;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class CanaleController {

    @GetMapping("/Canale")
    public ResponseEntity<Canale> returnCanale(){
        Canale canale = new Canale();
        canale.setNome("Italia 1");
        canale.setNumero(6);
        return new ResponseEntity<>(canale, HttpStatus.OK);
    }

    @GetMapping("/ciao3")
    public ResponseEntity<Map<String,String>> returnMap(){
        Map<String,String> mappa = new HashMap<>();
        mappa.put("ciao","ciao");
        ResponseEntity<Map<String,String>> responseEntity = new ResponseEntity<>(mappa,HttpStatus.OK);
        return  responseEntity;
    }

    @PostMapping("/Canale")
    public ResponseEntity<?> createCanale(@RequestBody Canale canale){

        return new ResponseEntity<>(canale,HttpStatus.CREATED);

    }


}
