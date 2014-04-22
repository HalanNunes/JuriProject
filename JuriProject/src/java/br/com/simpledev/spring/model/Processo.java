package br.com.simpledev.spring.model;

import java.util.Date;

/**
 *
 * @author Halan
 */
public class Processo {
    private Long numProcesso;
    private boolean processoAtivo;
    private String titulo;
    private String evento;
    private double valor;
    private String natureza;
    private String juizo;
    private String cidade;
    private Date dtIniProcess;
    private Date dtEndProcess;
    private String cliente;
    private String advogado;

    public Processo(){}
    
    public Processo(boolean processoAtivo, String titulo, String evento, double valor, String natureza, String juizo, String cidade, Date dtIniProcess, Date dtEndProcess, String cliente, String advogado) {
        this.numProcesso = new Long(9);
        this.processoAtivo = processoAtivo;
        this.titulo = titulo;
        this.evento = evento;
        this.valor = valor;
        this.natureza = natureza;
        this.juizo = juizo;
        this.cidade = cidade;
        this.dtIniProcess = dtIniProcess;
        this.dtEndProcess = dtEndProcess;
        this.cidade = cidade;
        this.advogado = advogado;
    }
    
    public Long getNumProcesso() {
        return numProcesso;
    }

    public void setNumProcesso(Long numProcesso) {
        this.numProcesso = numProcesso;
    }

    public boolean isProcessoAtivo() {
        return processoAtivo;
    }

    public void setProcessoAtivo(boolean processoAtivo) {
        this.processoAtivo = processoAtivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getJuizo() {
        return juizo;
    }

    public void setJuizo(String juizo) {
        this.juizo = juizo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDtIniProcess() {
        return dtIniProcess;
    }

    public void setDtIniProcess(Date dtIniProcess) {
        this.dtIniProcess = dtIniProcess;
    }

    public Date getDtEndProcess() {
        return dtEndProcess;
    }

    public void setDtEndProcess(Date dtEndProcess) {
        this.dtEndProcess = dtEndProcess;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAdvogado() {
        return advogado;
    }

    public void setAdvogado(String advogado) {
        this.advogado = advogado;
    }
    
}
