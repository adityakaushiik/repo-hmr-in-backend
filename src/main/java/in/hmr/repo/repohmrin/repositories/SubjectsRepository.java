package in.hmr.repo.repohmrin.repositories;

import in.hmr.repo.repohmrin.entities.Subject;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends CassandraRepository<Subject, String> {
    @Query(allowFiltering = true)
    Subject getAllByBranchAndSemester(String branch, int semester);
}

