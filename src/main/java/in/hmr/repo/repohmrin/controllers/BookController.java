package in.hmr.repo.repohmrin.controllers;

import in.hmr.repo.repohmrin.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/")
public class BookController {
    @Autowired
    FileService fileService;

    @PostMapping("/search/pic/{fileName}")
    public Object download(@PathVariable String fileName) throws IOException {
        System.out.println("HIT -/download | File Name : {}"+fileName);
        return fileService.download(fileName);
    }
}

//    @Autowired
//    DownloadService downloadService;

//    @GetMapping("/search/{bookId}")
//    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String bookId) throws IOException {
//
//        byte[] pdfData = downloadService.downloadImageFromFileSystem(bookId);
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(pdfData);
//    }

//    @PostMapping("/profile/pic")
//    public Object upload(@RequestParam("file") MultipartFile multipartFile) {
//        System.out.println("HIT -/upload | File Name : {}"+ multipartFile.getOriginalFilename());
//        return fileService.upload(multipartFile);
//    }