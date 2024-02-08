package it.epicode.s5.g1.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;


@Entity
@Data
public class Ingrediente extends  Prodotto{
    @ManyToMany(mappedBy = "ingredienti")
   private List<Pizza> pizze;
    @Override
    public String toString() {
        return
                super.getNome();
    }
}
