package utils;

import com.google.gson.Gson;
import models.Credentials;

import java.io.FileReader;

public class JsonDataReader {

    public static <T> T readJsonFromResources(String fileName, Class<T> clazz) {
        try {
            String path = "src/test/resources/testdata/" + fileName;
            FileReader reader = new FileReader(path);
            return new Gson().fromJson(reader, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}