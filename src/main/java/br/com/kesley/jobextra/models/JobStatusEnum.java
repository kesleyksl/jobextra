package br.com.kesley.jobextra.models;

public enum JobStatusEnum {
    OPEN("Aberta"),
    CLOSE("Fechada"),
    INTERRUPTED("Interrompida");


    private final String description;
    
    private JobStatusEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
    
}