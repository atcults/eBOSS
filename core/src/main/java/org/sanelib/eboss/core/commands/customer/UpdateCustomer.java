package org.sanelib.eboss.core.commands.customer;

import org.sanelib.eboss.core.commands.ProcessCommandWithId;
import org.sanelib.eboss.core.domain.entity.Customer;

public class UpdateCustomer extends AddCustomer implements ProcessCommandWithId {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Class getRootEntityClass() {
        return Customer.class;
    }

    @Override
    public String toString() {
        return "UpdateCustomer{" +
                "id=" + id +
                '}';
    }
}
