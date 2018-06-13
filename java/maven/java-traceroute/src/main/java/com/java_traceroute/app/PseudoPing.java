package com.java_traceroute.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PseudoPing{

    private static void runSystemCommand(String command) {

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s;
            // reading output stream of the command
            while ((s = inputStream.readLine()) != null) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String ip = "google.com";
        runSystemCommand("ping " + ip);
    }
}
