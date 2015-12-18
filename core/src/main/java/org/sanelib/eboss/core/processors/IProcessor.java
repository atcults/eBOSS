package org.sanelib.eboss.core.processors;

import org.sanelib.eboss.core.commands.ICommand;
import org.sanelib.eboss.core.exceptions.AppException;

public interface IProcessor<T extends ICommand, R> {

	R Process(T command) throws AppException;
}
