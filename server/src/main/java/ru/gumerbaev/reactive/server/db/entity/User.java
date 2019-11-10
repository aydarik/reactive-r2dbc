package ru.gumerbaev.reactive.server.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@NoArgsConstructor
@Table("users")
public class User {

    @Id
    @Column("id")
    Integer id;
    @Column("first_name")
    String firstName;
    @Column("last_name")
    String lastName;
    @Column("email")
    String email;
    @Column("created_on")
    Date createdOn;
    @Column("last_login")
    Date lastLogin;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
