package org.kj6682.hop;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
class MongoConfiguration extends AbstractMongoConfiguration{

    @Value("${mongodb.server}")
    private String server;

    @Value("${mongodb.port}")
    private Integer port;

    @Override
    public String getDatabaseName() {
        return "catalog";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(server, port );
    }

}
