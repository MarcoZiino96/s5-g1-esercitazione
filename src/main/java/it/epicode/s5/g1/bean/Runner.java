package it.epicode.s5.g1.bean;


import it.epicode.s5.g1.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger("s5.g1");
    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Menu m = ctx.getBean("menu", Menu.class);

        m.stampaMenu();

        Tavolo tavolo = ctx.getBean("tavolo1",Tavolo.class);

        Ordine ordine1 = new Ordine(tavolo, 6);

       List<Pizza> pizze = m.getPizzas();
       List<Bevanda> bevande = m.getDrinks();

       ordine1.setPizze(pizze);
       ordine1.setDrinks(bevande);

      logger.info(String.valueOf(ordine1));
        logger.info(String.valueOf(ordine1.totaleOrdine()));









    }
}
