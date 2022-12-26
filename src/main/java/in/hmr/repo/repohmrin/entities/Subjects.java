package in.hmr.repo.repohmrin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

public class Subjects {
    @Table("subjects")
    public class Book {
        @Id
        @PrimaryKeyColumn(name = "branch_sub", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
        private String branch;

        @Column("semester_sub")
        @CassandraType(type = CassandraType.Name.TEXT)
        private String semester;

        @Column("Subjects_all")
        @CassandraType(type = CassandraType.Name.TEXT)
        private String[] subjects;

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public String[] getSubjects() {
            return subjects;
        }

        public void setSubjects(String[] subjects) {
            this.subjects = subjects;
        }
    }
}
