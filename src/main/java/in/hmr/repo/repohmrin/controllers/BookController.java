package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.entities.Book;
import in.hmr.repo.repohmrin.repositories.BookRepository;
import in.hmr.repo.repohmrin.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    FileService fileService;

    @GetMapping("/file")
    public URL download(@RequestParam("name") String fileName) throws IOException {
//        System.out.println("HIT -/download | File Name : {}" + fileName);
        return fileService.download(fileName);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        Book thisBook = bookRepository.findBookById(book.getId());
        System.out.println(book);
        if (thisBook != null) {
            thisBook=book;
            bookRepository.save(thisBook);
            System.out.println("allDone");
            return book;
        }
        System.out.println("notDone");
        return new Book();
    }

    @GetMapping("/updateViews")
    public Book updateBook(@RequestParam("id") String id){
        System.out.println("incrementing views for : "+id);
        Book thisBook = bookRepository.findBookById(id);

        if (thisBook != null) {
            thisBook.setViews(thisBook.getViews()+1);
            bookRepository.save(thisBook);
            return thisBook;
        }

        System.out.println("notDone");
        return new Book();
    }
}