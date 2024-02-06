package it.epicode.s5.g1.bean;


import lombok.*;

@Data
public class Bevanda extends Prodotto{
    @Override
    public String toString() {
        return "Bevanda{" +
                super.toString() +
                "}";
    }
}
