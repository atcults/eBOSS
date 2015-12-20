package org.sanelib.eboss.core.activities.employee;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CheckEmployeeDuplicationDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Checking employee for duplication");
	}
}
