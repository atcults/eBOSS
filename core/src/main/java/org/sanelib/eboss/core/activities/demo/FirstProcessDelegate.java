package org.sanelib.eboss.core.activities.demo;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class FirstProcessDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("First Process is called");
		execution.setVariable("firstParam", "firstParamVal");
	}
}
