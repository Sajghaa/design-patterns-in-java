package com.designpatterns.abstractfactory.storage.product.aws;

import com.designpatterns.abstractfactory.storage.product.StorageException;
import com.designpatterns.abstractfactory.storage.product.UrlSigner;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Objects;


public final class AwsUrlSigner implements UrlSigner {

    private final String accessKeyId;
    private final String secretAccessKey;
    private final String region;

    public AwsUrlSigner(String accessKeyId, String secretAccessKey, String region) {
        this.accessKeyId = Objects.requireNonNull(accessKeyId, "accessKeyId");
        this.secretAccessKey = Objects.requireNonNull(secretAccessKey, "secretAccessKey");
        this.region = Objects.requireNonNull(region, "region");
    }

    @Override
    public String signDownloadUrl(String bucket, String key, Duration ttl) {
        return sign("GET", bucket, key, ttl);
    }

    @Override
    public String signUploadUrl(String bucket, String key, Duration ttl) {
        return sign("PUT", bucket, key, ttl);
    }

    private String sign(String method, String bucket, String key, Duration ttl) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(ttl, "ttl");
        if (ttl.isNegative() || ttl.isZero()) {
            throw new IllegalArgumentException("TTL must be positive");
        }
        try {

            long expiresAt = Instant.now().plus(ttl).getEpochSecond();
            String payload = method + "\n" + bucket + "\n" + key + "\n" + expiresAt;
            String signature = Base64.getUrlEncoder().withoutPadding()
                    .encodeToString((payload + secretAccessKey)
                            .getBytes(StandardCharsets.UTF_8));

            return String.format(
                    "https://%s.s3.%s.amazonaws.com/%s"
                            + "?X-Amz-Algorithm=AWS4-HMAC-SHA256"
                            + "&X-Amz-Credential=%s"
                            + "&X-Amz-Expires=%d"
                            + "&X-Amz-Signature=%s",
                    bucket, region, key, accessKeyId, ttl.getSeconds(), signature);
        } catch (RuntimeException e) {
            throw new StorageException(
                    "AWS presign failed: s3://" + bucket + "/" + key, e);
        }
    }
}