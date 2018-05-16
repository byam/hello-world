package com.my_google_api.app;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String TEST_FILENAME = "json-test.txt";

    public static void main( String[] args ) throws IOException, GeneralSecurityException {
        System.out.println( "Start upload to GCS" );

        String bucketName = "rls-jln-zam-byam";

        System.out.println( "Finish upload to GCS" );

        System.out.println(StorageSample.readFile("json-test.txt", bucketName));

    }
}
