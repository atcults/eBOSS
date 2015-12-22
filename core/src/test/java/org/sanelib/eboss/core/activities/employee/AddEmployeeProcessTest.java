package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.sanelib.eboss.core.IntegrationTestBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.springframework.beans.factory.annotation.Autowired;

public class AddEmployeeProcessTest extends IntegrationTestBase {

	@Autowired
	RuntimeService runtimeService;

	@Autowired
	TaskService taskService;

	@Test
	public void testHelloWorldProcessTest() throws Exception {
		runtimeService.startProcessInstanceByKey(ActivitiProcessConstants.Admin.ADD_EMPLOYEE_PROCESS);
	}
}
