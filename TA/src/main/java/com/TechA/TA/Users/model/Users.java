package com.TechA.TA.Users.model;


import com.TechA.TA.Applicant.model.Applicant;
import com.TechA.TA.Employer.Model.Employer;
import com.TechA.TA.JobListing.Model.JobListings;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.Set;


@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userName_Id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "contact_no", nullable = false)
    private Integer contactNumber;




    }




