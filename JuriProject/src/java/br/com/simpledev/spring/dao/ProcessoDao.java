package br.com.simpledev.spring.dao;

import java.util.List;

import br.com.simpledev.spring.model.Advogado;
import br.com.simpledev.spring.model.Processo;

public interface ProcessoDao {

    List<Processo> lista();

    void adiciona(Processo processo);

    Processo busca(Long id);

    void atualiza(Processo processo);
    
    void exclui(Processo processo);
}
