package com.michaelcaxias.catalogs.api.src.repositories.aws.s3;

public interface S3Service {
    void saveObjectJSON(String key, Object obj);
}
