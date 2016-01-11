package org.sanelib.eboss.core.commands.client;

import org.sanelib.eboss.core.commands.ProcessCommandWithId;
import org.sanelib.eboss.core.domain.entity.Client;

public class DeleteClient implements ProcessCommandWithId {
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
        return Client.class;
    }

}
