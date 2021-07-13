package com.adasoraninda.transactional.mapper;

import com.adasoraninda.transactional.model.StudentEntity;
import com.adasoraninda.transactional.model.StudentRequest;
import com.adasoraninda.transactional.model.StudentResponse;

public class StudentMapper {

    public static StudentResponse mapToResponse(StudentEntity studentEntity) {
        return new StudentResponse(
                studentEntity.getId(),
                studentEntity.getFirstName(),
                studentEntity.getLastName(),
                studentEntity.getEmail(),
                studentEntity.getAddress()
//                studentEntity.getDob(),
//                studentEntity.getGender()
        );
    }

    public static StudentEntity mapToEntity(StudentRequest studentRequest) {
        return new StudentEntity(
                studentRequest.getId(),
                studentRequest.getFirstName(),
                studentRequest.getLastName(),
                studentRequest.getEmail(),
                studentRequest.getAddress()
//                studentRequest.getDob(),
//                studentRequest.getGender()
        );
    }

}
