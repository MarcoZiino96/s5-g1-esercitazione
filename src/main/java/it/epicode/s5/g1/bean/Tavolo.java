package it.epicode.s5.g1.bean;


import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;



@Data
public class Tavolo {
    private int numeroTavolo;
    private int numeroMassimo;
    private StatoTavolo statoTavolo;
    private double costoCoperto;
}
