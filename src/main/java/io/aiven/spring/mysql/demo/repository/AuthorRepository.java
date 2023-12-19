package io.aiven.spring.mysql.demo.repository;

import io.aiven.spring.mysql.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
