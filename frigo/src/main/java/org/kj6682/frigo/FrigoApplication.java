package org.kj6682.frigo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * This is the main Application.
 * It embeds its configuration in order to keep things clean and simple.
 */

@SpringBootApplication
public class FrigoApplication {

    public static void main(String[] args) {
		SpringApplication.run(FrigoApplication.class, args);
	}

	@Configuration
	@EnableMongoRepositories
	class MongoConfiguration extends AbstractMongoConfiguration {

		@Value("${mongodb.server}")
		private String server;

		@Value("${mongodb.port}")
		private Integer port;

		@Value("${mongodb.name}")
		private String databaseName;


		@Override
		public String getDatabaseName() {
			return databaseName;
		}

		@Override
		@Bean
		public Mongo mongo() throws Exception {
			return new MongoClient(server, port );
		}

	}

}
