package com.designpatterns.abstractfactory.storage.factory;

import com.designpatterns.abstractfactory.storage.product.BucketManager;
import com.designpatterns.abstractfactory.storage.product.StorageClient;
import com.designpatterns.abstractfactory.storage.product.UrlSigner;
import com.designpatterns.abstractfactory.storage.product.aws.AwsBackend;
import com.designpatterns.abstractfactory.storage.product.aws.AwsBucketManager;
import com.designpatterns.abstractfactory.storage.product.aws.AwsStorageClient;
import com.designpatterns.abstractfactory.storage.product.aws.AwsUrlSigner;

import java.util.Objects;


public final class AwsFactory implements CloudStorageFactory {

    private final AwsBackend backend;
    private final AwsUrlSigner urlSigner;

    public AwsFactory(String accessKeyId, String secretAccessKey, String region) {
        Objects.requireNonNull(accessKeyId, "accessKeyId");
        Objects.requireNonNull(secretAccessKey, "secretAccessKey");
        Objects.requireNonNull(region, "region");

        this.backend = new AwsBackend();

        this.urlSigner = new AwsUrlSigner(accessKeyId, secretAccessKey, region);
    }

    @Override
    public StorageClient createStorageClient() {
        return new AwsStorageClient(backend);
    }

    @Override
    public BucketManager createBucketManager() {
        return new AwsBucketManager(backend);
    }

    @Override
    public UrlSigner createUrlSigner() {
        return urlSigner;
    }

    @Override
    public String providerName() {
        return "AWS S3";
    }
}