package com.michaelcaxias.catalogs.api.src.repositories.aws.sns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michaelcaxias.catalogs.api.src.controllers.dto.MessageDto;
import com.michaelcaxias.catalogs.api.src.exceptions.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.Topic;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
@Slf4j
public class SNSServiceImpl implements SNSService {
    @Autowired
    private SnsClient snsClient;

    @Override
    public void publish(final Topic topic, final String message) {
        final PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(topic.topicArn())
                .message(message)
                .build();

        final PublishResponse publishResponse = snsClient.publish(publishRequest);

        log.info("Message published with ID: {}", publishResponse.messageId());
    }
}
