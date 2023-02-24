package org.iesvdm.examen4_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", length = 120)
    private String email;

    @Column(name = "username", length = 120)
    private String username;

    @Column(name = "password", length = 120)
    private String password;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date birth_date;

}
