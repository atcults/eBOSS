package org.sanelib.eboss.core.commands.user;

import org.sanelib.eboss.core.commands.ProcessCommandWithId;
import org.sanelib.eboss.core.domain.entity.User;

public class DeleteUser implements ProcessCommandWithId {
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }

    @Override
    public Class getRootEntityClass() {
        return User.class;
    }
}
