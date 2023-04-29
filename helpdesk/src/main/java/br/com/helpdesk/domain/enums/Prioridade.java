package br.com.helpdesk.domain.enums;

public enum Prioridade {

    //PRIORIDADE

    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

    private Integer code;
    private String description;
    private Prioridade(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
    public Integer getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }

    public static Prioridade toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Prioridade x : Prioridade.values()) {
            if(cod.equals(x.getCode())) {
                return x;
            }

        }

        throw new IllegalArgumentException("Prioridade Inválida");

    }

}
