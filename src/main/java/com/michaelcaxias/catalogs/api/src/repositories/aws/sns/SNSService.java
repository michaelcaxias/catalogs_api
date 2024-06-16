package com.michaelcaxias.catalogs.api.src.repositories.aws.sns;

import software.amazon.awssdk.services.sns.model.Topic;

public interface SNSService {
    void publish(Topic topic, String message);
}
