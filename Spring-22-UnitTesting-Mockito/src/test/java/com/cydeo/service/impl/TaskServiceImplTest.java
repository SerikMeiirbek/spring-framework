package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.Role;
import com.cydeo.entity.Task;
import com.cydeo.entity.User;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {TaskServiceImpl.class})
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @MockBean
    private ProjectMapper projectMapper;

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, -5L})
    void findById_test(long id) {

        //Given
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDTO(task)).thenReturn(new TaskDTO());

        //When
        taskService.findById(id);

        //Then
        verify(taskRepository.findById(id));
        verify(taskMapper).convertToDTO(any(Task.class));

//        verify(taskRepository, never()).findById(-5L);

    }

    /**
     * Method under test: {@link TaskServiceImpl#findById(Long)}
     */
    @Test
    void testFindById() {
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(123L);
        role.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setInsertUserId(123L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setLastUpdateUserId(123L);

        User user = new User();
        user.setEnabled(true);
        user.setFirstName("Jane");
        user.setGender(Gender.MALE);
        user.setId(123L);
        user.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setInsertUserId(123L);
        user.setIsDeleted(true);
        user.setLastName("Doe");
        user.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setLastUpdateUserId(123L);
        user.setPassWord("Pass Word");
        user.setPhone("4105551212");
        user.setRole(role);
        user.setUserName("janedoe");

        Role role1 = new Role();
        role1.setDescription("The characteristics of someone or something");
        role1.setId(123L);
        role1.setInsertDateTime(null);
        role1.setInsertUserId(123L);
        role1.setIsDeleted(true);
        role1.setLastUpdateDateTime(null);
        role1.setLastUpdateUserId(123L);

        User user1 = new User();
        user1.setEnabled(true);
        user1.setFirstName("Jane");
        user1.setGender(Gender.MALE);
        user1.setId(123L);
        user1.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setInsertUserId(123L);
        user1.setIsDeleted(true);
        user1.setLastName("Doe");
        user1.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setLastUpdateUserId(123L);
        user1.setPassWord("Pass Word");
        user1.setPhone("4105551212");
        user1.setRole(role1);
        user1.setUserName("janedoe");

        Project project = new Project();
        project.setAssignedManager(user1);
        project.setEndDate(LocalDate.ofEpochDay(1L));
        project.setId(123L);
        project.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        project.setInsertUserId(123L);
        project.setIsDeleted(true);
        project.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        project.setLastUpdateUserId(123L);
        project.setProjectCode("Project Code");
        project.setProjectDetail("Project Detail");
        project.setProjectName("Project Name");
        project.setProjectStatus(Status.OPEN);
        project.setStartDate(LocalDate.ofEpochDay(1L));

        Task task = new Task();
        task.setAssignedDate(LocalDate.ofEpochDay(1L));
        task.setAssignedEmployee(user);
        task.setId(123L);
        task.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        task.setInsertUserId(123L);
        task.setIsDeleted(true);
        task.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        task.setLastUpdateUserId(123L);
        task.setProject(project);
        task.setTaskDetail("Task Detail");
        task.setTaskStatus(Status.OPEN);
        task.setTaskSubject("Hello from the Dreaming Spires");
        Optional<Task> ofResult = Optional.of(task);
        when(taskRepository.findById((Long) org.mockito.Mockito.any())).thenReturn(ofResult);
        TaskDTO taskDTO = new TaskDTO();
        when(taskMapper.convertToDTO((Task) org.mockito.Mockito.any())).thenReturn(taskDTO);
        assertSame(taskDTO, taskServiceImpl.findById(123L));
        verify(taskRepository).findById((Long) org.mockito.Mockito.any());
        verify(taskMapper).convertToDTO((Task) org.mockito.Mockito.any());
    }

    @Test
    void findById_bdd_test() {

        //Given
        Task task = new Task();
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDTO(task)).willReturn(new TaskDTO());

        //When
        taskService.findById(anyLong());

        //Then
        then(taskRepository).should().findById(anyLong());
        then(taskRepository).should(never()).findById(-5L);

    }


}