package br.com.spring.data;

import br.com.spring.data.service.CargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CargoService cargoService;

	public SpringDataApplication(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean system = true;

		final Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acão você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");

			int action = scanner.nextInt();

			cargoService.init(scanner);

			if (action == 0) {
				system = Boolean.FALSE;
			}
		}

		scanner.close();
	}
}
