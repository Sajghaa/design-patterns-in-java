package com.designpatterns.abstractfactory.storage.product.aws;

import com.designpatterns.abstractfactory.storage.product.BucketManager;
import com.designpatterns.abstractfactory.storage.product.StorageException;

import java.util.List;
import java.util.Objects;


public final class AwsBucketManager implements BucketManager {

    private final AwsBackend backend;

    public AwsBucketManager(AwsBackend backend) {
        this.backend = Objects.requireNonNull(backend, "backend");
    }

    @Override
    public void createBucket(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        try {
            backend.createBucket(bucket);
        } catch (RuntimeException e) {
            throw new StorageException("AWS createBucket failed: " + bucket, e);
        }
    }

    @Override
    public void deleteBucket(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        try {
            backend.deleteBucket(bucket);
        } catch (RuntimeException e) {
            throw new StorageException("AWS deleteBucket failed: " + bucket, e);
        }
    }

    @Override
    public List<String> listBuckets() {
        try {
            return List.copyOf(backend.listBuckets());
        } catch (RuntimeException e) {
            throw new StorageException("AWS listBuckets failed", e);
        }
    }

    @Override
    public boolean bucketExists(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        return backend.hasBucket(bucket);
    }
}