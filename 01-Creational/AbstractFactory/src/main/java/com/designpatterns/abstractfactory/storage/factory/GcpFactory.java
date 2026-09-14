package com.designpatterns.abstractfactory.storage.factory;

import com.designpatterns.abstractfactory.storage.product.BucketManager;
import com.designpatterns.abstractfactory.storage.product.StorageClient;
import com.designpatterns.abstractfactory.storage.product.UrlSigner;
import com.designpatterns.abstractfactory.storage.product.gcp.GcpBackend;
import com.designpatterns.abstractfactory.storage.product.gcp.GcpBucketManager;
import com.designpatterns.abstractfactory.storage.product.gcp.GcpStorageClient;
import com.designpatterns.abstractfactory.storage.product.gcp.GcpUrlSigner;

import java.util.Objects;

public final class GcpFactory implements CloudStorageFactory {

    private final GcpBackend backend;
    private final GcpUrlSigner urlSigner;

    public GcpFactory(String serviceAccountEmail, String privateKeyId) {
        Objects.requireNonNull(serviceAccountEmail, "serviceAccountEmail");
        Objects.requireNonNull(privateKeyId, "privateKeyId");

        this.backend = new GcpBackend();
        this.urlSigner = new GcpUrlSigner(serviceAccountEmail, privateKeyId);
    }

    @Override
    public StorageClient createStorageClient() {
        return new GcpStorageClient(backend);
    }

    @Override
    public BucketManager createBucketManager() {
        return new GcpBucketManager(backend);
    }

    @Override
    public UrlSigner createUrlSigner() {
        return urlSigner;
    }

    @Override
    public String providerName() {
        return "Google Cloud Storage";
    }
}