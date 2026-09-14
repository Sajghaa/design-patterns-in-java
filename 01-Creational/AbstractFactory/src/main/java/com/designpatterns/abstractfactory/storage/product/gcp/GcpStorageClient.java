package com.designpatterns.abstractfactory.storage.product.gcp;

import com.designpatterns.abstractfactory.storage.product.StorageClient;
import com.designpatterns.abstractfactory.storage.product.StorageException;

import java.util.Objects;

public final class GcpStorageClient implements StorageClient {

    private final GcpBackend backend;

    public GcpStorageClient(GcpBackend backend) {
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
                    "GCP upload failed: gs://" + bucket + "/" + key, e);
        }
    }

    @Override
    public byte[] download(String bucket, String key) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        try {
            return backend.getObject(bucket, key).clone();
        } catch (RuntimeException e) {
            throw new StorageException(
                    "GCP download failed: gs://" + bucket + "/" + key, e);
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
                    "GCP delete failed: gs://" + bucket + "/" + key, e);
        }
    }

    @Override
    public String providerName() {
        return "Google Cloud Storage";
    }
}