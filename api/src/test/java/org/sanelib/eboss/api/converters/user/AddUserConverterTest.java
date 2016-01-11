package org.sanelib.eboss.api.converters.user;

import org.junit.Test;
import org.sanelib.eboss.api.dto.user.UserDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.user.AddUser;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddUserConverterTest {

    @Test
    public void testAddUserExecute() throws Exception {

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername("firstUser");
        userDTO.setPassword("password");

        ProcessError processError = new ProcessError();

        AddUserConverter addUserConverter = new AddUserConverter();
        ProcessCommand command = addUserConverter.convert(userDTO, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddUser);

        AddUser addUser = (AddUser) command;

        assertEquals("Username is not mapped" ,userDTO.getUsername() , addUser.getUsername());
        assertEquals("Password is not mapped" , userDTO.getPassword() ,addUser.getPassword());

    }


}
