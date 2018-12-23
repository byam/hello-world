package com.my_google_api.app;

import com.google.cloud.bigquery.*;

import java.util.UUID;

public class BigQueryClient {
    public static void main(String[] args) throws InterruptedException {


        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                        "SELECT category_id, description FROM `PROJECT.bya_work.store`;")
                        .setUseLegacySql(false)
                        .build();

        // Create a job ID so that we can safely retry.
        JobId jobId = JobId.of(UUID.randomUUID().toString());
        Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

        // Wait for the query to complete.
        queryJob = queryJob.waitFor();

        // Check for errors
        if (queryJob == null) {
            throw new RuntimeException("Job no longer exists");
        } else if (queryJob.getStatus().getError() != null) {
            // You can also look at queryJob.getStatus().getExecutionErrors() for all
            // errors, not just the latest one.
            throw new RuntimeException(queryJob.getStatus().getError().toString());
        }

        // Get the results.
        QueryResponse response = bigquery.getQueryResults(jobId);
        TableResult result = queryJob.getQueryResults();

        // Print all pages of the results.
        for (FieldValueList row : result.iterateAll()) {

            String keyInstance = row.get(0).getStringValue();
            String valueInstance = row.get(1).getStringValue();

            System.out.println("key: " + keyInstance + ", value: " + valueInstance);
        }
    }
}
