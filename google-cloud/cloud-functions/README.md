# Cloud Functions

## Overview
Google Cloud Functions is a serverless execution environment for building and connecting cloud services. 
With Cloud Functions you write simple, single-purpose functions that are attached to events emitted from your cloud infrastructure and services. 
Your Cloud Function is triggered when an event being watched is fired. Your code executes in a fully managed environment. 
There is no need to provision any infrastructure or worry about managing any servers.

Cloud Functions are written in Javascript and execute in a Node.js v6.11.5 environment on Google Cloud Platform. 
You can take your Cloud Function and run it in any standard Node.js runtime which makes both portability and local testing a breeze.

## Connect and Extend Cloud Services
Cloud Functions provides a connective layer of logic that lets you write code to connect and extend cloud services. 
Listen and respond to a file upload to Cloud Storage, a log change, or an incoming message on a Cloud Pub/Sub topic. 
Cloud Functions augments existing cloud services and allows you to address an increasing number of use cases with arbitrary programming logic. 
Cloud Functions have access to the Google Service Account credential and are thus seamlessly authenticated with the majority of 
Google Cloud Platform services such as Datastore, Cloud Spanner, Cloud Translation API, Cloud Vision API, as well as many others. 
In addition, Cloud Functions are supported by numerous Node.js client libraries, which further simplify these integrations.
   
## Events and Triggers
Cloud events are things that happen in your cloud environment.
These might be things like changes to data in a database, files added to a storage system, or a new virtual machine instance being created.

Events occur whether or not you choose to respond to them. You create a response to an event with a trigger. 
A trigger is a declaration that you are interested in a certain event or set of events. 
Binding a function to a trigger allows you to capture and act on events. 
For more information on creating triggers and associating them with your functions, see [Events and Triggers](https://cloud.google.com/functions/docs/concepts/events-triggers).

## Serverless
Cloud Functions removes the work of managing servers, configuring software, updating frameworks, and patching operating systems. 
The software and infrastructure are fully managed by Google so that you just add code. 
Furthermore, provisioning of resources happens automatically in response to events. 
This means that a function can scale from a few invocations a day to many millions of invocations without any work from you.

## Use Cases
Asynchronous workloads like lightweight ETL, 
or cloud automations like triggering application builds now no longer need their own server and a developer to wire it up. 
You simply deploy a Cloud Function bound to the event you want and you're done.

The fine-grained, on-demand nature of Cloud Functions also makes it a perfect candidate for lightweight APIs and webhooks. 
In addition, the automatic provisioning of HTTP endpoints when you deploy an HTTP Function means 
there is no complicated configuration required as there is with some other services. 

### Data Processing / ETL
Listen and respond to Cloud Storage events such as when a file is created, changed, or removed. 
Process images, perform video transcoding, validate and transform data, and invoke any service on the Internet from your Cloud Function.

### Webhooks
Via a simple HTTP trigger, respond to events originating from 3rd party systems like GitHub, Slack, Stripe, or from anywhere that can send HTTP requests.

### Lightweight APIs
Compose applications from lightweight, loosely coupled bits of logic that are quick to build and that scale instantly. 
Your functions can be event-driven or invoked directly over HTTP/S.

### Mobile Backend
Use Google's mobile platform for app developers, Firebase, and write your mobile backend in Cloud Functions. 
Listen and respond to events from Firebase Analytics, Realtime Database, Authentication, and Storage.

### IoT
Imagine tens or hundreds of thousands of devices streaming data into Cloud Pub/Sub, 
thereby launching Cloud Functions to process, transform and store data. 
Cloud Functions lets you do in a way that's completely serverless.


## Simple Cloud Function

### Create a function

- This function writes a message to the Cloud Functions logs. 
- It is triggered by cloud function events and accepts a callback function used to signal completion of the function.

- For this lab the cloud function event is a cloud pub/sub topic event. 
    - A pub/sub is a messaging service where the senders of messages are decoupled from the receivers of messages. 

```javascript
/**
* Cloud Function.
*
* @param {object} event The Cloud Functions event.
* @param {function} callback The callback function.
*/
exports.helloWorld = function helloWorld (event, callback) {
console.log(`My Cloud Function: ${event.data.message}`);
callback();
};
```

```bash
gsutil mb -p qwiklabs-gcp-1d906aa8a937a69a gs://byam-gcf
```

### Deploy your function

* When deploying a new function, you must specify 
    - `--trigger-topic`, `--trigger-bucket`, or `--trigger-http`. 
* When deploying an update to an existing function, the function keeps the existing trigger unless otherwise specified.

1. Deploy the function to a pub/sub topic named hello\_world:
```bash
gcloud beta functions deploy helloWorld --stage-bucket byam-gcf --trigger-topic hello_world
```
2. Verify the status of the function.
```bash
gcloud beta functions describe helloWorld

availableMemoryMb: 256
entryPoint: helloWorld
eventTrigger:
  eventType: google.pubsub.topic.publish
  failurePolicy: {}
  resource: projects/qwiklabs-gcp-1d906aa8a937a69a/topics/hello_world
  service: pubsub.googleapis.com
labels:
  deployment-tool: cli-gcloud
name: projects/qwiklabs-gcp-1d906aa8a937a69a/locations/us-central1/functions/helloWorld
runtime: nodejs6
serviceAccountEmail: qwiklabs-gcp-1d906aa8a937a69a@appspot.gserviceaccount.com
sourceArchiveUrl: gs://byam-gcf/us-central1-projects/qwiklabs-gcp-1d906aa8a937a69a/locations/us-central1/functions/helloWorld-vjyysctofvkw.zip
status: ACTIVE
timeout: 60s
updateTime: '2018-06-26T12:28:25Z'
versionId: '1'
```   

### Test the function

After you deploy the function and know that it's active, test that the function writes a message to the cloud log after detecting a working

Enter this command to create a message test of the function.

```bash
gcloud beta functions call helloWorld --data '{"message":"Hello World!"}'

executionId: 218d83k6mdo3
```

The cloud tool returns the execution ID for the function, which means a message has been written in the log.


### View logs

Check the logs to see your messages in the log history.
```bash
gcloud beta functions logs read helloWorld


LEVEL  NAME        EXECUTION_ID  TIME_UTC                 LOG
D      helloWorld  218d83k6mdo3  2018-06-26 12:30:12.147  Function execution started
I      helloWorld  218d83k6mdo3  2018-06-26 12:30:12.196  My Cloud Function: Hello World!
D      helloWorld  218d83k6mdo3  2018-06-26 12:30:12.210  Function execution took 64 ms, finished with status: 'ok'
```

