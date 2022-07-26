package ufsm.csi.kwolf_arts2.model;

import java.sql.Date;

public class Usuario {

    //ATRIBUTOS
    private int id_comprador;
    private String primeiro_nome;
    private String segundo_nome;
    private String email;
    private String cpf;
    private String senha;
    private String tipo_conta;
    private String telefone;
    private String nacionalidade;
    private Date data_nascimento;
    private Date data_cadastro;
    private int num_artes;

    //MÉTODOS
    //MÉTODOS ESPECIAIS
    public Usuario() {

    }

    public int getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(int id_comprador) {
        this.id_comprador = id_comprador;
    }

    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    public void setPrimeiro_nome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    public String getSegundo_nome() {
        return segundo_nome;
    }

    public void setSegundo_nome(String segundo_nome) {
        this.segundo_nome = segundo_nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.toLowerCase();
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public int getNum_artes() {
        return num_artes;
    }

    public void setNum_artes(int num_artes) {
        this.num_artes = num_artes;
    }
}
