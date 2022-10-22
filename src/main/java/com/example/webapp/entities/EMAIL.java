package com.example.webapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "emails")
public class EMAIL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int email_id;
    private String email_from ;
    private String email_to;
    private String Subject;
    private String body;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private users users;

}
