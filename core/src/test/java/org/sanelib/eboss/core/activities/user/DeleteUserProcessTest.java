package org.sanelib.eboss.core.activities.user;

import org.junit.Test;
import org.sanelib.eboss.EntityIntegrationTestBase;
import org.sanelib.eboss.core.activities.ActivitiProcessConstants;
import org.sanelib.eboss.core.commands.user.DeleteUser;
import org.sanelib.eboss.core.domain.entity.User;

import static org.junit.Assert.assertNull;

public class DeleteUserProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testDeleteUserSuccess() throws Throwable {

        User user = new User();

        user.setUsername("firstUser");
        user.setPassword("password");

        persist(user);

        DeleteUser deleteUser = new DeleteUser();
        deleteUser.setId(user.getId());

        String result = execute(deleteUser, ActivitiProcessConstants.Admin.DELETE_USER);
        assertNull(result);

        User deletedUser = fetch(User.class,user.getId());
        assertNull(deletedUser);
    }
}
