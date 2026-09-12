# Abstract Factory — Multi-Cloud Storage

A real-world implementation of the **Abstract Factory** design pattern
using a cloud storage abstraction (AWS S3, Azure Blob, GCP).

## Pattern Intent
Provide an interface for creating families of related objects
(StorageClient, BucketManager, PresignedUrlGenerator) without
specifying their concrete classes.

## Why Abstract Factory?
- Guarantees consistency: you can't mix an AWS client with an Azure bucket manager
- Client code is cloud-agnostic
- Adding a new cloud = add new package, zero changes to existing code

## Run
```bash
mvn compile exec:java -Dexec.args="aws"
mvn compile exec:java -Dexec.args="azure"
mvn compile exec:java -Dexec.args="gcp"