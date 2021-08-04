package br.com.spring.data.service;

import br.com.spring.data.model.Funcionario;
import br.com.spring.data.model.UnidadeTrabalho;
import br.com.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void init(Scanner scanner) {

        while (true) {
            System.out.println("Indique acao");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();
        
            if (action == 1) save(scanner);
            else if (action == 2) update(scanner);
            else if (action == 3) showAll();
            else if (action == 4) delete(scanner);
            else break;
        }
    }

    private void delete(Scanner scanner) {
        System.out.println("Id");
        final Integer id = scanner.nextInt();

        funcionarioRepository.deleteById(id);

        System.out.println("Deletado");
    }

    private void showAll() {
        funcionarioRepository.findAll().forEach(funcionario -> {
            System.out.println(funcionario.getId());
            System.out.println(funcionario.getNome());
        });
    }

    private void update(Scanner scanner) {
        System.out.println("Id");
        final Integer id = scanner.nextInt();
        System.out.println("Novo nome");
        final String nome = scanner.next();
        System.out.println("Novo salario");
        final Double salario = scanner.nextDouble();

        final Funcionario funcionario = new Funcionario(id, nome, null, salario, null);
        funcionarioRepository.save(funcionario);

        System.out.println("Atualizado");
    }

    private void save(Scanner scanner) {
        System.out.println("Nome");
        final String nome = scanner.next();
        System.out.println("Cpf");
        final String cpf = scanner.next();
        System.out.println("Salario");
        final Double salario = scanner.nextDouble();

        final Funcionario funcionario = new Funcionario(null, nome, cpf, salario, LocalDate.now());
        funcionarioRepository.save(funcionario);

        System.out.println("Funcionario salvo");
    }

}
