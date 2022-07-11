package com.nology.musicplayer.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// @Configuration -> TO PROVIDE OUR SETUP / CONFIGURATION
// @ComponentScan -> WHICH & WHERE COMPONENTS / BEANS TO CREATE -> USING ANNOTATIONS TO CREATE THEM
// @PropertySource -> ALLOWS USE TO ADD IN VALUES WHEN WE NEED THEM E.G DATABASEURL

@Configuration
@ComponentScan("com.nology")
@PropertySource("classpath:app.properties")
public class AppConfig {
}
