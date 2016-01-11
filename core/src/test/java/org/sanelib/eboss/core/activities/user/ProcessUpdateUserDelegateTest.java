package org.sanelib.eboss.core.activities.user;

import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.eboss.core.commands.user.UpdateUser;
import org.sanelib.eboss.core.dao.UserRepository;
import org.sanelib.eboss.core.domain.entity.User;

public class ProcessUpdateUserDelegateTest {

    UserRepository userRepositoryMock;

    ProcessUpdateUserDelegate processUpdateUserDelegate;

    @Before
    public void setUp(){
        userRepositoryMock = Mockito.mock(UserRepository.class);
        processUpdateUserDelegate = new ProcessUpdateUserDelegate();
        processUpdateUserDelegate.userRepository = userRepositoryMock;
    }

    @Test
    public void testUpdateUserSuccessExecute() throws Exception {

        Mockito.doNothing().when(userRepositoryMock).save(Mockito.isA(User.class));

        UpdateUser updateUser = new UpdateUser();

        updateUser.setUsername("firstName");
        updateUser.setPassword("password");

        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(updateUser);

      }

}
