package com.fatimetou.patient;

import com.fatimetou.patient.entities.Patient;
import com.fatimetou.patient.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(PatientApplication.class, args);
	}

	//@Bean
	//public CommandLineRunner start(PatientRepository patientRepository){
		//return args -> {
			//Patient p1=new Patient(1,null, null, "maroc",null, null);
			//patientRepository.save(p1);
		//};
	//}

}
