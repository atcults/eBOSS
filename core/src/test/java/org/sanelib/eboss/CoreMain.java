package org.sanelib.eboss;

import org.hibernate.SessionFactory;
import org.sanelib.eboss.common.utils.Clock;
import org.sanelib.eboss.common.utils.CustomClock;
import org.sanelib.eboss.core.dao.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoreMain  {

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    public Clock clock() {
        return new CustomClock();
    }

    @Bean
    public UnitOfWork unitOfWork(){
        return new UnitOfWork(this.sessionFactory);
    }

}
