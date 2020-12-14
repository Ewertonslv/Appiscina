package com.example.appiscina.dominio;

import android.widget.ImageView;

public class propriedade {

    private ImageView ic_imagem;
    private String proprietario;
    private String nomePropriedade;
    private String cpf;
    private String telefone;
    private String localizacao;
    private String diaria;
    private  int favorito;


    public propriedade(String proprietario, String nomePropriedade, String cpf, String telefone, String localizacao, String diaria, int favorito) {
        this.ic_imagem = ic_imagem;
        this.proprietario = proprietario;
        this.nomePropriedade = nomePropriedade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.localizacao = localizacao;
        this.diaria = diaria;
        this.favorito = favorito;
    }

    public ImageView getIc_imagem() {
        return ic_imagem;
    }

    public void setIc_imagem(ImageView ic_imagem) {
        this.ic_imagem = ic_imagem;
    }

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

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }
}
