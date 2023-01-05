package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.services.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/")
public class BookController {
    @Autowired
    DownloadService downloadService;

    @GetMapping("/search/{bookId}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String bookId) throws IOException {

        byte[] pdfData = downloadService.downloadImageFromFileSystem(bookId);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfData);
    }
}
