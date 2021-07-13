package com.adasoraninda.transactional.repository;

import com.adasoraninda.transactional.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
