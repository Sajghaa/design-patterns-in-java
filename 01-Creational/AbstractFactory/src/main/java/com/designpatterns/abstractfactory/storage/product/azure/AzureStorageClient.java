package com.designpatterns.abstractfactory.storage.product.azure;

import com.designpatterns.abstractfactory.storage.product.StorageClient;
import com.designpatterns.abstractfactory.storage.product.StorageException;

import java.util.Objects;


public final class AzureStorageClient implements StorageClient {

    private final AzureBackend backend;

    public AzureStorageClient(AzureBackend backend) {
        this.backend = Objects.requireNonNull(backend, "backend");
    }

    @Override
    public void upload(String bucket, String key, byte[] data) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(data, "data");
        try {

            backend.putBlob(bucket, key, data.clone());
        } catch (RuntimeException e) {
            throw new StorageException(
                    "Azure upload failed: container=" + bucket + " blob=" + key, e);
        }
    }

    @Override
    public byte[] download(String bucket, String key) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        try {
            return backend.getBlob(bucket, key).clone();
        } catch (RuntimeException e) {
            throw new StorageException(
                    "Azure download failed: container=" + bucket + " blob=" + key, e);
        }
    }

    @Override
    public void delete(String bucket, String key) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        try {
            backend.deleteBlob(bucket, key);
        } catch (RuntimeException e) {
            throw new StorageException(
                    "Azure delete failed: container=" + bucket + " blob=" + key, e);
        }
    }

    @Override
    public String providerName() {
        return "Azure Blob Storage";
    }
}