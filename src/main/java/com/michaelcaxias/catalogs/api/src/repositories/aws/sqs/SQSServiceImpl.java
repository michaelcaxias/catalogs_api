package com.michaelcaxias.catalogs.api.src.repositories.aws.sqs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michaelcaxias.catalogs.api.src.exceptions.ApiException;
import com.michaelcaxias.catalogs.api.src.repositories.aws.s3.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class SQSServiceImpl implements SQSService {
    @Autowired
    private SqsClient sqsClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void sendMessage(final String queueURL, final Object objectMessage) {
        try {
            String message = objectMapper.writeValueAsString(objectMessage);

            final SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                    .queueUrl(queueURL)
                    .messageBody(message)
                    .build();

            sqsClient.sendMessage(sendMsgRequest);

            log.info("Message sent to SQS: {}", message);
        } catch (JsonProcessingException e) {
            log.error("Error on send message to SQS", e);
            throw new ApiException("Error on send message to SQS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
