package br.com.spring.data.service;

import br.com.spring.data.model.UnidadeTrabalho;
import br.com.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UnidadeTrabalhoService {

    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
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

        unidadeTrabalhoRepository.deleteById(id);

        System.out.println("Deletado");
    }

    private void showAll() {
        unidadeTrabalhoRepository.findAll().forEach(unidade -> {
            System.out.println(unidade.getId());
            System.out.println(unidade.getDescricao());
        });
    }

    private void update(Scanner scanner) {
        System.out.println("Id");
        final Integer id = scanner.nextInt();
        System.out.println("Nova descricao");
        final String descricao = scanner.next();
        System.out.println("Novo endereço");
        final String endereco = scanner.next();

        final UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho(id, descricao, endereco);
        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("Atualizado");
    }

    private void save(Scanner scanner) {
        System.out.println("Nova descricao");
        final String descricao = scanner.next();
        System.out.println("Novo endereço");
        final String endereco = scanner.next();

        final UnidadeTrabalho  unidadeTrabalho = new UnidadeTrabalho(descricao, endereco);
        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("descrição salvo");
    }

}
