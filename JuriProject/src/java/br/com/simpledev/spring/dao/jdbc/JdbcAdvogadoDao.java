package br.com.simpledev.spring.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.simpledev.spring.dao.AdvogadoDao;
import br.com.simpledev.spring.model.Advogado;

@Repository
public class JdbcAdvogadoDao implements AdvogadoDao {

    private final List<Advogado> database = new ArrayList<Advogado>();

    public JdbcAdvogadoDao() {
        database.add(new Advogado(1,"Admin","","",0,'M',null,"","","","","admin","admin"));
        database.add(new Advogado(2,"José Antares Gonçalves","(47)2222-2222","jose@gmail.com",1116765,'M',null,"111111111","2222222","Joinville","Santa Catarina","jose","111111"));
    }

    public List<Advogado> lista() {
        return database;
    }

    public void adiciona(final Advogado advogado) {
        advogado.setMatricula(new Long(database.size() + 1));
        database.add(advogado);
    }

    public Advogado busca(Long id) {
        return database.get(id.intValue() - 1);
    }
    
    public void exclui(final Advogado advogado){
        database.remove(advogado);
    }

    public void atualiza(Advogado advogado) {
        int index = advogado.getMatricula().intValue();
        database.set(index, advogado);
    }
}
