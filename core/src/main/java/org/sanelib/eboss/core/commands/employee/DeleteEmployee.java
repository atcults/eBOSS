package org.sanelib.eboss.core.commands.employee;

import org.sanelib.eboss.core.commands.ProcessCommandWithId;
import org.sanelib.eboss.core.domain.entity.Employee;

public class DeleteEmployee implements ProcessCommandWithId {
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }

    @Override
    public Class getRootEntityClass() {
        return Employee.class;
    }

}
