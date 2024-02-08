package it.epicode.s5.g1.repository;

import it.epicode.s5.g1.bean.Ingrediente;
import it.epicode.s5.g1.bean.Pizza;
import it.epicode.s5.g1.bean.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {


   @Query("SELECT p FROM Pizza p where p.nome= :nome")
    List<Pizza> findPizzaForTopping(String nome);


   @Query("SELECT p FROM Pizza.ingredienti WHERE p.nome= :nome")
   List<Ingrediente> findIngr(String nome);
}
