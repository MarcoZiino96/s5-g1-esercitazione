package it.epicode.s5.g1.bean;


import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Component("ordine")
@Data
public class Ordine {

    private List<Prodotto> elementiMenu = new ArrayList<>();
    private int numeroOrdine;
    private Stato statoOrdine;
    private int numeroCoperti;
    private double costoCoperto;
    private LocalTime acqusizione;

    @Autowired
    @Qualifier("tavolo")
    private Tavolo tavolo;
    private double importoMassimo;

    @PostConstruct
    public void importoMassimo(){
        if (elementiMenu != null){
           importoMassimo = (numeroCoperti * costoCoperto) + (elementiMenu.stream().mapToDouble(Prodotto::getPrice).reduce(0,Double::sum));
        }else{
            importoMassimo = 0;
        }
    }
}
