package com.vcakitchen.response;

import java.io.Serializable;
import java.util.Objects;

public class CustomerResponse implements Serializable {

    private Integer id ;

    public CustomerResponse(){

    }
    public CustomerResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerResponse)) return false;
        CustomerResponse that = (CustomerResponse) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
