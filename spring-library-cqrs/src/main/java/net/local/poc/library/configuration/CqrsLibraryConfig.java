package net.local.poc.library.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "net.local.poc.library")
public class CqrsLibraryConfig {   
}
