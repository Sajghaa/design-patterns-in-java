package com.designpatterns.abstractfactory.storage.factory;

import com.designpatterns.abstractfactory.storage.product.BucketManager;
import com.designpatterns.abstractfactory.storage.product.StorageClient;
import com.designpatterns.abstractfactory.storage.product.UrlSigner;


public interface CloudStorageFactory {

   
    StorageClient createStorageClient();


    BucketManager createBucketManager();

 
    UrlSigner createUrlSigner();

    
    String providerName();
}