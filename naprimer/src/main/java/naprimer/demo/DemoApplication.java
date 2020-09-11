package naprimer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import naprimer.demo.repository.UserRepository;
/*
 * kada budem pravio CompanyServiceImplementation, napraviti metodu koja ce raditi update na employee, menjati ga iz obicnog employee u 
 * neku vrstu administratora stranice sto moramo i u security definisati sta editor moze da radi
 * 
 * rest controller-i
 * */
@SpringBootApplication
@ComponentScan({"naprimer.demo"})
@EnableJpaRepositories("naprimer.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
