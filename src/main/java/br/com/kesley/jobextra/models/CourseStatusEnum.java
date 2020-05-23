package br.com.kesley.jobextra.models;

public enum CourseStatusEnum {
    INTERRUPTED("Interrompido"),
    IN_PROGRESS("Cursando"),
    FINISHED("Concluído");

    private final String description;
    private CourseStatusEnum(String description){
        this.description = description;
    }

    public String getDeString(){
        return description;
    }
    
}