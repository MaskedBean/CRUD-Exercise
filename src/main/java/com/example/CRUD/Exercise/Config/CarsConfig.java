package com.example.CRUD.Exercise.Config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class CarsConfig extends AbstractMongoClientConfiguration {


    @Override
    protected String getDatabaseName() {
        return "CarsDB";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString conn = new ConnectionString("mongodb+srv://admin:admin@cluster0.gohsy79.mongodb.net/ExerciseDB?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(conn)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.example");
    }
}
