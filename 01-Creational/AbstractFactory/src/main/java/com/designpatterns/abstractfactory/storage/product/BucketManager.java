package com.designpatterns.abstractfactory.storage.product;

import java.util.List;

public interface BucketManager {
    

    void createBucket(String bucket);

    void deleteBucket(String bucket);

    List<String> listBuckets();

    boolean bucketExists(String bucket);


}
