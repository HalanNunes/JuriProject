package br.com.simpledev.spring.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.simpledev.spring.dao.ClienteDao;
import br.com.simpledev.spring.model.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteDao dao;

    @Autowired
    public ClienteController(final ClienteDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/lista", method = GET)
    public List<Cliente> lista() {
        return dao.lista();
    }

    @RequestMapping(value = "/novo", method = GET)
    public ModelAndView novo() {
        return new ModelAndView("cliente/novo", "cliente", new Cliente());
    }

    @RequestMapping(value = "/novo", method = POST)
    public String novo(final Cliente cliente) {
        dao.adiciona(cliente);
        return "redirect:lista";
    }

    @RequestMapping(value = "/editar/{id}", method = GET)
    public ModelAndView editar(@PathVariable Long id) {
        Cliente cliente = dao.busca(id);
        return new ModelAndView("cliente/editar", "cliente", cliente);
    }
    
    @RequestMapping(value = "/excluir/{id}", method = GET)
    public String excluir(@PathVariable Long id) {
        Cliente cliente = dao.busca(id);
        dao.exclui(cliente);
        return "redirect:http://localhost:8080/JuriProject/cliente/lista";
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
        
        dao.busca(matricula).setNome(nome);
        dao.busca(matricula).setTelefone(telefone);
        dao.busca(matricula).setEmail(email);
        dao.busca(matricula).setSexo(sexo);
        //dao.busca(matricula).setDataNascimento(dataNascimento);
        dao.busca(matricula).setRg(rg);
        dao.busca(matricula).setCpf(cpf);
        dao.busca(matricula).setEstado(estado);
        dao.busca(matricula).setCidade(cidade);
        return "redirect:http://localhost:8080/JuriProject/cliente/lista";
    }
}
