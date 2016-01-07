package org.sanelib.eboss.core.activities.user;


import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.core.commands.user.AddUser;
import org.sanelib.eboss.core.dao.UserRepository;
import org.sanelib.eboss.core.domain.entity.User;

public class ProcessAddUserDelegateTest {

    UserRepository userRepositoryMock;

    ProcessAddUserDelegate processAddUserDelegate;

    @Before
    public void setUp(){
        userRepositoryMock = Mockito.mock(UserRepository.class);
        processAddUserDelegate = new ProcessAddUserDelegate();
        processAddUserDelegate.userRepository = userRepositoryMock;
    }

    @Test
    public void testAddUserSuccessExecute() throws Exception{

        Mockito.doNothing().when(userRepositoryMock).save(Mockito.isA(User.class));

        AddUser addUserCommand = new AddUser();
        addUserCommand.setUsername("firstuser");
        addUserCommand.setPassword("password");


        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(addUserCommand);


        processAddUserDelegate.execute(execution);

        Mockito.verify(execution).setVariable("result", 0L);
    }


}
