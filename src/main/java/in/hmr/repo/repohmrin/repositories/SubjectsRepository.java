package in.hmr.repo.repohmrin.repositories;


import in.hmr.repo.repohmrin.entities.Subjects;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends CassandraRepository<Subjects, String> {
    @Query(allowFiltering = true)
    String[] findSubjectsByBranchAndSemester(String branch, int semester);
}

