package org.sanelib.eboss.core.commands.employee;

public class UpdateEmployee extends AddEmployee {
	private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateEmployee{" +
                "id=" + id +
                "} " + super.toString();
    }
}

