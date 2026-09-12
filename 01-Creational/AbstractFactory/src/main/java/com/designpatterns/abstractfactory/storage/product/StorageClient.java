package com.designpatterns.abstractfactory.storage.product;


public interface StorageClient {

  void upload(String bucket, String key, byte[] data);
  
  byte[] download(String bucket, String key);

  void delete(String bucket, String Key);

  String providerName();
    
} 