package com.epq.epq_backend.util;

public class TextoUtil {
    private TextoUtil() {}

    public static boolean esNuloOVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static String limpiar(String texto) {
        return texto == null ? null : texto.trim();
    }

    public static String capitalizar(String texto) {
        if (esNuloOVacio(texto)) return texto;
        texto = texto.trim();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    public static String aMayusculas(String texto) {
        if (texto == null) return null;
        return texto.trim().toUpperCase();
    }

    public static String limpiarEspacios(String texto) {
        if (texto == null) return null;
        return texto.trim().replaceAll("\\s{2,}", " ");
    }
}