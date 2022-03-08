package com.TechA.TA.Applicant.model;


import com.TechA.TA.Users.model.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "applicants")
@NoArgsConstructor
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicant_Id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "CV_Ready",nullable = false)
    private Boolean status;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userName_Id;


}
