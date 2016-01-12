package org.sanelib.eboss.api.converters.user;

import org.sanelib.eboss.api.converters.ConverterHelper;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.user.UserDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.user.DeleteUser;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserConverter implements DtoToCommandConverter<UserDTO>{

        public ProcessCommand convert(UserDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {

            DeleteUser command=new DeleteUser();
            ConverterHelper.checkIdRequired(dto, command, processError);

            return command;
        }
}
