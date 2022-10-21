package in.hmr.repo.repohmrin.controller;

import in.hmr.repo.repohmrin.author.Author;
import in.hmr.repo.repohmrin.author.AuthorRepository;
import in.hmr.repo.repohmrin.book.Book;
import in.hmr.repo.repohmrin.book.BookRepository;
import in.hmr.repo.repohmrin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Random;

@Controller
public class RegistrationController {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public RegistrationController() {
    }

    @GetMapping({"/"})
    public String index() {
        return "index";
    }

    @PostMapping({"/register"})
    public String userRegistration(@ModelAttribute User user, Model model) {
        Author author = new Author();
        Book book = new Book();
        Random random = new Random();
        String authorId = user.getTeacherName().toUpperCase().replace(" ", "") + String.format("%04d", random.nextInt(10000));
        author.setId(authorId);
        author.setName(user.getTeacherName());
        this.authorRepository.save(author);
        String bookId = user.getTeacherName().toUpperCase().replace(" ", "").substring(0, 2) + String.format("%04d", random.nextInt(10000));
        book.setId(bookId);
        book.setTitle(user.getTitle());
        book.setDescription(user.getDescription());
        book.setPublishedDate(LocalDate.now());
        book.setAuthorNames(user.getTeacherName());
        book.setAuthorID(authorId);
        book.setSemester(Integer.parseInt(user.getSemester()));
        this.bookRepository.save(book);
        model.addAttribute("teacherName", user.getTeacherName());
        model.addAttribute("title", user.getTitle());
        return "registration-complete";
    }
}
