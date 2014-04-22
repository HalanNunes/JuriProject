package br.com.simpledev.spring.model;

import java.util.Date;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author Halan
 */
public class Advogado {
    private Long matricula;
    private String nome;
    private String telefone;
    private String email;
    private int registroOAB;
    private char sexo;
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private String cidade;
    private String estado;
    private String login;
    private String senha;

    public Advogado(){}
    
    public Advogado(long matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public Advogado(long matricula, String nome, String telefone, String email, int registroOAB, char sexo, Date dataNasc, String cpf, String rg, String cidade, String estado, String login, String senha){
        this.matricula = matricula;//generateMatricula();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.registroOAB = registroOAB;
        this.sexo = sexo;
        this.dataNascimento = dataNasc;
        this.cpf = cpf;
        this.rg = rg;
        this.cidade = cidade;
        this.estado = estado;
        this.login = login;
        this.senha = senha;
    }
    
    /**
     * @return the matricula
     */
    public Long getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the registroOAB
     */
    public int getRegistroOAB() {
        return registroOAB;
    }

    /**
     * @param registroOAB the registroOAB to set
     */
    public void setRegistroOAB(int registroOAB) {
        this.registroOAB = registroOAB;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
