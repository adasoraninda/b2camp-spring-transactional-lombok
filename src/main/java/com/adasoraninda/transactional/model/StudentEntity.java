package com.adasoraninda.transactional.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @Column
    private String address;
//
//    @Column(name = "date_of_birth")
//    private LocalDate dob;
//
//    @Column
//    private Gender gender;

    public void copy(StudentEntity newStudent) {
        this.firstName = newStudent.getFirstName();
        this.lastName = newStudent.getLastName();
        this.address = newStudent.getAddress();
//        this.dob = newStudent.getDob();
//        this.gender = newStudent.getGender();
    }

}
