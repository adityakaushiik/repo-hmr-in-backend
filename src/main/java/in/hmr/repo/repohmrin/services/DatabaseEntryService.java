package in.hmr.repo.repohmrin.services;

import in.hmr.repo.repohmrin.entity.Author;
import in.hmr.repo.repohmrin.repository.AuthorRepository;
import in.hmr.repo.repohmrin.entity.Book;
import in.hmr.repo.repohmrin.repository.BookRepository;
import in.hmr.repo.repohmrin.entity.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

@Service
public class DatabaseEntryService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ImageStorageService imageStorageService;
    private final Random random = new Random();


    public void addEntry(UserResponse userResponse) throws IOException {
        Author author = new Author();
        Book book = new Book();

        String imgId = imageStorageService.uploadImageToFileSystem(userResponse.getImage(), userResponse.getPdf());

        String authorId = teacherUniqueId(userResponse.getTeacherName());
            author.setId(authorId);
            author.setName(userResponse.getTeacherName());

        this.authorRepository.save(author);     //persist using repository

        String bookId = bookUniqueId(userResponse.getTitle());
            book.setId(bookId);
            book.setTitle(userResponse.getTitle());
            book.setDescription(userResponse.getDescription());
            book.setPublishedDate(LocalDate.now());
            book.setAuthorNames(userResponse.getTeacherName());
            book.setAuthorID(authorId);
            book.setBranch(userResponse.getBranch());
            book.setSemester(Integer.parseInt(userResponse.getSemester()));
            book.setCoverId(imgId);
            book.setOrignalName(userResponse.getPdf().getOriginalFilename());

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
