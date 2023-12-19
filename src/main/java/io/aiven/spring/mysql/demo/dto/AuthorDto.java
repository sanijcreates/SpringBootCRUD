package io.aiven.spring.mysql.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Integer id;
    private String name;
    private String email;

    public String getEmail(){
        return email;
    }

    public String getName(){
        return name;
    }

    public Integer getId() {
        return id;
    }
}
