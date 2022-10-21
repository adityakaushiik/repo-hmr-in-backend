package in.hmr.repo.repohmrin.services;

import in.hmr.repo.repohmrin.author.Author;
import in.hmr.repo.repohmrin.author.AuthorRepository;
import in.hmr.repo.repohmrin.book.Book;
import in.hmr.repo.repohmrin.book.BookRepository;
import in.hmr.repo.repohmrin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class DatabaseEntry {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    private final Random random = new Random();

    public void addEntry(User user){
        Author author = new Author();
        Book book = new Book();

        String authorId = teacherUniqueId(user.getTeacherName());
            author.setId(authorId);
            author.setName(user.getTeacherName());

        this.authorRepository.save(author);     //persist using repository

        String bookId = bookUniqueId(user.getTitle());
            book.setId(bookId);
            book.setTitle(user.getTitle());
            book.setDescription(user.getDescription());
            book.setPublishedDate(LocalDate.now());
            book.setAuthorNames(user.getTeacherName());
            book.setAuthorID(authorId);
            book.setBranch(user.getBranch());
            book.setSemester(Integer.parseInt(user.getSemester()));

        this.bookRepository.save(book);         //persist using repository
    }

    private String teacherUniqueId(String name){
        return name.toUpperCase().replace(" ", "").substring(0, 2)
                + String.format("%04d", random.nextInt(10000));
    }
    private String bookUniqueId(String name){
        return name.toUpperCase().replace(" ", "").substring(0, 3)
                + String.format("%04d", random.nextInt(10000));
    }
}
