package com.designpatterns.abstractfactory.storage.service;

import com.designpatterns.abstractfactory.storage.factory.CloudStorageFactory;
import com.designpatterns.abstractfactory.storage.product.BucketManager;
import com.designpatterns.abstractfactory.storage.product.StorageClient;
import com.designpatterns.abstractfactory.storage.product.UrlSigner;

import java.time.Duration;
import java.util.List;
import java.util.Objects;


public final class DocumentService {

    private final CloudStorageFactory factory;
    private final StorageClient client;
    private final BucketManager bucketManager;
    private final UrlSigner urlSigner;


    public DocumentService(CloudStorageFactory factory) {
        this.factory = Objects.requireNonNull(factory, "factory");
        this.client = factory.createStorageClient();
        this.bucketManager = factory.createBucketManager();
        this.urlSigner = factory.createUrlSigner();
    }

    public String storeDocument(String bucket, String key, byte[] content) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(content, "content");

        log("Using provider: " + factory.providerName());

        if (!bucketManager.bucketExists(bucket)) {
            log("Bucket '" + bucket + "' does not exist — creating it.");
            bucketManager.createBucket(bucket);
        } else {
            log("Bucket '" + bucket + "' already exists.");
        }

        log("Uploading " + content.length + " bytes to " + bucket + "/" + key);
        client.upload(bucket, key, content);

        String url = urlSigner.signDownloadUrl(bucket, key, Duration.ofMinutes(15));
        log("Generated presigned URL (valid 15 min):");
        System.out.println("  " + url);

        return url;
    }

    public byte[] fetchDocument(String bucket, String key) {
        log("Downloading " + bucket + "/" + key);
        return client.download(bucket, key);
    }

    public void removeDocument(String bucket, String key) {
        log("Deleting " + bucket + "/" + key);
        client.delete(bucket, key);
    }

    public List<String> listBuckets() {
        return bucketManager.listBuckets();
    }

    public void dropBucket(String bucket) {
        log("Dropping bucket '" + bucket + "'");
        bucketManager.deleteBucket(bucket);
    }

    private void log(String message) {
        System.out.println("[" + factory.providerName() + "] " + message);
    }
}