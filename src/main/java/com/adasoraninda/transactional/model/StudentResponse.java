package com.adasoraninda.transactional.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
//    private LocalDate dob;
//    private Gender gender;

}
