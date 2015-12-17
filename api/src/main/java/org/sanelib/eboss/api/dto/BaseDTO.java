package org.sanelib.eboss.api.dto;

public class BaseDTO{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "id='" + id + '\'' +
                '}';
    }

    private String id;
}
