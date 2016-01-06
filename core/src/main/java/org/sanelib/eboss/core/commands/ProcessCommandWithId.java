package org.sanelib.eboss.core.commands;

public interface ProcessCommandWithId extends ProcessCommand {
    Long getId();
    void setId(Long id);
    Class getRootEntityClass();
}
