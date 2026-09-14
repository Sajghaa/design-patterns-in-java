package com.designpatterns.abstractfactory.storage.product.azure;

import com.designpatterns.abstractfactory.storage.product.StorageException;
import com.designpatterns.abstractfactory.storage.product.UrlSigner;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Objects;


public final class AzureUrlSigner implements UrlSigner {

    private final String accountName;
    private final String accountKey;
    private final String endpointSuffix;

    public AzureUrlSigner(String accountName, String accountKey, String endpointSuffix) {
        this.accountName = Objects.requireNonNull(accountName, "accountName");
        this.accountKey = Objects.requireNonNull(accountKey, "accountKey");
        this.endpointSuffix = Objects.requireNonNull(endpointSuffix, "endpointSuffix");
    }

    @Override
    public String signDownloadUrl(String bucket, String key, Duration ttl) {
        return sign("r", bucket, key, ttl);
    }

    @Override
    public String signUploadUrl(String bucket, String key, Duration ttl) {
        return sign("w", bucket, key, ttl);
    }

    private String sign(String permission, String bucket, String key, Duration ttl) {
        Objects.requireNonNull(bucket, "bucket");
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(ttl, "ttl");
        if (ttl.isNegative() || ttl.isZero()) {
            throw new IllegalArgumentException("TTL must be positive");
        }
        try {
            long expiresAt = Instant.now().plus(ttl).getEpochSecond();
            String payload = permission + "\n" + bucket + "\n" + key + "\n" + expiresAt;
            String signature = Base64.getUrlEncoder().withoutPadding()
                    .encodeToString((payload + accountKey)
                            .getBytes(StandardCharsets.UTF_8));

            return String.format(
                    "https://%s.blob.%s/%s/%s"
                            + "?sv=2023-11-03"
                            + "&sp=%s"
                            + "&se=%s"
                            + "&sig=%s",
                    accountName, endpointSuffix, bucket, key,
                    permission,
                    Instant.ofEpochSecond(expiresAt),
                    signature);
        } catch (RuntimeException e) {
            throw new StorageException(
                    "Azure SAS signing failed: " + bucket + "/" + key, e);
        }
    }
}