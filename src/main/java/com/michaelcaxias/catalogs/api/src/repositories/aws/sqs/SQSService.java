package com.michaelcaxias.catalogs.api.src.repositories.aws.sqs;

public interface SQSService {
    void sendMessage(String queueURL, Object objectMessage);
}
