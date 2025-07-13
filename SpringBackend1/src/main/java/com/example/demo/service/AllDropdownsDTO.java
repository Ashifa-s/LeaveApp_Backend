package com.example.demo.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.LeaveService;
import com.example.demo.dto.AllDropdowns;
import com.example.demo.repository.*;

@Service
public class AllDropdownsDTO {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SUBLOBTEAMRepository SUBLOBTEAMRepository;

    @Autowired
    private ProjectSOWRepository ProjectRepository;

    @Autowired
    private LeaveStatusRepository LeavestatusRepository;

    public AllDropdowns getAllDropdowns() {
        AllDropdowns dto = new AllDropdowns();

        dto.setLeaveTypes(
            leaveTypeRepository.findAll().stream()
                .map(item -> item.getLeaveType()) 
                .collect(Collectors.toList())
        );

        dto.setBaseLocations(
            locationRepository.findAll().stream()
                .map(item -> item.getName()) 
                .collect(Collectors.toList())
        );

        dto.setSubTeams(
            SUBLOBTEAMRepository.findAll().stream()
                .map(item -> item.getName()) 
                .collect(Collectors.toList())
        );

        dto.setProjects(
            ProjectRepository.findAll().stream()
                .map(item -> item.getName()) 
                .collect(Collectors.toList())
        );

        dto.setStatus(
            LeavestatusRepository.findAll().stream()
                .map(item -> item.getName()) 
                .collect(Collectors.toList())
        );

        return dto;
    }
}
