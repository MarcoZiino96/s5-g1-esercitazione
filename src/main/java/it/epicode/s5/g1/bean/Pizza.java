package it.epicode.s5.g1.bean;


import lombok.*;

import java.util.List;

@Data
public class Pizza extends Prodotto{
    private List<Prodotto> ingredienti;

    @Override
    public String toString() {
        return  super.toString()+
                "ingredienti=" + ingredienti +
                '}';
    }

    public void setPrice(){
        setPrice(ingredienti.stream().);
    }
}
