package it.epicode.s5.g1.bean;


import lombok.*;

@Data
public class Ingrediente extends  Prodotto {
    @Override
    public String toString() {
        return
                super.getNome();
    }
}
