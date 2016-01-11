package org.sanelib.eboss.api.converters.user;


import org.junit.Test;
import org.sanelib.eboss.api.dto.user.UserDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.user.DeleteUser;
import org.sanelib.eboss.core.exceptions.ProcessError;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class DeleteUserConverterTest {

    @Test
    public void testDeleteUserSuccessExecute() throws Exception{

        UserDTO userDTO = new UserDTO();

        userDTO.setId("11");

        ProcessError processError= new ProcessError();

        DeleteUserConverter deleteUserConverter = new DeleteUserConverter();
        ProcessCommand command = deleteUserConverter.convert(userDTO , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteUser);

        DeleteUser deleteUser = (DeleteUser) command;

        assertEquals("Id is not mapped", userDTO.getId(), String.valueOf(deleteUser.getId()));
    }

}
