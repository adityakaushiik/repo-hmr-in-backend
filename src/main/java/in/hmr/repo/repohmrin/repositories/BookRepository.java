package in.hmr.repo.repohmrin.repositories;

import in.hmr.repo.repohmrin.entities.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface BookRepository extends CassandraRepository<Book, String> {
    Book findBookById(String id);

    @Query(allowFiltering = true)
    Slice<Book> findAllBookByBranchAndSemesterAndSubjectCodeAndIsTempAndIsDeleted(
            String branch,
            int semester,
            String subjectCode,
            boolean isTemp,
            boolean isDeleted,
            Pageable pageable);

    @Query(allowFiltering = true)
    Slice<Book> findAllBookByIsTemp(boolean isTemp,
                                    Pageable pageable);

    @Query(allowFiltering = true)
    Slice<Book> findTopByPublishedDateAndIsTempAndIsDeleted(LocalDate date,
            boolean isTemp,
            boolean isDeleted,
            Pageable pageable);

    @Query(allowFiltering = true)
    Slice<Book> findAllByViewsAndIsTempAndIsDeleted(int views,
                                                    boolean isTemp,
                                                    boolean isDeleted,
                                                    Pageable pageable);
}

