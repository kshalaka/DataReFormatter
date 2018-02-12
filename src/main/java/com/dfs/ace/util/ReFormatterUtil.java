package com.dfs.ace.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ReFormatterUtil {

    public static Properties loadProperties()  {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return appProps;

    }
}
