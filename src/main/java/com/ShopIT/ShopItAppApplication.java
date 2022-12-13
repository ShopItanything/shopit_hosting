package com.ShopIT;

import com.ShopIT.Config.AppConstants;
import com.ShopIT.Models.Role;
import com.ShopIT.Repository.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ShopItAppApplication implements CommandLineRunner {
	private final RoleRepo roleRepo;

	public ShopItAppApplication(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShopItAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args){
		try{
			Role role1 = new Role();
			role1.setId(AppConstants.ROLE_ADMIN);
			role1.setName("ROLE_ADMIN");

			Role role2 = new Role();
			role2.setId(AppConstants.ROLE_NORMAL);
			role2.setName("ROLE_NORMAL");

			Role role3 = new Role();
			role3.setId(AppConstants.ROLE_MERCHANT);
			role3.setName("ROLE_MERCHANT");

			List<Role> roles= List.of(role1, role2, role3);
			this.roleRepo.saveAll(roles);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
