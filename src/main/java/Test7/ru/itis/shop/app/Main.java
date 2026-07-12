package Test7.ru.itis.shop.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            InputStream input = Main.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(input);
            System.out.println(properties.getProperty("db.url"));
            System.out.println(properties.getProperty("db.user"));
            System.out.println(properties.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}