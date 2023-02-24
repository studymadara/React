package com.react.java.config;

import com.react.java.dao.student.StudentDaoDynamo;
import com.react.java.dao.user.UserDaoDynamo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String endpoint;
    @Value("${amazon.aws.accesskey}")
    private String accessKey;
    @Value("${amazon.aws.secretkey}")
    private String secretKey;


    @Bean
    public DynamoDbClient amazonDynamoDB() {
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKey, secretKey);

        return DynamoDbClient
                .builder()
                .region(Region.EU_WEST_1)
                .endpointOverride(URI.create(endpoint))
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder().dynamoDbClient(dynamoDbClient).build();
    }

    @Bean
    public StudentDaoDynamo studentDaoDynamo(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        return new StudentDaoDynamo(dynamoDbEnhancedClient);
    }

    @Bean
    public UserDaoDynamo userDaoDynamo(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        return new UserDaoDynamo(dynamoDbEnhancedClient);
    }
}
