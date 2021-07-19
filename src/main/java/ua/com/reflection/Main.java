package ua.com.reflection;

import ua.com.reflection.entity.AppProperties;
import ua.com.reflection.init.InitAppProperties;

public class Main {
    public static void main(String[] args) {
        AppProperties app = new AppProperties();
        InitAppProperties initAppProperties = new InitAppProperties();
        initAppProperties.init(app);
        System.out.println(app);
    }
}
