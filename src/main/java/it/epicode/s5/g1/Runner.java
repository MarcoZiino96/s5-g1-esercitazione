package it.epicode.s5.g1;



import it.epicode.s5.g1.bean.Bevanda;
import it.epicode.s5.g1.bean.Ingrediente;
import it.epicode.s5.g1.bean.Pizza;
import it.epicode.s5.g1.service.ProdottoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;



@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private ProdottoService prodottoService;

    private Logger logger = LoggerFactory.getLogger("s5.g1");
    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);


//        Menu m = ctx.getBean("menu", Menu.class);
//
//        m.stampaMenu();
//
//        Tavolo tavolo = ctx.getBean("tavolo1",Tavolo.class);
//
//        Ordine ordine1 = new Ordine(tavolo, 6);
//
//       List<Pizza> pizze = m.getPizzas();
//       List<Bevanda> bevande = m.getDrinks();
//
//       ordine1.setPizze(pizze);
//       ordine1.setDrinks(bevande);
//
//      logger.info(String.valueOf(ordine1));
//        logger.info(String.valueOf(ordine1.totaleOrdine()));

        //*************************************************

        //esercitazione pomeridiana s5-g4

//        Ingrediente mozzarella = ctx.getBean("mozzarella", Ingrediente.class);
//        prodottoService.saveProdotto(mozzarella);
//
//        Ingrediente salame = ctx.getBean("salame", Ingrediente.class);
//        prodottoService.saveProdotto(salame);
//
//        Ingrediente olive = ctx.getBean("olive", Ingrediente.class);
//        prodottoService.saveProdotto(olive);
//
//        Ingrediente pomodoro = ctx.getBean("pomodoro", Ingrediente.class);
//        prodottoService.saveProdotto(pomodoro);
//
//
//        Pizza margherita = ctx.getBean("margherita",Pizza.class);
//        prodottoService.saveProdotto(margherita);
//        Pizza diavola = ctx.getBean("diavola",Pizza.class);
//        prodottoService.saveProdotto(diavola);
//        Pizza ascolana = ctx.getBean("ascolana", Pizza.class);
//        prodottoService.saveProdotto(ascolana);
//
//        Bevanda acqua = ctx.getBean("acqua", Bevanda.class);
//        prodottoService.saveProdotto(acqua);


       prodottoService.cercaPizzaPerIngrediente("margherita").forEach(System.out::println);












    }
}
