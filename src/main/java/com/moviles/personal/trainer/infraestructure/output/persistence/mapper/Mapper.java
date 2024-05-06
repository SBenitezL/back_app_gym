package com.moviles.personal.trainer.infraestructure.output.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper createMapper() {
        ModelMapper mapper = new ModelMapper();

        return mapper;
    }
}