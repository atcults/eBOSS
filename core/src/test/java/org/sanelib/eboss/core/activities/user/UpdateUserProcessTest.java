package org.sanelib.eboss.core.activities.user;

import org.junit.Test;
import org.sanelib.eboss.BaseSpringJUnitTest;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.user.UpdateUser;
import org.sanelib.eboss.core.domain.entity.User;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class UpdateUserProcessTest extends BaseSpringJUnitTest {

    @Test
    public void testUpdateUserProcess() throws Throwable{

        User user = new User();

        user.setUsername("firstUser");
        user.setPassword("password");

        persist(user);

        UpdateUser updateUser = new UpdateUser();

        updateUser.setId(user.getId());
        updateUser.setUsername("Username");
        updateUser.setPassword("Passw0rd");

        String result = execute(updateUser , ActivitiProcessConstants.Admin.UPDATE_USER);

        assertNull(result);

        assertNotNull(updateUser);

        assertEquals("Username" , updateUser.getUsername());
        assertEquals("Passw0rd" , updateUser.getPassword());


    }

}

