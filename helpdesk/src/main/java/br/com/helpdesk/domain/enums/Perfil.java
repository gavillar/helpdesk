package br.com.helpdesk.domain.enums;

public enum Perfil {

    //PERFIL

    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");

    private Integer code;
    private String description;
    private Perfil(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
    public Integer getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }

    public static Perfil toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }
        for(Perfil x : Perfil.values()) {
            if(cod.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil Inválido");
    }

}
