package com.designpatterns.abstractfactory.storage.product.aws;

import com.designpatterns.abstractfactory.storage.product.StorageClient;
import com.designpatterns.abstractfactory.storage.product.StorageException;

import java.util.Objects;


public final class AwsStorageClient implements StorageClient {

    private final AwsBackend backend;

    public AwsStorageClient(AwsBackend backend) {
        this.backend = Objects.requireNonNull(backend, "backend");
    }

    @Override
    public void upload(String bucket, String key, byte[] data) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(data, "data");
        try {

            backend.putObject(bucket, key, data.clone());
        } catch (RuntimeException e) {
            throw new StorageException(
                    "AWS upload failed: s3://" + bucket + "/" + key, e);
        }
    }

    @Override
    public byte[] download(String bucket, String key) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        try {
            // In real AWS SDK:
            // return s3Client.getObjectAsBytes(
            //     GetObjectRequest.builder().bucket(bucket).key(key).build()
            // ).asByteArray();
            return backend.getObject(bucket, key).clone();
        } catch (RuntimeException e) {
            throw new StorageException(
                    "AWS download failed: s3://" + bucket + "/" + key, e);
        }
    }

    @Override
    public void delete(String bucket, String key) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        try {
            backend.deleteObject(bucket, key);
        } catch (RuntimeException e) {
            throw new StorageException(
                    "AWS delete failed: s3://" + bucket + "/" + key, e);
        }
    }

    @Override
    public String providerName() {
        return "AWS S3";
    }
}