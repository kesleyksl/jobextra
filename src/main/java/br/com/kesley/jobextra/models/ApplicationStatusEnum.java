package br.com.kesley.jobextra.models;

public enum ApplicationStatusEnum {
    ANALYZING("Analisando"), SELECTED("Selecionado"), NOT_SELECTED("Não Selecionado");

    private final String description;

    private ApplicationStatusEnum(String description){
        this.description = description;
    }

    public String getDescriptio(){
        return this.description;
    }
}
