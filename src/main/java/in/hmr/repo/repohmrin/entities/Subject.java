package in.hmr.repo.repohmrin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("subjects")
public class Subject {
    @Id
    @PrimaryKeyColumn(name = "semester_sub", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int semester;

    @Column("branch_sub")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String branch;

    @Column("Subjects_all")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String[] subjects;

    public Subject(String branch, int semester, String[] subjects) {
        this.branch = branch;
        this.semester = semester;
        this.subjects = subjects;
    }

    public int getSemester() {
        return semester;
    }

    public String getBranch() {
        return branch;
    }

    public String[] getSubjects() {
        return subjects;
    }
}
