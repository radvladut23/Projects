package dao;

import java.lang.reflect.Field;
import java.util.List;

public class TableGenerator {

    public static String generateTable(List<?> objects) {
        if (objects.isEmpty()) {
            return "";
        }

        Class<?> clazz = objects.get(0).getClass();
        StringBuilder tableBuilder = new StringBuilder();

        // Generate table header
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            tableBuilder.append(field.getName()).append("\t");
        }
        tableBuilder.append("\n");

        // Populate table with object values
        for (Object object : objects) {
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    tableBuilder.append(value).append("\t");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            tableBuilder.append("\n");
        }

        return tableBuilder.toString();
    }



}
