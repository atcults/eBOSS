package org.sanelib.eboss.core.activities.user;

import org.junit.Test;
import org.sanelib.eboss.BaseSpringJUnitTest;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.user.AddUser;
import org.sanelib.eboss.core.domain.entity.User;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class AddUserProcessTest extends BaseSpringJUnitTest{

    @Test
    public void TestAddUserProcess() throws Throwable {

        AddUser addUser = new AddUser();

        addUser.setUsername("firstUser");
        addUser.setPassword("password");

        String result = execute(addUser, ActivitiProcessConstants.Admin.ADD_USER);

        assertNotNull(result);

        Long id = Long.parseLong(result);

        User user = fetch(User.class, id);

        assertNotNull(user);

        assertEquals(addUser.getUsername() ,user.getUsername());
        assertEquals(addUser.getPassword() , user.getPassword());
    }
}
