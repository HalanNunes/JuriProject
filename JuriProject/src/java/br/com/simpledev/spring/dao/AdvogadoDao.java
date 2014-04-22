package br.com.simpledev.spring.dao;

import java.util.List;

import br.com.simpledev.spring.model.Advogado;

public interface AdvogadoDao {

    List<Advogado> lista();

    void adiciona(Advogado advogado);

    Advogado busca(Long id);

    void atualiza(Advogado advogado);
    
    void exclui(Advogado advogado);
}
