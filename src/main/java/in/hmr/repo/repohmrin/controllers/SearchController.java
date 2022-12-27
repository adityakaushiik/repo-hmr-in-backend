package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.entities.Book;
import in.hmr.repo.repohmrin.repositories.BookRepository;
import in.hmr.repo.repohmrin.userResponses.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private BookRepository bookRepository;
//
//    @GetMapping({"/search"})
//    public String search(){
//        return "Search-page";
//    }

    @PostMapping({"/search"})
    public List<Book> bookSearch(@ModelAttribute SearchParameters searchParameter ,
                                 Model model){
        System.out.println("got api call");
        Slice<Book> booksSlice = bookRepository.findAllBookByBranchAndSemesterAndSubjectCode(
                searchParameter.getBranch(),
                searchParameter.getSemester(),
                searchParameter.getSubjectCode(),
                CassandraPageRequest.of(0,100));
        List<Book> booksByQuery = booksSlice.getContent();

        model.addAttribute("books",booksByQuery);
        return booksByQuery;
    }
}
