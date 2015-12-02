package org.sanelib.eboss.core.processors;

import org.junit.Before;
import org.junit.Test;
import org.sanelib.eboss.core.IntegrationTestBase;
import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.domain.entity.Employee;

import static org.junit.Assert.assertNotNull;

public class AddEmployeeProcessorTest extends IntegrationTestBase {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void add() throws Exception {
		System.out.println("Hello");
		AddEmployee command = new AddEmployee();
		command.setEmployeeId(22);
		command.setFirstName("firstname");
		command.setLastName("lastname");
		command.setGender("F");
		command.setDateOfBirth("12/13/2013 10:10:10.0");
		command.setDateOfJoining("02/26/2013 10:10:10.0");
		processCommand(command);
		Employee e = load(Employee.class, 2L);
		assertNotNull(e);
	}

}
