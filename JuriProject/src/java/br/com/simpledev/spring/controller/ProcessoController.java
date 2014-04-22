package br.com.simpledev.spring.controller;

import br.com.simpledev.spring.dao.AdvogadoDao;
import br.com.simpledev.spring.dao.ClienteDao;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.simpledev.spring.dao.ProcessoDao;
import br.com.simpledev.spring.dao.jdbc.JdbcAdvogadoDao;
import br.com.simpledev.spring.dao.jdbc.JdbcClienteDao;
import br.com.simpledev.spring.model.Advogado;
import br.com.simpledev.spring.model.Cliente;
import br.com.simpledev.spring.model.Processo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.ModelMap;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/processo")
public class ProcessoController {
    
    private final ProcessoDao dao;

    @Autowired
    public ProcessoController(final ProcessoDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/lista", method = GET)
    public List<Processo> lista() {
        return dao.lista();
    }

    @RequestMapping(value = "/novo", method = GET)
    public ModelAndView novo() {
        ModelAndView modelAndView =  new ModelAndView("processo/novo", "processo", new Processo());
        ModelMap model = modelAndView.getModelMap();
        model.addAttribute("getListaClientes", popularCliente());
        model.addAttribute("getListaAdvogados", popularAdvogado());
        return modelAndView;
    }

    @RequestMapping(value = "/novo", method = POST)
    public String novo(final Processo processo) {
        dao.adiciona(processo);
        return "redirect:lista";
    }

    @RequestMapping(value = "/editar/{id}", method = GET)
    public ModelAndView editar(@PathVariable Long id) {
        Processo processo = dao.busca(id);
        ModelAndView modelAndView =  new ModelAndView("processo/novo", "processo", processo);
        ModelMap model = modelAndView.getModelMap();
        model.addAttribute("getListaClientes", popularCliente());
        model.addAttribute("getListaAdvogados", popularAdvogado());
        return modelAndView;
    }
    
    @RequestMapping(value = "/excluir/{id}", method = GET)
    public String excluir(@PathVariable Long id) {
        Processo processo = dao.busca(id);
        dao.exclui(processo);
        return "redirect:http://localhost:8080/JuriProject/processo/lista";
    }

    @RequestMapping(value = "/editar", method = POST)
    public String editar(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        Long matricula = new Long(request.getParameter("numProcesso"));
        String titulo    = request.getParameter("titulo");
        String evento    = request.getParameter("evento");
        double valor     = Double.parseDouble(request.getParameter("valor"));
        String natureza  = request.getParameter("natureza");
        String juizo     = request.getParameter("juizo");
        String cidade    = request.getParameter("cidade");
        boolean processoAtivo = Boolean.parseBoolean(request.getParameter("processoAtivo"));
        String cliente   = request.getParameter("cliente");
        String advogado  = request.getParameter("advogado");
        
        dao.busca(matricula).setTitulo(titulo);
        dao.busca(matricula).setEvento(evento);
        dao.busca(matricula).setValor(valor);
        dao.busca(matricula).setNatureza(natureza);
        dao.busca(matricula).setJuizo(juizo);
        dao.busca(matricula).setCidade(cidade);
        dao.busca(matricula).setProcessoAtivo(processoAtivo);
        dao.busca(matricula).setAdvogado(advogado);
        dao.busca(matricula).setCliente(cliente);
        
        return "redirect:http://localhost:8080/JuriProject/processo/lista";
    }
    
    private List<?> popularCliente(){
        ClienteDao clienteDao = new JdbcClienteDao();
        List<Cliente> clientes = clienteDao.lista();
        return clientes;
    }
    
    private List<?> popularAdvogado(){
        AdvogadoDao advogadoDao = new JdbcAdvogadoDao();
        List<Advogado> advogado = advogadoDao.lista();
        return advogado;
    }
}
