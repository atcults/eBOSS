package org.sanelib.eboss.api.services;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.sanelib.eboss.api.dto.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiServiceBase {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    public void execute(BaseDTO dto, String processKey) throws Exception {
        runtimeService.startProcessInstanceByKey(processKey);
    }

}
