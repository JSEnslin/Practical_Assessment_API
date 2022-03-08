package com.TechA.TA.Employer.Model;

import com.TechA.TA.Users.model.Users;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;



@Data
    @Entity
    @Table(name = "employer")
@NoArgsConstructor
public class Employer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long employer_Id;

        @Column(name = "company_name", nullable = false)
        private String companyName;

        @Column(name = "user_name", nullable = false)
        private String userName;


    }



