package com.sedki.pcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sedki.pcs.entities.Pc;
import com.sedki.pcs.entities.Role;
import com.sedki.pcs.entities.User;
import com.sedki.pcs.service.PcService;
import com.sedki.pcs.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PcsApplication implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	PcService PcService;
	

	@Autowired 
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(PcsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Password Encoded BCRYPT :******************** ");
		 System.out.println(passwordEncoder.encode("123"));
		/*
		 * PcService.savePc(new Pc("PC Dell", 2600.0, new Date())); PcService.savePc(new
		 * Pc("PC Asus", 2800.0, new Date())); PcService.savePc(new Pc("Imp Epson",
		 * 900.0, new Date()));
		 */

	}
	/*
	@PostConstruct
	void init_users() {
		//ajouter les rôles
		userService.addRole(new Role(null,"ADMIN"));
		userService.addRole(new Role(null,"AGENT"));
		userService.addRole(new Role(null,"USER"));
		
		//ajouter les users
		userService.saveUser(new User(null,"admin","123",true,null));
		userService.saveUser(new User(null,"sedki","123",true,null));
		userService.saveUser(new User(null,"user1","123",true,null));
		
		//ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		
		userService.addRoleToUser("sedki", "USER");
		userService.addRoleToUser("sedki", "AGENT");
		
		userService.addRoleToUser("user1", "USER");		
	} */

}
