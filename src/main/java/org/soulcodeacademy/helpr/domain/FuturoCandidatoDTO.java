package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Setor;

import javax.validation.constraints.NotBlank;

public class FuturoCandidatoDTO {

    @NotBlank(message = "nome completo é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "email é obrigatório")
    private String email;


    @NotBlank(message = "Descrição é obrigatório")
    private String descricaoDasHabilidades;


    @NotBlank(message = "Setor obrigatório")
    private Setor setor;


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoDasHabilidades() {
        return descricaoDasHabilidades;
    }

    public void setDescricaoDasHabilidades(String descricaoDasHabilidades) {
        this.descricaoDasHabilidades = descricaoDasHabilidades;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }


}

