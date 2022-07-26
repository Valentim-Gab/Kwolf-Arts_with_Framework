package ufsm.csi.kwolf_arts2.model;

import java.sql.Date;

public class Arte {

    //ATRIBUTOS
    private int id_arte;
    private String nome;
    private String copyright;
    private float valor;
    private String adicional;
    private String imagem;
    private int id_comprador;

    private Usuario usuario;
    private Date data_cadastro;

    //MÉTODOS

    //MÉTODOS ESPECIAIS

    public Arte(){

    }

    public Arte(String nome, String copyright, float valor, String adicional, String imagem, Usuario usuario) {
        this.nome = nome;
        this.copyright = copyright;
        this.valor = valor;
        this.adicional = adicional;
        this.imagem = imagem;
        this.usuario = usuario;
    }

    public Arte(int id_arte, String nome, String copyright, float valor, String adicional, String imagem, Date data_cadastro) {
        this.id_arte = id_arte;
        this.nome = nome;
        this.copyright = copyright;
        this.valor = valor;
        this.adicional = adicional;
        this.imagem = imagem;
        this.data_cadastro = data_cadastro;
    }

    public Arte(int id_arte, String nome, String copyright, float valor, String adicional, String imagem, Usuario usuario) {
        this.id_arte = id_arte;
        this.nome = nome;
        this.copyright = copyright;
        this.valor = valor;
        this.adicional = adicional;
        this.imagem = imagem;
        this.usuario = usuario;
    }

    public Arte(int id_arte, String nome, String copyright, float valor, String adicional) {
        this.id_arte = id_arte;
        this.nome = nome;
        this.copyright = copyright;
        this.valor = valor;
        this.adicional = adicional;
    }

    public int getId_arte() {
        return id_arte;
    }

    public void setId_arte(int id_arte) {
        this.id_arte = id_arte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(int id_comprador) {
        this.id_comprador = id_comprador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
