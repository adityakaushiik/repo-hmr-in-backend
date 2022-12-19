package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.entities.Book;
import in.hmr.repo.repohmrin.repositories.BookRepository;
import in.hmr.repo.repohmrin.userResponses.SearchParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping({"/search"})
    public String search(){
        return "search";
    }

    @PostMapping({"/search"})
    public String bookSearch(@ModelAttribute SearchParameters searchParameter ,
                                   Model model){
        Slice<Book> booksSlice = bookRepository.findAllBookByBranchAndSemesterAndSubjectCode(
                searchParameter.getBranch(),
                searchParameter.getSemester(),
                searchParameter.getSubjectCode(),
                CassandraPageRequest.of(0,100));
        List<Book> booksByQuery = booksSlice.getContent();

        List<String> list = List.of("abc","bcd","def");

        model.addAttribute("books",booksByQuery);
        model.addAttribute("list",list);
        return "search";
    }

}
