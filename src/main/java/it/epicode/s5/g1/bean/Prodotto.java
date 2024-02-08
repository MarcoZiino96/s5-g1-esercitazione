package it.epicode.s5.g1.bean;


import jakarta.persistence.*;
import lombok.*;




@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Prodotto{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
