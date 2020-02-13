package com.github.mcnew.misc.users.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.github.mcnew.misc.users.repository")
class ApplicationConfiguration {

}