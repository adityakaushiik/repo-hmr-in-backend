package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.entities.Book;
import in.hmr.repo.repohmrin.repositories.BookRepository;
import in.hmr.repo.repohmrin.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("HIT -/download | File Name : {}" + fileName);
        return fileService.download(fileName);
    }
    //update
    @PutMapping("/update")
    public String updateBook(@RequestParam("id") String id ,
                             @RequestParam("action") String action) {
        Book thisBook = bookRepository.findBookById(id);

        if (thisBook != null) {
            switch (action){
                case "approve" : thisBook.setTemp(false);
                                    break;
                case "delete" : thisBook.setDeleted(true);
                                thisBook.setTemp(false);
                                    break;
                default: return "book not Found";
            }
            bookRepository.save(thisBook);
            System.out.println("allDone");
            return "Done";
        }
        System.out.println("notDone");
        return "notDone";
    }
}