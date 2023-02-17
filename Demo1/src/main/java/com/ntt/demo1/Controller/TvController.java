package com.ntt.demo1.Controller;

import com.ntt.demo1.Domain.Canale;
import com.ntt.demo1.Domain.Tv;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
@RestController
@RequestMapping("/tv")
public class TvController {

    @GetMapping("/tv")
    public ResponseEntity<Tv> returnTv() {

        ArrayList<Canale> listaCanali = new ArrayList<>();
        listaCanali.add(new Canale("Rete 4", 4));
        listaCanali.add(new Canale("Canale 5", 5));
        listaCanali.add(new Canale("Rai 3", 3));
        Tv tv = new Tv("Lg", "Rosa", listaCanali );
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }
    @PostMapping("/tv")
    public ResponseEntity<?> createTv(@RequestBody Tv tv){
        return new ResponseEntity<>(tv,HttpStatus.CREATED);
    }
    @PutMapping("/add")public ResponseEntity<Tv>
    addCh(@RequestBody Canale canale)
    {    Tv tv = new Tv("Philips", "Blu", new ArrayList<Canale>());
        tv.addChannel(canale);
        return new ResponseEntity<>(tv, HttpStatus.OK);}

    @DeleteMapping("/rm")public ResponseEntity<Tv>
    addRem(@RequestBody String nome)
    {    Tv tv = new Tv("Blu", "Samsung", new ArrayList<Canale>());

        tv.removeChannel(nome);
        return new ResponseEntity<>(tv, HttpStatus.OK);}

}
