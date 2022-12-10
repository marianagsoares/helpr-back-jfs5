package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.*;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// Torna o objeto de PopulateService disponível para toda a aplicação (global)
@Service // indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private FuturoClienteRepository futuroClienteRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;

    public void populate() {
        // Integer idCargo, String nome, String descricao, Double salario
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de Setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico geral", "Resolve os chamados urgentes", 12000.0);

        // Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo
        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "97762478060", encoder.encode("12345"), null, c1);
        f1.setPerfil(Perfil.ADMIN);
        Funcionario f3 = new Funcionario(null, "Ricardo Santos", "ricardo.santos@gmail.com", "26294636566", encoder.encode("12345"), null, c2);
        f3.setPerfil(Perfil.ADMIN);
        Funcionario f4 = new Funcionario(null, "Valeria Lima", "vl@gmail.com", "07235486414", encoder.encode("12345"), null, c1);
        f4.setPerfil(Perfil.ADMIN);
        Funcionario f5 = new Funcionario(null, "Kelly Nunes", "kn@gmail.com", "05746577111", encoder.encode("12345"), null, c1);
        f5.setPerfil(Perfil.ADMIN);
        Funcionario f6 = new Funcionario(null, "José Pereira", "jose.pereira@gmail.com", "33472234970", encoder.encode("12345"), null, c2);
        Funcionario f7 = new Funcionario(null, "Henrique Martins", "henrique.martins@gmail.com", "42327118212", encoder.encode("12345"), null, c1);
        f7.setPerfil(Perfil.ADMIN);

        Funcionario f2 = new Funcionario(null, "Almir José", "almir.jose@gmail.com", "85332552505", encoder.encode("12345"), null, c2);
        Funcionario f8 = new Funcionario(null, "Gabriel Braga", "gabriel.braga@gmail.com", "64287962877", encoder.encode("12345"), null, c1);
        Funcionario f9 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com", "27461708414", encoder.encode("12345"), null, c1);
        Funcionario f10 = new Funcionario(null, "Vanessa Santos", "vanessa.santos@gmail.com", "73757816056", encoder.encode("12345"), null, c2);

        // Integer id, String nome, String email, String cpf, String senha, String telefone
        Cliente cl1 = new Cliente(null, "José Almir", "jose.almir@gmail.com", "43740115521", encoder.encode("batata"), "9999999999");
        Cliente cl2 = new Cliente(null, "Pedro João", "pedro@gmail.com", "61197366709", encoder.encode("batata"), "9999999997");
        Cliente cl3 = new Cliente(null, "Pedro Victor", "pedro.victor@gmail.com", "60680546405", encoder.encode("batata"), "9999999996");
        Cliente cl4 = new Cliente(null, "Júnior Lima", "junior.lima@gmail.com", "42127421795", encoder.encode("batata"), "9999999995");
        Cliente cl5 = new Cliente(null, "Carla Farias", "carla.farias@gmail.com", "97804134568", encoder.encode("batata"), "9999999994");


        Chamado ch1 = new Chamado(null, "Primeiro chamado do sistema", "Revisar as entidades criadas");
        ch1.setCliente(cl1);
        Chamado ch2 = new Chamado(null, "Ativar VPN do sistema", "Conectar aos servidores remotos");
        ch2.setCliente(cl2);
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);
        Chamado ch3 = new Chamado(null, "Criar time de infraestrutura", "Corrigir API");
        ch3.setCliente(cl3);
        Chamado ch4 = new Chamado(null, "Entrega de equipamento", "Entrega de equipamento para novo funcionário");
        ch4.setCliente(cl4);
        Chamado ch5 = new Chamado(null, "Reunir time de desenvolvimento", "Alinhamento para criar projeto de novo cliente");
        ch5.setCliente(cl4);
        Chamado ch6 = new Chamado(null, "Solicitar férias", "Solicitar emissão de férias");
        ch6.setCliente(cl1);
        ch6.setStatus(StatusChamado.CONCLUIDO);
        Chamado ch7 = new Chamado(null, "Conflito na main", "Corrigir conflito na main do produto X");
        ch7.setCliente(cl3);
        ch7.setStatus(StatusChamado.CONCLUIDO);


        FuturoCliente fc1 = new FuturoCliente(null, "Josefina Mendes", "33877638597",  "josefina.mendes@gmail.com", "544558855");
        FuturoCliente fc2 = new FuturoCliente(null, "Genésio Lima", "35884341008",  "genesio.lima@gmail.com", "54488888");

        FuturoCandidato candidato1 = new FuturoCandidato(null, "Maria Jose Da Silva", "mariajose@gmail.com", "Boa comunicação, Liderança");
        candidato1.setSetor(Setor.DESENVOLVIMENTO);

        FuturoCandidato candidato2 = new FuturoCandidato(null, "Maria cícera Gomes", "maria@gmail.com","Flexibilidade, Proatividade");
        candidato2.setSetor(Setor.SUSTENTACAO);

        FuturoCandidato candidato3 = new FuturoCandidato(null, "Marco Bueno Trajano", "bueno@gmail.com","Organização, Liderança");
        candidato3.setSetor(Setor.RECURSOS_HUMANOS);

        FuturoCandidato candidato4 = new FuturoCandidato(null, "Jandira Louise Braga", "jandira@gmail.com","Resolução de problemas , Resiliência");
        candidato4.setSetor(Setor.MANUTENCAO);

        FuturoCandidato candidato5 = new FuturoCandidato(null, "Aline Bruna Lima", "lima@gmail.com", "Criatividade, Controle emocional");
        candidato5.setSetor(Setor.MARKETING);


        this.cargoRepository.saveAll(List.of(c1, c2, c3));
        this.funcionarioRepository.saveAll(List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10));
        this.clienteRepository.saveAll(List.of(cl1, cl2, cl3, cl4, cl5));
        this.chamadoRepository.saveAll(List.of(ch1, ch2, ch3, ch4, ch5, ch6, ch7));
        this.futuroCandidatoRepository.saveAll(List.of(candidato1, candidato2,candidato3, candidato4, candidato5));
        this.futuroClienteRepository.saveAll(List.of(fc1, fc2));

    }


}

// O objetivo desta classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe