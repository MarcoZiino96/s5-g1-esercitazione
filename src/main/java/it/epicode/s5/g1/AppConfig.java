package it.epicode.s5.g1;


import it.epicode.s5.g1.bean.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@PropertySource("application.properties")
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
        p.setColories(1000 + getPomodoro().getColories()+getMozzarella().getColories());
        p.setPrice( 3 + getMozzarella().getPrice()+getPomodoro().getPrice());
        return p;
    }

    @Bean("diavola")
    public Pizza getDiavola(){
        Pizza p = new Pizza();
        p.setNome("diavola");
        p.setIngredienti(List.of( getMozzarella(),getPomodoro(),getSalame()));
        p.setColories(getMargherita().getColories()+ getSalame().getColories());
        p.setPrice(getMargherita().getPrice() + getSalame().getPrice());
        return p;
    }

    @Bean("ascolana")
    public Pizza getAscolana(){
        Pizza p = new Pizza();
        p.setNome("ascolana");
        p.setIngredienti(List.of(getMozzarella(),getPomodoro(),getSalame(), getOlive()));
        p.setColories(getDiavola().getColories()+getOlive().getColories());
        p.setPrice(getDiavola().getPrice() + getOlive().getPrice());
        return p;
    }

    @Bean("acqua")
    public Bevanda getAcqua(){
        Bevanda b = new Bevanda();
        b.setColories(0);
        b.setNome("acqua");
        b.setPrice(1);
        return  b;
    }

    @Bean("tavolo1")
    public Tavolo tavolo(@Value("${s5.g1.costoCoperto}") String coperto){
        Tavolo t = new Tavolo();
        t.setNumeroTavolo(1);
        t.setStatoTavolo(StatoTavolo.LIBERO);
        t.setNumeroMassimo(7);
        t.setCostoCoperto(Double.parseDouble(coperto));
        return t;
    }

//    @Bean("ordine")
//    public Ordine ordine(@Value("${s5.g1.costoCoperto}") String coperto){
//        Ordine o = new Ordine();
//        o.setCostoCoperto(Double.parseDouble(coperto));
//        o.setNumeroOrdine(1);
//        o.setNumeroCoperti(4);
//        o.setElementiMenu(List.of(getAcqua(),getMargherita(),getDiavola(),getAscolana()));
//        o.setStatoOrdine(Stato.IN_CORSO);
//        o.setTavolo(tavolo());
//        o.setAcqusizione(LocalTime.now());
//        return o;
//    }

    @Bean("menu")
    public Menu getMenu(){
        Menu m = new Menu();
        m.setPizzas(List.of(getDiavola(),getMargherita(), getAscolana()));
        m.setToppings(List.of(getMozzarella(),getOlive(),getSalame(),getPomodoro()));
        m.setDrinks(List.of(getAcqua()));
        return m;
    }
}
