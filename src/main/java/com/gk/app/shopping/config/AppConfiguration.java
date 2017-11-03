package com.gk.app.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfiguration {

	/**
	 * @return PropertySourcesPlaceholderConfigurer, Loading the Properties from
	 *         the file 'appliacation.propeties' located in classpath
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[] { new ClassPathResource("application.properties") };
		propertySourcesPlaceholderConfigurer.setLocations(resources);
		return propertySourcesPlaceholderConfigurer;
	}

}
