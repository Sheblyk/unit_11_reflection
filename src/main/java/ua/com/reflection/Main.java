package ua.com.reflection;

import ua.com.reflection.entity.AppProperties;
import ua.com.reflection.init.GetProperties;
import ua.com.reflection.init.InitAppProperties;

public class Main {
    public static void main(String[] args) {
        GetProperties getProperties = new GetProperties();
        AppProperties app = new AppProperties();
        InitAppProperties initAppProperties = new InitAppProperties();
        initAppProperties.init(app, getProperties.loadFromFile());
        System.out.println(app);
    }
}
