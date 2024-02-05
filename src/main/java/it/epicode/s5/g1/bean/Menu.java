package it.epicode.s5.g1.bean;

import lombok.Data;

import java.util.List;



@Data
public class Menu {
    private  List<Pizza> pizzas;
    private  List<Ingrediente> toppings;
}
