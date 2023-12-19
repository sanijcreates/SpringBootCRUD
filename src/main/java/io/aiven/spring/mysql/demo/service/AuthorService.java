package io.aiven.spring.mysql.demo.service;

import io.aiven.spring.mysql.demo.dto.AuthorDto;
import io.aiven.spring.mysql.demo.entity.Author;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto getAuthor(Integer id);
    List<AuthorDto> getAllAuthors();
    AuthorDto updateAuthor(Integer id, AuthorDto updatedAuthor);
    AuthorDto deleteAuthorById(Integer id);
}
