package com.adasoraninda.transactional.service;

import com.adasoraninda.transactional.exception.StudentAlreadyExistException;
import com.adasoraninda.transactional.exception.StudentEmptyException;
import com.adasoraninda.transactional.exception.StudentNotFoundException;
import com.adasoraninda.transactional.model.StudentEntity;
import com.adasoraninda.transactional.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> students = repository.findAll();

        if (students.isEmpty()) {
            throw new StudentEmptyException("Students is empty");
        }
        return students;
    }

    @Override
    @Transactional
    public StudentEntity saveStudent(StudentEntity student) {
        return repository.save(student);
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        boolean isStudentExists = repository.existsById(id);

        if (!isStudentExists) {
            throw new StudentNotFoundException("Student with id " + id + " is not found.");
        }

        return repository.getById(id);
    }

    @Override
    @Transactional
    public StudentEntity updateStudent(Long id, StudentEntity newStudent) {
        StudentEntity student = repository
                .findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " is not found."));

        if (newStudent.getEmail() != null) {
            long studentCount = repository.findAll()
                    .stream()
                    .filter(s -> s.getEmail().equals(newStudent.getEmail()))
                    .count();

            if (studentCount > 0) {
                throw new StudentAlreadyExistException("Student with email " + newStudent.getEmail() + " is already exists");
            }

        }

        student.copy(newStudent);

        return repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllStudent() {
        repository.deleteAll();
    }

}
