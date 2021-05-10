package com.capitole.ecommerce.unit.repositories.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String formatToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }
}