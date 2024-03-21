package com.fatimetou.patient;

import com.fatimetou.patient.entities.Patient;
import com.fatimetou.patient.entities.Receptionniste;
import com.fatimetou.patient.entities.User;
import com.fatimetou.patient.repositories.MedecinRepository;
import com.fatimetou.patient.repositories.PatientRepository;
import com.fatimetou.patient.repositories.ReceptionnisteRepository;
import com.fatimetou.patient.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    @Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository,ReceptionnisteRepository receptionnisteRepository,PasswordEncoder passwordEncoder){
		return args -> {
			Receptionniste receptionniste=receptionnisteRepository.save(Receptionniste.builder().build());
			User user = User.builder()
					.nom("receptionist")
					.email("user@gmail.com")
					.password(passwordEncoder.encode("12345"))
					.receptionniste(receptionniste)
					.build();
			userRepository.save(user);
		};

	}
}
