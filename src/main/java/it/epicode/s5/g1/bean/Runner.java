package it.epicode.s5.g1.bean;


import it.epicode.s5.g1.AppConfig;
import it.epicode.s5.g1.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Menu m = ctx.getBean("menu", Menu.class);

        m.stampaMenu();

        AnnotationConfigApplicationContext ctx1 = new AnnotationConfigApplicationContext(Application.class);

        Ordine o = ctx1.getBean("ordine", Ordine.class);
        System.out.println(o);



    }
}
