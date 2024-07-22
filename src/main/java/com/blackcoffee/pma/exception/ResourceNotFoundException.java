package com.blackcoffee.pma.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String entityName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String entityName, String fieldName, Long fieldValue) {
        super(String.format("%s is not found with %s %d",entityName, fieldName,fieldValue));
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }

    public String getEntityName() {
        return entityName;
    }
}
