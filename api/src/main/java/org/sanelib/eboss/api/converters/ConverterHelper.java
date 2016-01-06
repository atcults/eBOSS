package org.sanelib.eboss.api.converters;

import com.google.common.base.Strings;
import org.sanelib.eboss.api.dto.BaseDTO;
import org.sanelib.eboss.common.utils.RegularExpressionHelper;
import org.sanelib.eboss.core.commands.ProcessCommandWithId;
import org.sanelib.eboss.core.exceptions.ProcessError;

public class ConverterHelper {

    public static void checkIdRequired(BaseDTO dto, ProcessCommandWithId command, ProcessError processError){
        if(Strings.isNullOrEmpty(dto.getId())){
            processError.addError("common.field.required", "id", "domain.common.id");
        }
        else if(!RegularExpressionHelper.checkIdFormat(dto.getId())){
            processError.addError("common.field.pattern", "id", "domain.common.id", RegularExpressionHelper.ID_FORMAT);
        } else {
            command.setId(Long.parseLong(dto.getId()));
        }
    }
}
