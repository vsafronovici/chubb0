package com.chubb.rest.adapter;

import com.chubb.rest.adapter.client.RestJsonClient;
import com.chubb.rest.adapter.client.RestJsonClientImpl;
import com.chubb.rest.adapter.connection.Connection;
import com.chubb.rest.adapter.connection.ConnectionFactory;
import com.chubb.rest.adapter.exception.CriticalException;
import com.chubb.rest.adapter.util.Environment;
import com.chubb.rest.adapter.util.PropertyCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ichistruga on 10/11/2016.
 */
@SpringBootApplication
//@ComponentScan("com.chubb.rest.adapter.client")
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        System.out.println("==== Starting app ====");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }



    @Bean
    public CommandLineRunner startPoint() {
        return (args) -> {

            /*Environment.setName(args[0]);
            PropertyCache.getProperties();

            Connection conn = ConnectionFactory.getConnection(PropertyCache.getProperties().get(Environment.getName()));
            if(PropertyCache.getProperty(Environment.getName()) != null){
                throw new CriticalException("Environment not found.");
            }
            Connection conn = ConnectionFactory.getConnection(PropertyCache.getProperty(Environment.getName()));

            log.info(conn.getServer());*/
        };
    }
}
