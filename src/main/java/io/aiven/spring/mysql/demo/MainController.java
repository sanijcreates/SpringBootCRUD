//package io.aiven.spring.mysql.demo;
//
//import io.aiven.spring.mysql.demo.entity.Author;
//import io.aiven.spring.mysql.demo.repository.AuthorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Iterator;
//
//@RestController
//
//@RequestMapping(path = "/demo")
//public class MainController {
//
//    @Autowired
//    private AuthorRepository authorRepository;
//
//    @PostMapping(path = "/add")
//    public @ResponseBody
//    Author addNewUser(@RequestParam String name) {
//        Author springUser = new Author();
//        springUser.setName(name);
//        authorRepository.save(springUser);
//        return springUser;
//    }
//
//    @PostMapping(path = "/delete")
//    public @ResponseBody
//    Author deleteUser(@RequestParam Integer id) {
//        Iterable<Author> getUsers = getAllAuthors();
//        Iterator<Author> iter = getUsers.iterator();
//
//        while(iter.hasNext()) {
//            Author user = iter.next();
////            System.out.println("next is: " + user.getId());
//
//            if (user.getId().equals(id)) {
//                authorRepository.delete(user);
//                return user;
//            }
//        }
//        return null;
//    }
//
//    @GetMapping(path = "/all")
//    public @ResponseBody Iterable<Author> getAllAuthors() {
//        return authorRepository.findAll();
//    }
//
//}
