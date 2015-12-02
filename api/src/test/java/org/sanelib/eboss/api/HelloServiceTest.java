package org.sanelib.eboss.api;

import org.junit.Test;
import org.sanelib.eboss.BaseWebMvcJUnitTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloServiceTest extends BaseWebMvcJUnitTest {

    @Test
    public void testMessageSuccess() throws Exception {
        ResultActions actions = mockMvc.perform(get("/"));
        MvcResult result = actions.andExpect(status().isOk()).andReturn();

        String returnMessage = result.getResponse().getContentAsString();

        System.out.println("Return Message :" + returnMessage);
    }
}
