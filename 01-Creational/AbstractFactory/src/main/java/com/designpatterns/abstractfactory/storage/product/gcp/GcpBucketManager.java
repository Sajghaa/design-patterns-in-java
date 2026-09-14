package com.designpatterns.abstractfactory.storage.product.gcp;

import com.designpatterns.abstractfactory.storage.product.BucketManager;
import com.designpatterns.abstractfactory.storage.product.StorageException;

import java.util.List;
import java.util.Objects;


public final class GcpBucketManager implements BucketManager {

    private final GcpBackend backend;

    public GcpBucketManager(GcpBackend backend) {
        this.backend = Objects.requireNonNull(backend, "backend");
    }

    @Override
    public void createBucket(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        try {
            backend.createBucket(bucket);
        } catch (RuntimeException e) {
            throw new StorageException("GCP createBucket failed: " + bucket, e);
        }
    }

    @Override
    public void deleteBucket(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        try {
            backend.deleteBucket(bucket);
        } catch (RuntimeException e) {
            throw new StorageException("GCP deleteBucket failed: " + bucket, e);
        }
    }

    @Override
    public List<String> listBuckets() {
        try {
            return List.copyOf(backend.listBuckets());
        } catch (RuntimeException e) {
            throw new StorageException("GCP listBuckets failed", e);
        }
    }

    @Override
    public boolean bucketExists(String bucket) {
        Objects.requireNonNull(bucket, "bucket");
        return backend.hasBucket(bucket);
    }
}