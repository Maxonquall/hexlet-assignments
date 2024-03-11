package exercise;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Validator {
    public static List<String> validate(Address address) {
        var result = new ArrayList<String>();
        Field[] fields = address.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                boolean isNotNull = field.isAnnotationPresent(NotNull.class);
                if (isNotNull && field.get(address) == null) {
                    result.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new LinkedHashMap<>();
        try {
            Field[] fields = address.getClass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
                List<String> invalid = new ArrayList<>();
                boolean isNotNull = field.isAnnotationPresent(NotNull.class);
                boolean isMinLength = field.isAnnotationPresent(MinLength.class);
                String fieldName = field.getName();
                if (isNotNull && field.get(address) == null) {
                    invalid.add("can not be null");
                }
                if (isMinLength
                        && field.get(address).toString().length() < field.getAnnotation(MinLength.class).minLength()) {
                    int minLength = field.getAnnotation(MinLength.class).minLength();
                    invalid.add("length less than " + minLength);
                }

                if (!invalid.isEmpty()) {
                    result.put(fieldName, invalid);
                }
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}


