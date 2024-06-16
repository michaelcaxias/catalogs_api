package com.michaelcaxias.catalogs.api.src.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;

@Configuration
public class AwsSQSConfig {

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.credentials.access_key}")
    private String accesskey;

    @Value("${cloud.aws.credentials.secret_key}")
    private String secretkey;

    private AwsCredentials awsCredentials() {
        return AwsBasicCredentials.create(accesskey, secretkey);
    }

    private Region awsRegion() {
        return Region.of(region);
    }
}
