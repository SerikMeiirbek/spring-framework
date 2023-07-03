package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.User;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ContextConfiguration(classes = {TaskServiceImpl.class})
@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;


    @Test
    void getByProjectCode_test(){

        //Given
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        //When
        ProjectDTO projectDTO1 = projectService.getByProjectCode(anyString());

        //Then
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO1);

    }

    @Test
    void getByProjectCode_execution_test(){

        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));

        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode(anyString());


        assertEquals(exception.getMessage(),"Project Not Found");

    }


    @Test
    void save_test(){

        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

//        Project project = projectMapper.convertToEntity(dto);
//        projectRepository.save(project);

        projectService.save(projectDTO);

        verify(projectRepository).save(project);
        verify(projectMapper).convertToEntity(any(ProjectDTO.class));
    }

    @Test
    void should_list_all_projects(){

        List<Project> projectList = new ArrayList<>();

        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findAll()).thenReturn(projectList);

        projectRepository.findAll();
        List<ProjectDTO> projectDTOList = projectList.stream().map(projectMapper::convertToDto).collect(Collectors.toList());

        verify(projectRepository).findAll();
        assertNotNull(projectDTOList);
    }

    @Test
    void should_update_project(){

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectStatus(Status.COMPLETE);
        projectDTO.setProjectDetail("ABC123");

        Project convertedProjected = new Project();

        Project project = new Project();
        project.setId(12L);
        projectDTO.setProjectStatus(Status.IN_PROGRESS);
        projectDTO.setProjectDetail("ABC");

        when(projectRepository.findByProjectCode(projectDTO.getProjectCode())).thenReturn(project);

        when(projectMapper.convertToEntity(projectDTO)).thenReturn(convertedProjected);

        when(projectRepository.save(convertedProjected)).thenReturn(convertedProjected);


        projectRepository.findByProjectCode(projectDTO.getProjectCode());
        Project convertedProject = projectMapper.convertToEntity(projectDTO);

        convertedProject.setId(project.getId());

        assertEquals(12L, convertedProject.getId());

        convertedProject = projectRepository.save(convertedProject);

        verify(projectRepository).save(convertedProject);

        assertNotNull(convertedProject);

    }

    @Test
    void should_delete_project(){

        Project project = new Project();
        project.setId(12L);
        project.setProjectCode("Spring");

        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectRepository.findByProjectCode("code");

        project.setIsDeleted(true);
        project.setProjectCode(project.getProjectCode() + "-" + project.getId());

        projectRepository.save(project);

        assertTrue(project.getIsDeleted());

        assertEquals("Spring-12", project.getProjectCode());

    }


}