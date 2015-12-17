package org.sanelib.eboss.core.processors.activities.demo;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.sanelib.eboss.core.IntegrationTestBase;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoProcessTest extends IntegrationTestBase {

	@Autowired
	RuntimeService runtimeService;

	@Autowired
	TaskService taskService;

	@Test
	public void testHelloWorldProcessTest() throws Exception {
		runtimeService.startProcessInstanceByKey("helloWorldProcess");
	}
}
