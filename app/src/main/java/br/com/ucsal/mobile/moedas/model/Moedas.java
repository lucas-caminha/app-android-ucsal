package br.com.ucsal.mobile.moedas.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Moedas {

    private List<Moeda> moedas;

    public Moedas(){
        this.moedas = new ArrayList<>();
    }

    public List<Moeda> getMoedas() {
        return moedas;
    }

    public void setMoedas(List<Moeda> moedas) {
        this.moedas = moedas;
    }

}
