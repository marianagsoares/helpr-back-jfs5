package org.soulcodeacademy.helpr.domain;

import javax.persistence.*;

@Entity
public class Dependente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDependente;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column (nullable = false, length = 11)
    private String cpf;
    @Column (nullable = false)
    private String dataDeNascimento;
    @Column (nullable = false)
    private String escolaridade;

    @ManyToOne // MUITOS dependentes para UM funcionario
    @JoinColumn(name = "idFuncionario") // Cria uma coluna nova que é a chave estrangeira de Cargo
    private Funcionario funcionario;

    public Dependente (){

    }
    public Dependente (Integer idDependente, String nome, String cpf, String dataDeNascimento, String escolaridade) {
        this.idDependente = idDependente;
        this.nome = nome;
        this.cpf= cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.escolaridade = escolaridade;

    }

    public Integer getidDependente()
    {
        return idDependente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
    public String getEscolaridade() {
        return escolaridade;
    }


    public void setIdDependente(Integer idDependente)
    {
        this.idDependente = idDependente;
    }

    public void  setNome(String nome)
    {
        this.nome = nome;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    public void setDataDeNascimento (String dataDeNascimento){
        this.dataDeNascimento=dataDeNascimento;
    }
    public void setescolaridade (String escolaridade){
        this.escolaridade=escolaridade;
    }
}
