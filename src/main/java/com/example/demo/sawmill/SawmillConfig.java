package com.example.demo.sawmill;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class SawmillConfig {

            @Bean
            CommandLineRunner commandLineRunner(SawmillRepository sawmillRepository){
                return args -> {
                    Sawmill sawmill1
                            = new Sawmill(
                            "Asma",
                            "Damascus",
                            "Syria",
                            LocalDate.now(),
                            LocalDate.now()
                    );

                    Sawmill sawmill2
                            = new Sawmill(
                            "Viktor",
                            "Berlin",
                            "Germany",
                            LocalDate.now(),
                            LocalDate.now()
                    );

                   /* sawmillRepository.saveAll(
                            List.of(sawmill1,sawmill2)
                    );*/
                    sawmillRepository.save(sawmill1);
                    sawmillRepository.save(sawmill2);
                };
            }
}
