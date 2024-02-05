package it.epicode.s5.g1;

import it.epicode.s5.g1.bean.Menu;
import it.epicode.s5.g1.bean.Pizza;
import it.epicode.s5.g1.bean.Prodotto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Menu menu = ctx.getBean("menu", Menu.class);

		System.out.println(menu);
	}

}
