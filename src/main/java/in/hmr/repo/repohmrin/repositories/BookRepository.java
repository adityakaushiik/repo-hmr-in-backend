package in.hmr.repo.repohmrin.repositories;

import in.hmr.repo.repohmrin.entities.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CassandraRepository<Book, String> {
    @Query(allowFiltering = true)
    Slice<Book> findAllBookByBranchAndSemesterAndSubjectCode
            (String branch, int semester, String subjectCode, Pageable pageable);
}

