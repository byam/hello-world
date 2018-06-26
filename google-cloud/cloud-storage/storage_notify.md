## Registering Object Changes

Resources:
- [Registering Object Changes](https://cloud.google.com/storage/docs/reporting-changes)
- [Cloud Pub/Sub Notifications for Cloud Storage](https://cloud.google.com/storage/docs/pubsub-notifications)

Set up and use Cloud Pub/Sub Notifications for Cloud Storage.

```bash
# set project
gcloud config set project [PROJECT_NAME]

# Applying a notification configuration
gsutil notification create -t [TOPIC_NAME] -f json gs://[BUCKET_NAME]

# Listing notification configurations for a bucket
gsutil notification list gs://[BUCKET_NAME]

# Removing a notification configuration
gsutil notification delete projects/_/buckets/[BUCKET_NAME]/notificationConfigs/[CONFIGURATION_NAME]
```

## Test Notifications

```bash
# create subscription
gcloud pubsub subscriptions create [SUBSCRIPTION_NAME] --topic [TOPIC_NAME]

# copy file to storage
echo "Hello World" > test.txt
gsutil cp test.txt gs://[BUCKET_NAME]

# pull from subscriptions
gcloud beta pubsub subscriptions pull [SUBSCRIPTION_NAME] --auto-ack --limit 1
```
