package com.proj.planejador.pipe;

public class RiscoPipe {

    public static String transform(String item){
        switch (item){
            case "ALTO":
                return "Alto";
            case "MEDIO":
                return "Médio";
            case "BAIXO":
                return "Baixo";
            default:
                return "";
        }
    }
}