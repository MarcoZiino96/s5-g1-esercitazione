package it.epicode.s5.g1.bean;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Entity
@Data
public class Pizza extends Prodotto{
    @ManyToMany
    @JoinTable(
            name = "aggiunte",
            joinColumns = @JoinColumn(name = "id_pizza"),
            inverseJoinColumns = @JoinColumn(name = "id_ingrediente")
    )
    private List<Prodotto> ingredienti;

    @Override
    public String toString() {
        return  super.toString();
    }

}
