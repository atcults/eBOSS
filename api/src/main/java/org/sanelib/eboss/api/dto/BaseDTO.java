package org.sanelib.eboss.api.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;

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
