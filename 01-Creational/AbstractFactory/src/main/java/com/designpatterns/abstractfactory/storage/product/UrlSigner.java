package com.designpatterns.abstractfactory.storage.product;

import java.time.Duration;

public interface UrlSigner {

    String signDownloadUrl(String bucket, String key, Duration ttl);

    String signUploadUrl(String bucket, String key, Duration ttl);
}
