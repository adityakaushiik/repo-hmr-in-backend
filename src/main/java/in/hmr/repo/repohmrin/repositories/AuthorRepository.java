package in.hmr.repo.repohmrin.repositories;

import in.hmr.repo.repohmrin.entities.Author;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CassandraRepository<Author, String> {
}
