package org.sanelib.eboss.core;

import java.beans.Introspector;
import java.io.Serializable;

import org.junit.After;
import org.junit.runner.RunWith;
import org.sanelib.eboss.core.commands.ICommand;
import org.sanelib.eboss.core.dao.UnitOfWork;
import org.sanelib.eboss.core.domain.entity.BaseEntity;
import org.sanelib.eboss.core.processors.IProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreMain.class)
public class IntegrationTestBase {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private UnitOfWork unitOfWork;

	@After
	public void tearDown() throws Exception {
		this.unitOfWork.rollback();
	}

	protected <T> T processCommand(ICommand command) {
		unitOfWork.begin();

		T response = null;
		try {
			String processorName = Introspector.decapitalize(command.getClass().getSimpleName() + "Processor");
			IProcessor processor = (IProcessor) context.getBean(processorName);
			response = (T) processor.Process(command);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}

		unitOfWork.flush();
		unitOfWork.clear();

		return response;
	}

	public <T> T load(Class clas, Serializable id) {
		return (T) this.unitOfWork.getCurrentSession().load(clas, id);
	}

	public void persist(BaseEntity entity) {
		this.unitOfWork.getCurrentSession().save(entity);
	}
}
