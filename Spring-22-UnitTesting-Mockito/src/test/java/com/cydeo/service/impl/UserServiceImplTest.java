package com.cydeo.service.impl;

import com.cydeo.repository.UserRepository;
import com.cydeo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUsername_test(){

        userService.deleteByUserName("mikesmith@cydeo.com");
//        userService.listAllUsers();

//        verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository).findAll();
//        verify(userRepository, times(2)).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, atLeastOnce()).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, atLeast(5)).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, atMostOnce()).deleteByUserName("mikesmith@cydeo.com");
//        verify(userRepository, atMost(5)).deleteByUserName("mikesmith@cydeo.com");
//
        InOrder inOrder = inOrder(userRepository);
//        inOrder.verify(userRepository).findAll();
        inOrder.verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
        inOrder.verify(userRepository).findAll();
    }

}
