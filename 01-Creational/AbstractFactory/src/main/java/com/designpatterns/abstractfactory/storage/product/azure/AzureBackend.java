package com.designpatterns.abstractfactory.storage.product.azure;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public final class AzureBackend {

    private final Map<String, Map<String, byte[]>> containers = new ConcurrentHashMap<>();

    public void createContainer(String name) {
        if (containers.putIfAbsent(name, new ConcurrentHashMap<>()) != null) {
            throw new IllegalStateException("Container already exists: " + name);
        }
    }

    public void deleteContainer(String name) {
        if (containers.remove(name) == null) {
            throw new IllegalStateException("Container does not exist: " + name);
        }
    }

    public Set<String> listContainers() {
        return Set.copyOf(containers.keySet());
    }

    public boolean hasContainer(String name) {
        return containers.containsKey(name);
    }

    public void putBlob(String container, String blob, byte[] data) {
        Map<String, byte[]> store = containers.get(container);
        if (store == null) throw new IllegalStateException("No such container: " + container);
        store.put(blob, data);
    }

    public byte[] getBlob(String container, String blob) {
        Map<String, byte[]> store = containers.get(container);
        if (store == null) throw new IllegalStateException("No such container: " + container);
        byte[] data = store.get(blob);
        if (data == null) throw new IllegalStateException("No such blob: " + blob);
        return data;
    }

    public void deleteBlob(String container, String blob) {
        Map<String, byte[]> store = containers.get(container);
        if (store == null) throw new IllegalStateException("No such container: " + container);
        store.remove(blob);
    }
}