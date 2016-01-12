package org.sanelib.eboss.api.converters.user;

import com.google.common.base.Strings;
import org.sanelib.eboss.api.converters.DtoToCommandConverter;
import org.sanelib.eboss.api.dto.user.UserDTO;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.user.AddUser;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddUserConverter implements DtoToCommandConverter<UserDTO> {

    @Override
    public ProcessCommand convert(UserDTO dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddUser command = new AddUser();

        if(Strings.isNullOrEmpty(dto.getUsername())){
            processError.addError("common.field.required", "username", "domain.user.username");
        }
        else{
            command.setUsername(dto.getUsername());
        }

        if(Strings.isNullOrEmpty(dto.getPassword())){
            processError.addError("common.field.required", "password", "domain.user.password");
        }
        else{
            command.setPassword(dto.getPassword());
        }

        return command;
    }
}
