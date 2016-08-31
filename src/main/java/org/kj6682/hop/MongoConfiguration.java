package org.kj6682.hop;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MongoConfiguration {


    @Value("${mongodb.uri}")
    String mongoURIString;

    @Value("${mongodb.port}")
    String mongoPort;


    @Bean
    public MongoClient mongoClient(){
        String mongoUri = new StringBuilder(mongoURIString).append(":").append(mongoPort).toString();
        return new MongoClient(new MongoClientURI(mongoUri));
    }

    @Bean
    public MongoDatabase mongoDatabase(){
        return mongoClient().getDatabase("catalog");
    }

    @Bean
    public MongoCollection<Document> hopCollection(){
        return mongoDatabase().getCollection("hop");
    }

    @Bean
    public HopService hopService(){
        return new HopServiceMongoImpl(hopCollection());
    }

}
