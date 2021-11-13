package com.xma.springbootproduction.Utilities;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class AmazonEC2 {

    public static String retrieveInstanceId() throws IOException {
        String EC2Id = null;
        String inputLine;
        URL EC2MetaData = new URL("http://169.254.169.254/latest/meta-data/instance-id");
        URLConnection EC2MD = EC2MetaData.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(EC2MD.getInputStream()));
        while ((inputLine = in.readLine()) != null) {
            EC2Id = inputLine;
        }
        in.close();
        return EC2Id;
    }
}
