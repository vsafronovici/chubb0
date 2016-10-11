package com.chubb;

import com.chubb.testRunner.Connection;
import com.chubb.testRunner.ConnectionFactory;
import com.chubb.testRunner.utils.UrlPropertyResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) {
        System.out.println("==== Starting app ====");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			if (args.length == 0 )
			{
				log.error("No arguments provided!!!");
				return;
			}

            String url = new UrlPropertyResolver(args[0]).getUrlValue();

            Connection conn = null;
            if (url != null)
                conn = ConnectionFactory.getConnection(url);

            log.info(conn.getUrl());
		};
	}
}