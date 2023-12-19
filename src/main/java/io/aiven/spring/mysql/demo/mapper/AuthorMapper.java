package io.aiven.spring.mysql.demo.mapper;

import io.aiven.spring.mysql.demo.dto.AuthorDto;
import io.aiven.spring.mysql.demo.entity.Author;

public class AuthorMapper {
    public static AuthorDto mapToAuthorDto(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getName(),
                author.getEmail()
        );
    }

    public static Author mapToAuthor(AuthorDto authorDto) {
        return new Author(
                authorDto.getId(),
                authorDto.getName(),
                authorDto.getEmail()
        );
    }
}
