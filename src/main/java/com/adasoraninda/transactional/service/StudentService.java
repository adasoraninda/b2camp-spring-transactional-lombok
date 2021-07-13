package com.adasoraninda.transactional.service;

import com.adasoraninda.transactional.model.StudentEntity;

import java.util.List;

public interface StudentService {

    List<StudentEntity> getAllStudents();

    StudentEntity saveStudent(StudentEntity student);

    StudentEntity getStudentById(Long id);

    StudentEntity updateStudent(Long id, StudentEntity newStudent);

    void deleteStudent(Long id);

    void deleteAllStudent();

}
