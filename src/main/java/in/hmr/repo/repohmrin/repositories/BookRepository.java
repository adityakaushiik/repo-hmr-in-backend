package in.hmr.repo.repohmrin.repositories;

import in.hmr.repo.repohmrin.entities.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CassandraRepository<Book, String> {
    @Query(allowFiltering = true)
    Slice<Book> findAllBookByBranchAndSemesterAndSubjectCodeAndIsTempAndIsDeleted
            (String branch, int semester, String subjectCode, boolean isTemp , boolean isDeleted, Pageable pageable);
    @Query(allowFiltering = true)
    Slice<Book> findAllBookByIsTemp(boolean isTemp, Pageable pageable);

    Book findBookById(String id);
}

