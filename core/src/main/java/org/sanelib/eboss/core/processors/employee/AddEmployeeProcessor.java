package org.sanelib.eboss.core.processors.employee;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.sanelib.eboss.core.commands.employee.AddEmployee;
import org.sanelib.eboss.core.dao.EmployeeRepository;
import org.sanelib.eboss.core.domain.entity.Employee;
import org.sanelib.eboss.core.exceptions.DomainProcessException;
import org.sanelib.eboss.core.processors.IProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddEmployeeProcessor implements IProcessor<AddEmployee, Long> {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Long Process(AddEmployee command) throws DomainProcessException {

		Employee entity = new Employee();
		entity.setEmpId(Long.valueOf(command.getEmployeeId()));
		entity.setFirstName(command.getFirstName());
		entity.setLastName(command.getLastName());
		entity.setGender(command.getGender());

		Timestamp joinDate = null, birthDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy k:mm:ss.SSSS");

		try {
			Date birthDateParsed = dateFormat.parse(command.getDateOfBirth());
			Date joinDateParsed = dateFormat.parse(command.getDateOfJoining());

			birthDate = new Timestamp(birthDateParsed.getTime());
			joinDate = new Timestamp(joinDateParsed.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		entity.setDateOfBirth(birthDate);
		entity.setDateOfJoining(joinDate);

		employeeRepository.save(entity);
		return entity.getId();
	}
}
