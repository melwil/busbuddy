/*
 * Copyright 2011 BusBuddy (Roy Sindre Norangshol)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package no.norrs.busbuddy.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

/**
 * @author Roy Sindre Norangshol
 */
public class AtbControllerFactory {

    public AtbController createRealtimeWebHackController() {
        Properties properties = loadProperties("atbweb");
        return new AtbWebController(properties.getProperty("endpoint"), properties.getProperty("payload"));
    }

    public AtbController createRealtimeSoapController() {

        Properties properties = loadProperties("atbapikey");
        System.out.println("properties: "+properties.toString());
        try {
            return new AtbSoapController(properties.getProperty("username"), properties.getProperty("password"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties loadProperties(String firstNameOnFileName) {
        Properties properties = new Properties();
        try {
            InputStream stream = getClass().getResourceAsStream(String.format("/%s.properties",firstNameOnFileName));
            if (stream != null) {
                try {
                    properties.load(stream);
                } finally {
                    stream.close();
                }
            }
            File file = new File(String.format("/etc/busbuddy/%s.properties", firstNameOnFileName));
            if (file.exists()) {
                stream = new FileInputStream(file);
                try {
                    properties.load(stream);
                } finally {
                    stream.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}

