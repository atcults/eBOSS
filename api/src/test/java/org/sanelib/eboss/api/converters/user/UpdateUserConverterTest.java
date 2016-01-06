package org.sanelib.eboss.api.converters.user;

import org.junit.Test;
import org.sanelib.eboss.api.dto.user.UserDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.user.UpdateUser;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class UpdateUserConverterTest {

    @Test
    public void testUpdateUserSuccessExecute() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("001");
        userDTO.setUsername("firstUsername");
        userDTO.setPassword("Password");

        ProcessError processError= new ProcessError();

        UpdateUserConverter updateUserConverter = new UpdateUserConverter();
        ProcessCommand processCommand = updateUserConverter.convert(userDTO , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + processCommand, processCommand instanceof UpdateUser);

        UpdateUser updateUser = (UpdateUser) processCommand;

        assertEquals("Username is not mapped " , userDTO.getUsername() ,updateUser.getUsername());
        assertEquals("Password is not mapped" , userDTO.getPassword() , updateUser.getPassword());
    }

}