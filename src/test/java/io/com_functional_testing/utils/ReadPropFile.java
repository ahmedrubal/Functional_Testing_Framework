package io.com_functional_testing.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropFile {
     // This is my test.properties file path
     public static final String propFilePath=
            System.getProperty("user.dir")+"/config/test.properties";
     public static Properties properties=null;

     public static Properties propertyFile(String path){
          properties = new Properties();
         FileInputStream file;
         try{
             file = new FileInputStream(path);
             properties.load(file);
         }catch (FileNotFoundException e){
             e.printStackTrace();
         }catch (Exception e){
             e.getMessage();
         }
         return properties;
     }
    }


