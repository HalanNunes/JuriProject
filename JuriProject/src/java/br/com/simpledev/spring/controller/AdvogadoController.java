package br.com.simpledev.spring.controller;

import br.com.simpledev.spring.dao.AdvogadoDao;
import br.com.simpledev.spring.model.Advogado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Halan
 */
@Controller
@RequestMapping("/advogado")
public class AdvogadoController {
    
    private final AdvogadoDao dao;

    @Autowired
    public AdvogadoController(final AdvogadoDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/lista", method = GET)
    public List<Advogado> lista() {
        return dao.lista();
    }

    @RequestMapping(value = "/novo", method = GET)
    public ModelAndView novo() {
        return new ModelAndView("advogado/novo", "advogado", new Advogado());
    }

    @RequestMapping(value = "/novo", method = POST)
    public String novo(final Advogado advogado) {
        dao.adiciona(advogado);
        return "redirect:lista";
    }

    @RequestMapping(value = "/editar/{id}", method = GET)
    public ModelAndView editar(@PathVariable Long id) {
        Advogado advogado = dao.busca(id);
        return new ModelAndView("advogado/editar", "advogado", advogado);
    }
    
    @RequestMapping(value = "/excluir/{id}", method = GET)
    public String excluir(@PathVariable Long id) {
        Advogado advogado = dao.busca(id);
        dao.exclui(advogado);
        return "redirect:http://localhost:8080/JuriProject/advogado/lista";
    }

    @RequestMapping(value = "/editar", method = POST)
    public String editar(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        Long matricula = new Long(request.getParameter("matricula"));
        String nome      = request.getParameter("nome");
        String telefone  = request.getParameter("telefone");
        String email     = request.getParameter("email");
        char sexo        = request.getParameter("sexo").charAt(0);
        //Date dataNascimento = formatter.parse(request.getParameter("dataNascimento"));
        String rg        = request.getParameter("rg");
        String cpf       = request.getParameter("cpf");
        String estado    = request.getParameter("estado");
        String cidade    = request.getParameter("cidade");
        int registroOAB  = Integer.parseInt(request.getParameter("registroOAB"));
        String login     = request.getParameter("login");
        String senha     = request.getParameter("senha");
        
        dao.busca(matricula).setNome(nome);
        dao.busca(matricula).setTelefone(telefone);
        dao.busca(matricula).setEmail(email);
        dao.busca(matricula).setSexo(sexo);
        //dao.busca(matricula).setDataNascimento(dataNascimento);
        dao.busca(matricula).setRg(rg);
        dao.busca(matricula).setCpf(cpf);
        dao.busca(matricula).setEstado(estado);
        dao.busca(matricula).setCidade(cidade);
        dao.busca(matricula).setRegistroOAB(registroOAB);
        dao.busca(matricula).setLogin(login);
        dao.busca(matricula).setSenha(senha);
        
        return "redirect:http://localhost:8080/JuriProject/advogado/lista";
    }
}
