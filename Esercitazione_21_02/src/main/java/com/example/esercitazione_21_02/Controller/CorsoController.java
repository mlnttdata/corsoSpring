package com.example.esercitazione_21_02.Controller;

import com.example.esercitazione_21_02.Domain.Corso;
import com.example.esercitazione_21_02.Repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping()
    public class CorsoController {
        @Autowired
        CorsoRepository corsoRepository;

        @GetMapping("/corso")public ResponseEntity<?> returnCorso() {
            Corso corso = new Corso();
            //corso.setId(1L);
            //corso.setNome("Italiano");
            //corso.setDescrizione("Grammatica e letteratura italiana");

            List<Corso> listaCorsi = corsoRepository.findAll();

            return new ResponseEntity<>(listaCorsi, HttpStatus.OK);
        }


        @PostMapping("/corso")
        public ResponseEntity<?> createCorso(@RequestBody Corso corso)
        {
            Corso corso1 = corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);}

        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteCorso(@PathVariable("id") long id) {
            corsoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);    }

        @PutMapping("{id}")
        public ResponseEntity<?> updateCorso(@PathVariable("id") long id, @RequestBody Corso corso) {
            List<Corso> lista = corsoRepository.findAll();
            boolean b = false;
            for (Corso c : lista) {
                if (c.getId() == corso.getId()) {
                    b = true;
                }
            }
            if (b) {
                return new ResponseEntity<>("Errore duplicato", HttpStatus.OK);
            }else{
                    Corso corso1 = corsoRepository.save(corso);
                    return new ResponseEntity<>(corso1, HttpStatus.CREATED);
                }

            }
        @PostMapping("/controllo")
        public ResponseEntity<?> createControllo(@RequestBody Corso corso){
            if (corso.getNome().substring(0,6).equals("corso") && corso.getNome().length()>=7){
                Corso corso1 = corsoRepository.save(corso);
                return new ResponseEntity<>(corso1, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Nome errato", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    @GetMapping("/corsi")
    public ResponseEntity<?> findAll() {
            List<Corso> corsi = corsoRepository.findAll();
            return new ResponseEntity<>(corsi, HttpStatus.OK);
        }

    @GetMapping("/checkNumeri")
    public ResponseEntity<?> getNum() {
        List<Corso> lista = corsoRepository.findAll();
        int i = lista.size();
        return new ResponseEntity<>(i , HttpStatus.OK);}

    @GetMapping("/campi")
    public ResponseEntity<?> getCampi() {
        List<Corso> lista = corsoRepository.findAll();
        String campiC = null;
        String sc;
        for(Corso c: lista){
            sc = c.toString();
            campiC = campiC +sc;
        }
        return new ResponseEntity<>(campiC , HttpStatus.OK);}

    @GetMapping("/desc")
    public ResponseEntity<?> getCorsi() {
        List<Corso> corsi = corsoRepository.findAll();
        List<Corso> corsi1 = new ArrayList<>();
        int i=0;    for(Corso corso: corsi){
            if(corso.getDescrizione().length() > 20)
            {
                corsi1.add(corso);        }
        }    return new ResponseEntity<>(corsi1 , HttpStatus.OK);}

    @GetMapping("/corsi_")
    public ResponseEntity<?> getCorsi1(){
        List<Corso> corsi = corsoRepository.findAll();
        int conta = 0;
        for(Corso c : corsi){
            if(c.getNome().substring(0,6).equals("corso_")){
                conta++;        }    }
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }
}

