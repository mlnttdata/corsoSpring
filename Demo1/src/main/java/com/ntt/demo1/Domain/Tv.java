package com.ntt.demo1.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tv extends Monitor{

    ArrayList<Canale> listaCanali = new ArrayList<Canale>();

    public Tv(String marca, String colore, ArrayList<Canale> listaCanali) {
        super(marca, colore);
        this.listaCanali = listaCanali;
    }

    public void addChannel(Canale canale){
        try {
            for (Canale can : listaCanali) {
                if (can.getNome().equals(canale.getNome())) {
                    throw new Exception("Canale già inserito");
                }
                listaCanali.add(canale);
            }
        }catch (Exception e){
            System.out.println("Canale inserito");
        }
        }

    public void removeChannel(String nome) {
        for(int i=0; i < listaCanali.size(); i++){
            if(listaCanali.get(i).getNome().equals(nome)){
                listaCanali.remove(i);        }    }}
    }

