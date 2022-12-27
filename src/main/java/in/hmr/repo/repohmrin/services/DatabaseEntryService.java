package in.hmr.repo.repohmrin.services;

import in.hmr.repo.repohmrin.entities.Author;
import in.hmr.repo.repohmrin.entities.Book;
import in.hmr.repo.repohmrin.repositories.AuthorRepository;
import in.hmr.repo.repohmrin.repositories.BookRepository;
import in.hmr.repo.repohmrin.userResponses.RegistrationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

@Service
public class DatabaseEntryService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    private final String PDF_FOLDER_PATH = "D:/hmr-repo/pdf/";
    private final Random random = new Random();

    public void addEntry(RegistrationDetails details) throws IOException {

        String pdfFilePath = PDF_FOLDER_PATH +
                details.getPdf().getOriginalFilename();
        details.getPdf().transferTo(new File(pdfFilePath));
        Author author = new Author();
        String authorId = teacherUniqueId(details.getTeacherName());
        author.setId(authorId);
        author.setName(details.getTeacherName());
        this.authorRepository.save(author);

        Book book = new Book();
        String bookId = bookUniqueId(details.getTitle());
        book.setId(bookId);
        book.setTitle(details.getTitle());
        book.setDescription(details.getDescription());
        book.setPublishedDate(LocalDate.now());
        book.setAuthorNames(details.getTeacherName());
        book.setAuthorID(authorId);
        book.setSemester(Integer.parseInt(details.getSemester()));
        book.setBranch(details.getBranch());
        book.setType(details.getType());
        book.setSubjectCode(details.getScode());
        book.setPdfOriginalName(details.getPdf().getOriginalFilename());
        book.setPdfFilePath(pdfFilePath);
        this.bookRepository.save(book);
    }

    private String teacherUniqueId(String name) {
        return name.toUpperCase().replace(" ", "").substring(0, 2)
                + String.format("%04d", random.nextInt(10000));
    }

    private String bookUniqueId(String name) {
        return name.toUpperCase().replace(" ", "").substring(0, 3)
                + String.format("%04d", random.nextInt(10000));
    }
}
