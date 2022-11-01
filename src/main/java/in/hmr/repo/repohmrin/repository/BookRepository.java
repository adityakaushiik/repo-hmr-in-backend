package in.hmr.repo.repohmrin.repository;

import in.hmr.repo.repohmrin.entity.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CassandraRepository<Book, String> {
}

