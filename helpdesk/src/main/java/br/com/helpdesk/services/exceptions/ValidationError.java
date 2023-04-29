package br.com.helpdesk.services.exceptions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private static final long serialVersionUID = 1L;

    private List<FieldMessege> errors = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(long timestamp, Integer status, String error, String messege, String path) {
        super(timestamp, status, error, messege, path);
    }

    public List<FieldMessege> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String messege) {
        this.errors.add(new FieldMessege(fieldName, messege));


    }
}
