package com.designpatterns.abstractfactory.storage.product.aws;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public final class AwsBackend {

    private final Map<String, Map<String, byte[]>> buckets = new ConcurrentHashMap<>();

    public void createBucket(String name) {
        if (buckets.putIfAbsent(name, new ConcurrentHashMap<>()) != null) {
            throw new IllegalStateException("Bucket already exists: " + name);
        }
    }

    public void deleteBucket(String name) {
        if (buckets.remove(name) == null) {
            throw new IllegalStateException("Bucket does not exist: " + name);
        }
    }

    public Set<String> listBuckets() {
        return Set.copyOf(buckets.keySet());
    }

    public boolean hasBucket(String name) {
        return buckets.containsKey(name);
    }

    public void putObject(String bucket, String key, byte[] data) {
        Map<String, byte[]> store = buckets.get(bucket);
        if (store == null) throw new IllegalStateException("No such bucket: " + bucket);
        store.put(key, data);
    }

    public byte[] getObject(String bucket, String key) {
        Map<String, byte[]> store = buckets.get(bucket);
        if (store == null) throw new IllegalStateException("No such bucket: " + bucket);
        byte[] data = store.get(key);
        if (data == null) throw new IllegalStateException("No such key: " + key);
        return data;
    }

    public void deleteObject(String bucket, String key) {
        Map<String, byte[]> store = buckets.get(bucket);
        if (store == null) throw new IllegalStateException("No such bucket: " + bucket);
        store.remove(key);
    }
}