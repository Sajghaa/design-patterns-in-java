package com.designpatterns.abstractfactory.storage.product.azure;

import com.designpatterns.abstractfactory.storage.product.BucketManager;
import com.designpatterns.abstractfactory.storage.product.StorageException;

import java.util.List;
import java.util.Objects;


public final class AzureBucketManager implements BucketManager {

    private final AzureBackend backend;

    public AzureBucketManager(AzureBackend backend) {
        this.backend = Objects.requireNonNull(backend, "backend");
    }

    @Override
    public void createBucket(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        try {
            backend.createContainer(bucket);
        } catch (RuntimeException e) {
            throw new StorageException("Azure createContainer failed: " + bucket, e);
        }
    }

    @Override
    public void deleteBucket(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        try {
            backend.deleteContainer(bucket);
        } catch (RuntimeException e) {
            throw new StorageException("Azure deleteContainer failed: " + bucket, e);
        }
    }

    @Override
    public List<String> listBuckets() {
        try {
            return List.copyOf(backend.listContainers());
        } catch (RuntimeException e) {
            throw new StorageException("Azure listContainers failed", e);
        }
    }

    @Override
    public boolean bucketExists(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        return backend.hasContainer(bucket);
    }
}