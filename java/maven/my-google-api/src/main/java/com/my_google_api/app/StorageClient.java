//package com.my_google_api.app;
//
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//
//import java.nio.charset.StandardCharsets;
//
//public class StorageClient {
//    public static void main(String[] args) throws Exception {
//        // Instantiates a client
//        Storage storage = StorageOptions.getDefaultInstance().getService();
//
//        byte[] content = storage.readAllBytes("rls-jln-zam-dev-byam", "euc_mp.j_rsv/state.txt");
//        String ss = new String(content, StandardCharsets.UTF_8);
//        System.out.printf(ss);
//    }
//}
