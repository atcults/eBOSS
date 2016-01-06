package org.sanelib.eboss.core.commands.employee;

import org.sanelib.eboss.core.commands.ProcessCommandWithId;
import org.sanelib.eboss.core.domain.entity.Employee;

public class UpdateEmployee extends AddEmployee implements ProcessCommandWithId {
	private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Class getRootEntityClass() {
        return Employee.class;
    }

    @Override
    public String toString() {
        return "UpdateEmployee{" +
                "id=" + id +
                "} " + super.toString();
    }
}

