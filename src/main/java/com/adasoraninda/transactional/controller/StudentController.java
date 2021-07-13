package com.adasoraninda.transactional.controller;

import com.adasoraninda.transactional.mapper.StudentMapper;
import com.adasoraninda.transactional.model.BaseResponse;
import com.adasoraninda.transactional.model.StudentEntity;
import com.adasoraninda.transactional.model.StudentResponse;
import com.adasoraninda.transactional.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public BaseResponse<List<StudentResponse>> getAllStudents() {
        return HandleResponse.saveHandle(() -> service.getAllStudents()
                .stream()
                .map(StudentMapper::mapToResponse)
                .collect(Collectors.toList())
        );
    }

    @PostMapping
    public BaseResponse<StudentResponse> saveStudent(
            @RequestBody StudentEntity student
    ) {
        return HandleResponse.saveHandle(() -> StudentMapper
                .mapToResponse(service.saveStudent(student))
        );
    }

    @GetMapping(path = "/{id}")
    public BaseResponse<StudentResponse> getStudentById(
            @PathVariable(name = "id") Long id
    ) {
        return HandleResponse.saveHandle(() -> StudentMapper
                .mapToResponse(service.getStudentById(id))
        );
    }

    @PutMapping(path = "/{id}")
    public BaseResponse<StudentResponse> updateStudent(
            @PathVariable(name = "id") Long id,
            @RequestBody StudentEntity student
    ) {
        return HandleResponse.saveHandle(() -> StudentMapper
                .mapToResponse(service.updateStudent(id, student))
        );
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(
            @PathVariable(name = "id") Long id
    ) {
        service.deleteStudent(id);
    }

    @DeleteMapping
    public void deleteAllStudent() {
        service.deleteAllStudent();
    }

}
