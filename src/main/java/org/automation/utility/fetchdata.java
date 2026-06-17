package org.automation.utility;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class fetchdata {




        // Properties object to hold all key-value pairs from config file
        private static Properties properties = new Properties();

        // This block runs once when class is loaded
        static {
            try {
                // Path to your config.properties file
                FileInputStream file = new FileInputStream(
                        "src/test/resources/config.properties"
                );
                properties.load(file);
                file.close();
            } catch (IOException e) {
                System.out.println("config.properties file not found!");
                e.printStackTrace();
            }
        }

        // Returns the browser name (chrome / firefox)
        public static String getBrowser() {
            return properties.getProperty("browser");
        }

        // Returns the base URL of the website
        public static String getBaseUrl() {
            return properties.getProperty("baseurl");
        }

        // Returns the username
        public static String getUsername() {
            return properties.getProperty("username");
        }

        // Returns the password
        public static String getPassword() {
            return properties.getProperty("password");
        }
    }
