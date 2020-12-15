package com.example.appiscina.dominio;

import android.widget.ImageView;

public class propriedade {

    //private ImageView ic_imagem;
    private String usuario;
    private String email;
    private String password;
    private String proprietario;
    private String nomePropriedade;
    private String cpf;
    private String telefone;
    private String localizacao;
    private String diaria;
    private int geladeira;
    private int freezer;
    private int microondas;
    private int fogao;
    private int churrasqueira;
    private int mesas;
    //private  int favorito;


    public propriedade(String usuario, String email, String password, String proprietario, String nomePropriedade, String cpf,
                       String telefone, String localizacao, String diaria, int geladeira, int freezer, int microondas,
                       int fogao, int churrasqueira, int mesas) {
        //this.ic_imagem = ic_imagem;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.proprietario = proprietario;
        this.nomePropriedade = nomePropriedade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.localizacao = localizacao;
        this.diaria = diaria;
        this.geladeira = geladeira;
        this.freezer = freezer;
        this.microondas = microondas;
        this.fogao = fogao;
        this.churrasqueira = churrasqueira;
        this.mesas = mesas;
        //this.favorito = favorito;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public ImageView getIc_imagem() {
//        return ic_imagem;
//    }
//
//    public void setIc_imagem(ImageView ic_imagem) {
//        this.ic_imagem = ic_imagem;
//    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getNomePropriedade() {
        return nomePropriedade;
    }

    public void setNomePropriedade(String nomePropriedade) {
        this.nomePropriedade = nomePropriedade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDiaria() {
        return diaria;
    }

    public void setDiaria(String diaria) {
        this.diaria = diaria;
    }

    public int getGeladeira() {
        return geladeira;
    }

    public void setGeladeira(int geladeira) {
        this.geladeira = geladeira;
    }

    public int getFreezer() {
        return freezer;
    }

    public void setFreezer(int freezer) {
        this.freezer = freezer;
    }

    public int getMicroondas() {
        return microondas;
    }

    public void setMicroondas(int microondas) {
        this.microondas = microondas;
    }

    public int getFogao() {
        return fogao;
    }

    public void setFogao(int fogao) {
        this.fogao = fogao;
    }

    public int getChurrasqueira() {
        return churrasqueira;
    }

    public void setChurrasqueira(int churrasqueira) {
        this.churrasqueira = churrasqueira;
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }

//    public int getFavorito() {
//        return favorito;
//    }
//
//    public void setFavorito(int favorito) {
//        this.favorito = favorito;
//    }
}
