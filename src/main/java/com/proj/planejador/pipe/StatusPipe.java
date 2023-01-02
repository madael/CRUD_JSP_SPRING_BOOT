package com.proj.planejador.pipe;

import com.proj.planejador.enums.StatusEnum;

public class StatusPipe {

    public static String transform(String item) {
        switch (item) {
            case "ANALISANDO":
                return "Em análise";
            case "ANALISE_REALIZADA":
                return "Análise realizada";
            case "ANALISE_APROVADA":
                return "Análise aprovada";
            case "INICIADO":
                return "Iniciado";
            case "PLANEJADO":
                return "Planejado";
            case "ANDAMENTO":
                return "Andamento";
            case "ENCERRADO":
                return "Encerrado";
            case "CANCELADO":
                return "Cancelado";
            default:
                return "";
        }
    }

    public static String mudar(String item) {
        switch (item) {
            case "ANALISANDO":
                return StatusEnum.ANALISE_REALIZADA.name();
            case "ANALISE_REALIZADA":
                return StatusEnum.ANALISE_APROVADA.name();
            case "ANALISE_APROVADA":
                return StatusEnum.INICIADO.name();
            case "INICIADO":
                return StatusEnum.PLANEJADO.name();
            case "PLANEJADO":
                return StatusEnum.ANDAMENTO.name();
            case "ANDAMENTO":
                return StatusEnum.ENCERRADO.name();
            case "ENCERRADO":
                return StatusEnum.CANCELADO.name();
            case "CANCELADO":
                return StatusEnum.CANCELADO.name();
            default:
                return "";
        }
    }

    public static boolean canDelete(String item) {
        switch (item) {
            case "INICIADO":
            case "ANDAMENTO":
            case "ENCERRADO":
                return false;
            default:
                return true;
        }
    }
}