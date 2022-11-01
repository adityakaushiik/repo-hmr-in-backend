package in.hmr.repo.repohmrin.repository;

import in.hmr.repo.repohmrin.entity.Author;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CassandraRepository<Author, String> {
}
