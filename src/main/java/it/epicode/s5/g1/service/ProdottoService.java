package it.epicode.s5.g1.service;

import it.epicode.s5.g1.bean.Ingrediente;
import it.epicode.s5.g1.bean.Pizza;
import it.epicode.s5.g1.bean.Prodotto;
import it.epicode.s5.g1.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class ProdottoService {

    @Autowired
    ProdottoRepository prodottoRepository;

    public void saveProdotto(Prodotto p){
        prodottoRepository.save(p);
    }

    public Prodotto cercaProdottoPerId(int id){
        return prodottoRepository.findById(id).get();
    }
    public void deleteProdotto(int id){
        prodottoRepository.deleteById(id);
    }

  public List<Pizza> cercaPizzaPerIngrediente(String nome){
      return prodottoRepository.findPizzaForTopping(nome);
  }
  public  List<Ingrediente> cercaIngredientiPerPizza(String nome){
        return prodottoRepository.findIngr(nome);
  }
}
