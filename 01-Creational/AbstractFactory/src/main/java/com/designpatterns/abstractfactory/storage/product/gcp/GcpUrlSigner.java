package com.designpatterns.abstractfactory.storage.product.gcp;

import com.designpatterns.abstractfactory.storage.product.StorageException;
import com.designpatterns.abstractfactory.storage.product.UrlSigner;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Objects;


public final class GcpUrlSigner implements UrlSigner {

    private final String serviceAccountEmail;
    private final String privateKeyId;

    public GcpUrlSigner(String serviceAccountEmail, String privateKeyId) {
        this.serviceAccountEmail = Objects.requireNonNull(serviceAccountEmail, "serviceAccountEmail");
        this.privateKeyId = Objects.requireNonNull(privateKeyId, "privateKeyId");
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
                    .encodeToString((payload + privateKeyId)
                            .getBytes(StandardCharsets.UTF_8));

            return String.format(
                    "https://storage.googleapis.com/%s/%s"
                            + "?X-Goog-Algorithm=GOOG4-RSA-SHA256"
                            + "&X-Goog-Credential=%s"
                            + "&X-Goog-Date=%s"
                            + "&X-Goog-Expires=%d"
                            + "&X-Goog-Signature=%s",
                    bucket, key, serviceAccountEmail,
                    Instant.ofEpochSecond(expiresAt),
                    ttl.getSeconds(),
                    signature);
        } catch (RuntimeException e) {
            throw new StorageException(
                    "GCP signing failed: gs://" + bucket + "/" + key, e);
        }
    }
}