package it.epicode.s5.g1.bean;


import lombok.*;

@Data
public abstract class Prodotto{

    private String nome;
    private double price;
    private int colories;

    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                ", price=" + price +
                ", colories=" + colories +
                '}';
    }
}
