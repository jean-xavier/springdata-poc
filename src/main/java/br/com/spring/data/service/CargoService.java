package br.com.spring.data.service;

import br.com.spring.data.model.Cargo;
import br.com.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
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

        cargoRepository.deleteById(id);

        System.out.println("Deletado");
    }

    private void showAll() {
        cargoRepository.findAll().forEach(cargo -> {
            System.out.println(cargo.getId());
            System.out.println(cargo.getDescricao());
        });
    }

    private void update(Scanner scanner) {
        System.out.println("Id");
        final Integer id = scanner.nextInt();
        System.out.println("Nova descricao");
        final String descricao = scanner.next();

        final Cargo cargo = new Cargo(id, descricao);
        cargoRepository.save(cargo);

        System.out.println("Atualizado");
    }

    private void save(Scanner scanner) {
        System.out.println("Descrição do cargo");
        final String descricao = scanner.next();

        final Cargo cargo = new Cargo(descricao);
        cargoRepository.save(cargo);
        System.out.println("descrição salvo");
    }

}
