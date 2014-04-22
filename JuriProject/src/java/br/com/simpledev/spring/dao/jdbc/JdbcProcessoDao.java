package br.com.simpledev.spring.dao.jdbc;

import br.com.simpledev.spring.dao.ProcessoDao;
import br.com.simpledev.spring.model.Processo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProcessoDao implements ProcessoDao {

    private final List<Processo> database = new ArrayList<Processo>();

    public JdbcProcessoDao() {
    }

    @Override
    public List<Processo> lista() {
        return database;
    }

    @Override
    public void adiciona(Processo processo) {
        processo.setNumProcesso((long) database.size() + 1);
        database.add(processo);
    }

    @Override
    public Processo busca(Long id) {
        return database.get(id.intValue() - 1);
    }

    public void exclui(final Processo processo) {
        database.remove(processo);
    }

    public void atualiza(Processo processo) {
        int index = processo.getNumProcesso().intValue();
        database.set(index, processo);
    }

}
