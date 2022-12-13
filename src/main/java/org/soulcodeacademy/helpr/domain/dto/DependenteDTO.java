package org.soulcodeacademy.helpr.domain.dto;
//Nome (não-vazio);
//CPF (formato cpf);
//Data de Nascimento (não-nula);
//Escolaridade (não-vazio);
//IdResponsavel (funcionário) (não-nulo);
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
    public class DependenteDTO extends FuncionarioDTO {
        @NotEmpty(message = "O campo nome não pode ser vazio")
        private String nome;
        @NotNull(message = "id do responsável é obrigatório")
       private Integer idFuncionario;
        public DependenteDTO(String dataDeNascimento) {
            this.dataDeNascimento = dataDeNascimento;
        }
        public DependenteDTO(Integer idFuncionario) {
            this.idFuncionario = idFuncionario;
        }
        public Integer getIdFuncionario() {
            return (Integer) idFuncionario;
        }
        public void setIdFuncionario() {
            this.idFuncionario= idFuncionario;
        }
        @NotNull(message = "Data de Nascimento não pode ser nula")
        private String dataDeNascimento;
        @NotEmpty (message = "O campo escolaridade não pode ser vazio")
        private String escolaridade;
    }

