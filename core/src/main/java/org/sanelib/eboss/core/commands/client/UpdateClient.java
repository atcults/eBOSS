package org.sanelib.eboss.core.commands.client;

import org.sanelib.eboss.core.commands.ProcessCommandWithId;
import org.sanelib.eboss.core.domain.entity.Client;

public class UpdateClient extends AddClient implements ProcessCommandWithId {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Class getRootEntityClass() {
        return Client.class;
    }

    @Override
    public String toString() {
        return "UpdateClient{" +
                "id=" + id +
                '}';
    }
}
