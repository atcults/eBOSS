package org.sanelib.eboss.api.services;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.sanelib.eboss.api.dto.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class ApiServiceBase {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    public void execute(BaseDTO dto, String processKey) throws Exception {
        Map<String, Object> variables = new HashMap<>();
        variables.put("dto", dto);
        runtimeService.startProcessInstanceByKey(processKey, variables);
    }

}
