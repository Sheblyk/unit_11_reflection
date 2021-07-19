package ua.com.reflection.init;

import ua.com.reflection.annotation.PropertyKey;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Properties;

public class InitAppProperties {
    private final static String PROP_FILE = "src/main/resources/app.properties";

    public void init(Object toInit) {
        Class<?> classToInit = toInit.getClass();
        Field[] fields = classToInit.getFields();
        Properties prop = loadFromFile();
        for (Field f : fields) {
            if (f.isAnnotationPresent(PropertyKey.class)) {
                String propKeyValue = f.getAnnotation(PropertyKey.class).value();
                String valueToInsert = prop.getProperty(propKeyValue);
                try {
                    convertStringTo(toInit, f, valueToInsert);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void convertStringTo(Object toInit, Field field, String toInsert) throws IllegalAccessException {
        Class<?> type = field.getType();
        if (type.equals(Integer.class) || type == int.class) {
            field.set(toInit, Integer.parseInt(toInsert));
        } else if (type.equals(Long.class) || type == long.class) {
            field.set(toInit, Long.parseLong(toInsert));
        } else if (type.equals(Boolean.class) || type == boolean.class) {
            field.set(toInit, Boolean.parseBoolean(toInsert));
        } else if (type.equals(Byte.class) || type == byte.class) {
            field.set(toInit, Byte.parseByte(toInsert));
        } else if (type.equals(Short.class) || type == short.class) {
            field.set(toInit, Short.parseShort(toInsert));
        } else if (type.equals(Double.class) || type == double.class) {
            field.set(toInit, Double.parseDouble(toInsert));
        } else if (type.equals(Float.class) || type == float.class) {
            field.set(toInit, Float.parseFloat(toInsert));
        } else if (type.equals(String.class)) {
            field.set(toInit, toInsert);
        } else if (type.equals(Character.class) || type == char.class) {
            field.set(toInit, toInsert.charAt(0));
        } else if (type.isEnum()) {
            Object[] constants = type.getEnumConstants();
            for (Object constant : constants) {
                if (constant.toString().equalsIgnoreCase(toInsert)) {
                    field.set(toInit, constant);
                }
            }
        }
    }

    private Properties loadFromFile() {
        Properties properties = new Properties();
        try (InputStream prop = new FileInputStream(PROP_FILE)) {
            properties.load(prop);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}


