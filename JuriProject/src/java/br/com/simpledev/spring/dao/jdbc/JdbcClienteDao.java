package br.com.simpledev.spring.dao.jdbc;

import br.com.simpledev.spring.dao.ClienteDao;
import br.com.simpledev.spring.model.Cliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcClienteDao implements ClienteDao {

    private final List<Cliente> database = new ArrayList<Cliente>();

    public JdbcClienteDao() {
        database.add(new Cliente(1,"Halan Nunes","","halan.nunes@catlicasc.org.br",null,'M',"111111111","0000000000","Joinville","Santa Catarina"));
        database.add(new Cliente(2,"Thiago Campos","","thiago.campos@catolicasc.org.br",null,'M',"222222222","333333333","Joinville","Santa Catarina"));
    }

    public List<Cliente> lista() {
        return database;
    }

    public void adiciona(final Cliente cliente) {
        cliente.setMatricula((long) database.size() + 1);
        database.add(cliente);
    }

    public Cliente busca(Long id) {
        return database.get(id.intValue() - 1);
    }

    public void exclui(final Cliente cliente){
        database.remove(cliente);
    }

    public void atualiza(Cliente cliente) {
        int index = cliente.getMatricula().intValue();
        database.get(index).setNome("GGGGGGGG");
    }
}
