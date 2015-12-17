package org.sanelib.eboss.core.activities.demo;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class SecondProcessDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Second Process is called");
		System.out.println("Variable from firstProcess :" + execution.getVariable("firstParam"));
	}
}
