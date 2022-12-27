package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.entities.Book;
import in.hmr.repo.repohmrin.repositories.BookRepository;
import in.hmr.repo.repohmrin.userResponses.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class SearchController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping({"/search"})
    public List<Book> bookSearch(@ModelAttribute SearchParameters searchParameter){
        System.out.println("got api call");
        Slice<Book> booksSlice = bookRepository.findAllBookByBranchAndSemesterAndSubjectCode(
                searchParameter.getBranch(),
                searchParameter.getSemester(),
                searchParameter.getSubjectCode(),
                CassandraPageRequest.of(0,100));
        List<Book> booksByQuery = booksSlice.getContent();
        return booksByQuery;
    }
}
