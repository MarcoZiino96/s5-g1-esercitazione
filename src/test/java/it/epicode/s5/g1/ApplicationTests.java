package it.epicode.s5.g1;

import it.epicode.s5.g1.bean.Ingrediente;
import it.epicode.s5.g1.bean.Menu;
import it.epicode.s5.g1.bean.Pizza;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@SpringBootTest
class ApplicationTests {

	static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	static void accessContext (){
		ctx = new AnnotationConfigApplicationContext(Application.class);
	}

	@Test
	void PizzaMargherita(){
		Pizza p = ctx.getBean("margherita", Pizza.class);
		Assertions.assertEquals("margherita", p.getNome());
	}

	@Test
	void ToppingMozzarella(){
		Ingrediente i = ctx.getBean("mozzarella", Ingrediente.class);
		assertThat(i).isNotNull();
	}

	@Test
	void pizzaMargheritaMenu(){
		Menu m = ctx.getBean("menu", Menu.class);
		Pizza pizza = m.getPizzas().stream().filter(p->p.getNome().equals("margherita")).toList().getFirst();
		assertThat(pizza).isNotNull();
	}

	@Test
	void ingredientiMargherita(){
		Pizza p = ctx.getBean("diavola", Pizza.class);
		Ingrediente mozzarella = ctx.getBean("mozzarella", Ingrediente.class);
		Ingrediente pomodoro= ctx.getBean("pomodoro", Ingrediente.class);
		Ingrediente salame= ctx.getBean("salame", Ingrediente.class);

		Assertions.assertAll(
				()-> Assertions.assertTrue(p.getIngredienti().contains(mozzarella)),
				()->Assertions.assertTrue(p.getIngredienti().contains(pomodoro)),
				()->Assertions.assertTrue(p.getIngredienti().contains(salame))
		);
	}

	@ParameterizedTest
	@ValueSource(strings={"salame","mozzarella"})
	void menuIngredienti(String nome){
		Menu m = ctx.getBean("menu", Menu.class);
		Ingrediente i = m.getToppings().stream().filter(t->t.getNome().equals(nome)).toList().getFirst();
		assertThat(i).isNotNull();
	}

	@ParameterizedTest
	@CsvSource({"margherita, 1080", "diavola, 1180"})
	 void verificaPizzaECalorieMenu(String nome, int calorie){
		Menu m = ctx.getBean("menu", Menu.class);
		Pizza pizza = m.getPizzas().stream().filter(p->p.getNome().equals(nome)).toList().getFirst();
		assertThat(pizza).isNotNull();
		Assertions.assertEquals(calorie, pizza.getColories());
	}


	@AfterAll
	static void closeContext(){
		ctx.close();
	}

}
