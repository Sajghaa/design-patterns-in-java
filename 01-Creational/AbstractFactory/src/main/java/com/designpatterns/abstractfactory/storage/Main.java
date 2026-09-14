package com.designpatterns.abstractfactory.storage;

import com.designpatterns.abstractfactory.storage.factory.AwsFactory;
import com.designpatterns.abstractfactory.storage.factory.AzureFactory;
import com.designpatterns.abstractfactory.storage.factory.CloudStorageFactory;
import com.designpatterns.abstractfactory.storage.factory.GcpFactory;
import com.designpatterns.abstractfactory.storage.service.DocumentService;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        String provider = args.length > 0
                ? args[0].toLowerCase()
                : "aws";

        CloudStorageFactory factory = createFactory(provider);
        System.out.println("=== Abstract Factory Demo — provider: "
                + factory.providerName() + " ===\n");

        DocumentService service = new DocumentService(factory);

        String bucket = "design-patterns-demo";
        String key = "docs/abstract-factory.txt";
        byte[] content = ("Abstract Factory is the real deal."
                + "\nWe just stored this document without knowing which cloud."
                + "\n").getBytes(StandardCharsets.UTF_8);

        service.storeDocument(bucket, key, content);

        System.out.println();
        byte[] fetched = service.fetchDocument(bucket, key);
        System.out.println("Fetched back:");
        System.out.println("  " + new String(fetched, StandardCharsets.UTF_8).trim());

        System.out.println();
        System.out.println("Buckets for this provider: " + service.listBuckets());

        service.removeDocument(bucket, key);
        service.dropBucket(bucket);
        System.out.println("Buckets after cleanup: " + service.listBuckets());

        System.out.println("\n=== Done. Same code, any cloud. ===");
    }


    private static CloudStorageFactory createFactory(String provider) {
        return switch (provider) {
            case "aws" -> new AwsFactory(
                    "AKIA-DEMO-ACCESS-KEY",
                    "demo-secret-key",
                    "us-east-1");
            case "azure" -> new AzureFactory(
                    "demostorageaccount",
                    "demo-account-key",
                    "core.windows.net");
            case "gcp" -> new GcpFactory(
                    "demo@project.iam.gserviceaccount.com",
                    "demo-private-key-id");
            default -> throw new IllegalArgumentException(
                    "Unknown provider: " + provider
                            + " (expected one of: " + Arrays.toString(
                                    new String[]{"aws", "azure", "gcp"}) + ")");
        };
    }
}