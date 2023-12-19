package io.aiven.spring.mysql.demo.service;

import io.aiven.spring.mysql.demo.dto.AuthorDto;
import io.aiven.spring.mysql.demo.entity.Author;
import io.aiven.spring.mysql.demo.mapper.AuthorMapper;
import io.aiven.spring.mysql.demo.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepo;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {

        Author author = AuthorMapper.mapToAuthor(authorDto);
        Author savedAuthor = authorRepo.save(author);
        return AuthorMapper.mapToAuthorDto(savedAuthor);
    }

    @Override
    public AuthorDto getAuthor(Integer id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("asda"));

        return AuthorMapper.mapToAuthorDto(author);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepo.findAll();
        List<AuthorDto> authorsDtos = new ArrayList<>();
        for(int i = 0; i < authors.size() ; ++i) {
            AuthorDto maptoDto = AuthorMapper.mapToAuthorDto(authors.get(i));
            authorsDtos.add(maptoDto);
        }
        return authorsDtos;
    }

    @Override
    public AuthorDto updateAuthor(Integer id, AuthorDto updatedAuthor) {

        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("author not found"));

        author.setName(updatedAuthor.getName());
        author.setEmail(updatedAuthor.getEmail());

        Author updatedAuthorObj = authorRepo.save(author);

        return AuthorMapper.mapToAuthorDto(updatedAuthorObj);

    }

    @Override
    public AuthorDto deleteAuthorById(Integer id) {
        Author authorById = authorRepo.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("no such author id"));

        authorRepo.deleteById(id);

        return AuthorMapper.mapToAuthorDto(authorById);
    }
}
