package com.michaelcaxias.catalogs.api.src.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.Topic;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AwsSQSConfig {

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.credentials.access_key}")
    private String accesskey;

    @Value("${cloud.aws.credentials.secret_key}")
    private String secretkey;

    @Value("${cloud.aws.topics.catalog_emit.arn}")
    private String catalogEmitArn;

    private AwsCredentials awsCredentials() {
        return AwsBasicCredentials.create(accesskey, secretkey);
    }

    private Region awsRegion() {
        return Region.of(region);
    }

    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(awsRegion())
                .credentialsProvider(this::awsCredentials)
                .build();
    }

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
                .region(awsRegion())
                .credentialsProvider(this::awsCredentials)
                .build();
    }

    @Bean(name = "catalogEmitTopic")
    public Topic catalogEmitTopic() {
        return Topic.builder()
                .topicArn(catalogEmitArn)
                .build();
    }
}
