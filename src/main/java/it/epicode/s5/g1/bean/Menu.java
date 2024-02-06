package it.epicode.s5.g1.bean;

import lombok.Data;

import java.util.List;




@Data
public class Menu {
    private  List<Pizza> pizzas;
    private  List<Ingrediente> toppings;
    private  List<Bevanda> drinks;

    public void stampaMenu(){
        System.out.println("PIZZE");
        pizzas.stream().forEach(pizza -> System.out.println(pizza.getNome() +
                ", calorie: " + pizza.getColories() + ", prezzo: " +pizza.getPrice()));

        System.out.println();
        System.out.println("TOPPINGS");
        toppings.stream().forEach(topping -> System.out.println(topping.getNome() +
                ", calorie: " + topping.getColories() + ", prezzo: " +topping.getPrice()));

        System.out.println();
        System.out.println("DRINKS");
        drinks.stream().forEach(drink -> System.out.println(drink.getNome() +
                ", calorie: " + drink.getColories() + ", prezzo: " +drink.getPrice()));
    }
}
