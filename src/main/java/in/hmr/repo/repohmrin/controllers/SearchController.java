package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.entities.Book;
import in.hmr.repo.repohmrin.repositories.BookRepository;
import in.hmr.repo.repohmrin.userResponses.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class SearchController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping({"/search"})
    public List<Book> bookSearch(@RequestBody SearchParameters searchParameter){
        System.out.println("got api call "+searchParameter);
        Slice<Book> booksSlice = bookRepository.findAllBookByBranchAndSemesterAndSubjectCodeAndIsTempAndIsDeleted(
                searchParameter.getBranch(),
                searchParameter.getSemester(),
                searchParameter.getSubjectCode(),
                false,false,
                CassandraPageRequest.of(0,100));
        List<Book> booksByQuery = booksSlice.getContent();
        return booksByQuery;
    }

    @GetMapping({"/admin/review"})
    public List<Book> reviewBooks(){
        System.out.println("Send Temp Books");
        Slice<Book> booksSlice = bookRepository.findAllBookByIsTemp(true,
                CassandraPageRequest.of(0,100));
        return booksSlice.getContent();
    }
}
