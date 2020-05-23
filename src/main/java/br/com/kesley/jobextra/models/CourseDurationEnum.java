package br.com.kesley.jobextra.models;



public enum CourseDurationEnum  {
    
    /**
     *
     */

    SHORT("Curta (até 40 horas"),
    AVERAGE("Media (acima de 40 horas, até 360 horas"),
    LONG("Longa (acima 360 horas");

    private String description;
    private CourseDurationEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}