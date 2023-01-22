package in.hmr.repo.repohmrin.services;

import in.hmr.repo.repohmrin.entities.Author;
import in.hmr.repo.repohmrin.entities.Book;
import in.hmr.repo.repohmrin.repositories.AuthorRepository;
import in.hmr.repo.repohmrin.repositories.BookRepository;
import in.hmr.repo.repohmrin.userResponses.RegistrationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Random;

@Service
public class DatabaseEntryService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private FileService fileService;
    private final Random random = new Random();

    public void addEntry(RegistrationDetails details , MultipartFile file){

        String[] fileDetails = fileService.upload(file);

        if (fileDetails[0].equals("NA")){
            System.out.println("could not upload file");
            return;
        }

        Author author = new Author();
        String authorId = teacherUniqueId(details.getTeacherName());
        author.setId(authorId);
        author.setName(details.getTeacherName());
        this.authorRepository.save(author);

        Book book = new Book();
        book.setId(fileDetails[0]);
        book.setTitle(details.getTitle());
        book.setDescription(details.getDescription());
        book.setPublishedDate(LocalDate.now());
        book.setAuthorNames(details.getTeacherName());
        book.setAuthorID(authorId);
        book.setSemester(Integer.parseInt(details.getSemester()));
        book.setBranch(details.getBranch());
        book.setType(details.getType());
        book.setSubjectCode(details.getSubjectCode());
        book.setPdfOriginalName(file.getOriginalFilename());
        book.setPdfFilePath(fileDetails[1]);
        book.setTemp(true);
        book.setDeleted(false);
        book.setViews(0);
        this.bookRepository.save(book);

        System.out.println("files uploaded : "+ file.getOriginalFilename());
    }

    private String teacherUniqueId(String name) {
        return name.toUpperCase().replace(" ", "").substring(0, 2)
                + String.format("%04d", random.nextInt(10000));
    }
}
//    private String bookUniqueId(String name) {
//        return name.toUpperCase().replace(" ", "").substring(0, 3)
//                + String.format("%04d", random.nextInt(10000));
//    }