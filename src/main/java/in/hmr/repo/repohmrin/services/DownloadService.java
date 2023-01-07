//package in.hmr.repo.repohmrin.services;
//
//import in.hmr.repo.repohmrin.entities.Book;
//import in.hmr.repo.repohmrin.repositories.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.Optional;
//
//@Service
//public class DownloadService {
//    @Autowired
//    BookRepository bookRepository;
//
//    public byte[] downloadImageFromFileSystem(String id) throws IOException {
//        Optional<Book> fileData = bookRepository.findById(id);
//        String filePath = fileData.get().getPdfFilePath();
//        byte[] pdf = Files.readAllBytes(new File(filePath).toPath());
//        return pdf;
//    }
//}
