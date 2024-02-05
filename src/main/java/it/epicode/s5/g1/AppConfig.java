package it.epicode.s5.g1;


import it.epicode.s5.g1.bean.Ingrediente;
import it.epicode.s5.g1.bean.Menu;
import it.epicode.s5.g1.bean.Pizza;
import it.epicode.s5.g1.bean.Prodotto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class AppConfig {

    @Bean("salame")
    @Scope("singleton")
    public Ingrediente getSalame(){
        Ingrediente p = new Ingrediente();
        p.setNome("salame");
        p.setColories(100);
        p.setPrice(1);
        return p;
    }

    @Bean("pomodoro")
    @Scope("singleton")
    public Ingrediente getPomodoro(){
        Ingrediente p = new Ingrediente();
        p.setNome("pomodoro");
        p.setColories(25);
        p.setPrice(1);
        return p;
    }

    @Bean("mozzarella")
    @Scope("singleton")
    public Ingrediente getMozzarella(){
        Ingrediente p = new Ingrediente();
        p.setNome("mozzarella");
        p.setColories(55);
        p.setPrice(1.50);
        return p;
    }

    @Bean("olive")
    @Scope("singleton")
    public Ingrediente getOlive(){
        Ingrediente p = new Ingrediente();
        p.setNome("olive");
        p.setColories(75);
        p.setPrice(1.70);
        return p;
    }

    @Bean("margherita")
    public Pizza getMargherita(){
        Pizza p = new Pizza();
        p.setNome("margherita");
        p.setIngredienti(List.of(getMozzarella(),getPomodoro()));
        return p;
    }

    @Bean("diavola")
    public Pizza getDiavola(){
        Pizza p = new Pizza();
        p.setNome("diavola");
        p.setIngredienti(List.of(getMozzarella(),getPomodoro(), getSalame()));
        return p;
    }

    @Bean("ascolana")
    public Pizza getAscolana(){
        Pizza p = new Pizza();
        p.setNome("ascolana");
        p.setIngredienti(List.of(getMozzarella(),getPomodoro(), getSalame(), getOlive()));
        return p;
    }

    @Bean("menu")
    public Menu getMenu(){
        Menu m = new Menu();
        m.setPizzas(List.of(getAscolana(),getDiavola(),getMargherita()));
        m.setToppings(List.of(getMozzarella(),getOlive(),getSalame(),getPomodoro()));
        return m;
    }
}
