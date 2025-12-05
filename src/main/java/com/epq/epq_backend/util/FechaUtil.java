package com.epq.epq_backend.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate convertir(String fecha) {
        return LocalDate.parse(fecha, FORMATTER);
    }

    public static boolean esFechaValida(String fecha) {
        try {
            LocalDate.parse(fecha, FORMATTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}