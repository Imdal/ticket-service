package com.epam.training.ticketservice.dataaccess;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.epam.training.ticketservice.dataaccess")
@EntityScan("com.epam.training.ticketservice.dataaccess")
@EnableTransactionManagement
public class JpaConfiguration {

}
