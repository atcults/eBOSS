package org.sanelib.eboss.api.converters.user;

import com.google.common.base.Strings;
import org.sanelib.eboss.api.dto.user.UserDTO;
import org.sanelib.eboss.common.utils.ReflectionHelper;
import org.sanelib.eboss.core.commands.ProcessCommand;
import org.sanelib.eboss.core.commands.user.AddUser;
import org.sanelib.eboss.core.commands.user.UpdateUser;
import org.sanelib.eboss.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserConverter extends AddUserConverter{

    @Override
    public ProcessCommand convert(UserDTO userDTO, ProcessError processError) throws NoSuchFieldException, IllegalAccessException{
        AddUser addUser = (AddUser) super.convert(userDTO , processError);

        UpdateUser updateUser = new UpdateUser();
        ReflectionHelper.copy(addUser ,updateUser);

        if(Strings.isNullOrEmpty(userDTO.getId())){
            processError.addError("common.field.required", "id" , "domain.user.id");
        }
        else{
            updateUser.setId(Long.valueOf(userDTO.getId()));
        }

        return updateUser;
    }
}
