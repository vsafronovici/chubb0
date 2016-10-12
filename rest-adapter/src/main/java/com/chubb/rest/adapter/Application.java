package com.chubb.rest.adapter;

import com.chubb.rest.adapter.request.Connection;
import com.chubb.rest.adapter.request.ConnectionFactory;
import com.chubb.rest.adapter.util.Environment;
import com.chubb.rest.adapter.util.PropertyCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by ichistruga on 10/11/2016.
 */
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        System.out.println("==== Starting app ====");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner startPoint() {
        return (args) -> {
            if (args.length == 0 )
            {
                log.error("No arguments provided!!!");
                return;
            }

            Environment.setName(args[0]);
            PropertyCache.getProperties();

            Connection conn = ConnectionFactory.getConnection(PropertyCache.getProperties().get(PropertyCache.urlKey));

            log.info(conn.getServer());
        };
    }
}
