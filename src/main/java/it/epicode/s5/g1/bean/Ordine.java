package it.epicode.s5.g1.bean;


import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



@Data
public class Ordine {

    private List<Pizza> pizze;
    private List<Bevanda> drinks;
    private static int contatore = 1;
    private int numeroOrdine;
    private Stato statoOrdine;
    private int numeroCoperti;
    private LocalTime acqusizione;
    private Tavolo tavolo;
    private double importoMassimo;



    public double totaleOrdine(){
        double totale = tavolo.getCostoCoperto()*numeroCoperti;

        totale = totale + pizze.stream().mapToDouble(Pizza::getPrice).sum() +
                drinks.stream().mapToDouble(Bevanda::getPrice).sum();
                return totale;
    }

    public Ordine(Tavolo tavolo, int numeroCoperti) throws Exception{
        if (numeroCoperti <= tavolo.getNumeroMassimo())
            this.numeroCoperti = numeroCoperti;
        else
                throw new Exception("Numero Massimo coperti superato");

        if (tavolo.getStatoTavolo().equals(StatoTavolo.LIBERO))
            this.tavolo = tavolo;
        else
            throw  new Exception("Tavolo occupato");

        numeroOrdine = contatore++;
        statoOrdine = Stato.IN_CORSO;
        acqusizione = LocalTime.now();
        drinks = new ArrayList<>();
        pizze= new ArrayList<>();

    }
}
