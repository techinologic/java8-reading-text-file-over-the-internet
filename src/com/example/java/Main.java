package com.example.java;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main {

   private static final String FLOWERS_FEED =
           "http://services.hanselandpetal.com/feeds/flowers.xml";

    public static void main(String[] args) throws IOException {

        InputStream stream = null;
        BufferedInputStream buff = null;
        try {
            URL url = new URL(FLOWERS_FEED);
            stream = url.openStream();

            buff = new BufferedInputStream(stream);

            StringBuilder sb = new StringBuilder();

            while (true) {
                int data = buff.read();

                if (data == -1) {
                    break;

                } else {
                    sb.append((char)data);
                }
            }

            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
            buff.close();
        }
    }
}
