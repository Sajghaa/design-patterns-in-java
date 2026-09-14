package com.designpatterns.abstractfactory.storage.factory;

import com.designpatterns.abstractfactory.storage.product.BucketManager;
import com.designpatterns.abstractfactory.storage.product.StorageClient;
import com.designpatterns.abstractfactory.storage.product.UrlSigner;
import com.designpatterns.abstractfactory.storage.product.azure.AzureBackend;
import com.designpatterns.abstractfactory.storage.product.azure.AzureBucketManager;
import com.designpatterns.abstractfactory.storage.product.azure.AzureStorageClient;
import com.designpatterns.abstractfactory.storage.product.azure.AzureUrlSigner;

import java.util.Objects;


public final class AzureFactory implements CloudStorageFactory {

    private final AzureBackend backend;
    private final AzureUrlSigner urlSigner;

    public AzureFactory(String accountName, String accountKey, String endpointSuffix) {
        Objects.requireNonNull(accountName, "accountName");
        Objects.requireNonNull(accountKey, "accountKey");
        Objects.requireNonNull(endpointSuffix, "endpointSuffix");

        this.backend = new AzureBackend();
        this.urlSigner = new AzureUrlSigner(accountName, accountKey, endpointSuffix);
    }

    @Override
    public StorageClient createStorageClient() {
        return new AzureStorageClient(backend);
    }

    @Override
    public BucketManager createBucketManager() {
        return new AzureBucketManager(backend);
    }

    @Override
    public UrlSigner createUrlSigner() {
        return urlSigner;
    }

    @Override
    public String providerName() {
        return "Azure Blob Storage";
    }
}