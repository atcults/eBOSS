package org.sanelib.eboss.core;

import org.junit.After;
import org.junit.runner.RunWith;
import org.sanelib.eboss.common.utils.Clock;
import org.sanelib.eboss.common.utils.CustomClock;
import org.sanelib.eboss.common.utils.DateHelper;
import org.sanelib.eboss.core.dao.UnitOfWork;
import org.sanelib.eboss.core.domain.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Date;

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

    @Autowired
    private Clock clock;

    protected void stubCurrentDate(int year, int month, int day) {
        ((CustomClock) clock).set(DateHelper.constructDate(year, month, day));
    }

    protected void stubCurrentDate(Date date) {
        ((CustomClock) clock).set(date);
    }

	public <T> T load(Class clas, Serializable id) {
		return (T) this.unitOfWork.getCurrentSession().load(clas, id);
	}

	public void persist(BaseEntity entity) {
		this.unitOfWork.getCurrentSession().save(entity);
	}
}
