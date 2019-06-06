/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.joufa.spring.configuration;

import fi.joufa.databaserepository.mapper.DomainToEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @author udanre */
@Configuration
public class MapperFactory {
  @Bean
  public DomainToEntityMapper domainToEntityMapper() {
    return new DomainToEntityMapper();
  }
}