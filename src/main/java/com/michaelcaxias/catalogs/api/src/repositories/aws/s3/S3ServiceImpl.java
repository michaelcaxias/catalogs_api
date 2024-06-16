package com.michaelcaxias.catalogs.api.src.repositories.aws.s3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michaelcaxias.catalogs.api.src.exceptions.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class S3ServiceImpl implements S3Service {
    @Autowired
    private S3Client s3Client;

    @Autowired
    private ObjectMapper objectMapper;

    private final String ERROR_MESSAGE = "Error processing JSON";

    private final String BUCKET_NAME = "catalogs-mich-test";

    @Override
    public void saveObjectJSON(String key, Object obj) {
        try {
            final String json = objectMapper.writeValueAsString(obj);

            final PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(key)
                    .build();

            s3Client.putObject(request, RequestBody.fromString(json, StandardCharsets.UTF_8));
        } catch (JsonProcessingException e) {
            log.error(ERROR_MESSAGE, e);
            throw new ApiException(
                    HttpStatus.INTERNAL_SERVER_ERROR.name(),
                    ERROR_MESSAGE,
                    HttpStatus.INTERNAL_SERVER_ERROR.value()
            );
        }
    }
}
