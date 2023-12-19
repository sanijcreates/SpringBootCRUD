package io.aiven.spring.mysql.demo.controller;

import io.aiven.spring.mysql.demo.dto.AuthorDto;
import io.aiven.spring.mysql.demo.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    //create author REST API
    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto savedAuthor = authorService.createAuthor(authorDto);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    //get author by id REST API
    @GetMapping("{id}")
    //since param name != id, we have to put pathVariable.
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") Integer authorId) {
        AuthorDto savedAuthor = authorService.getAuthor(authorId);
        return ResponseEntity.ok(savedAuthor);
    }

    //get all authors REST API
    @GetMapping("/all")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<AuthorDto> authorDtos = authorService.getAllAuthors();
        return ResponseEntity.ok(authorDtos);
    }

    //update author by ID REST API
    @PostMapping("{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable("id") Integer id, @RequestBody AuthorDto updatedAuthorDto) {
        AuthorDto updatedAuthorDtoObj = authorService.updateAuthor(id, updatedAuthorDto);
        return ResponseEntity.ok(updatedAuthorDtoObj);
    }

    //delete author by id REST API
    @DeleteMapping("{id}")
    public ResponseEntity<AuthorDto> deleteAuthorbyId(@PathVariable("id") Integer id) {
        AuthorDto deletedAuthor = authorService.deleteAuthorById(id);

        return ResponseEntity.ok(deletedAuthor);
    }



}
