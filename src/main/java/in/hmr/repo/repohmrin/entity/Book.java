package in.hmr.repo.repohmrin.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

@Table("book_by_id")
public class Book {
    @Id
    @PrimaryKeyColumn(name = "book_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;
    @Column("book_name")
    @CassandraType(type = Name.TEXT)
    private String title;
    @Column("book_description")
    @CassandraType(type = Name.TEXT)
    private String description;
    @Column("published_date")
    @CassandraType(type = Name.DATE)
    private LocalDate publishedDate;
    @Column("author_names")
    @CassandraType(type = Name.TEXT, typeArguments = {Name.TEXT})
    private String authorNames;
    @Column("author_ids")
    @CassandraType(type = Name.TEXT, typeArguments = {Name.TEXT})
    private String authorID;
    @Column("book_sem")
    @CassandraType(type = Name.INT)
    private int semester;
    @Column("book_branch")
    @CassandraType(type = Name.TEXT)
    private String branch;
    @Column("cover_id")
    @CassandraType(type = Name.TEXT)
    private String coverId;

    @Column("orignal_name")
    @CassandraType(type = Name.TEXT)
    private String orignalName;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishedDate() {
        return this.publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthorNames() {
        return this.authorNames;
    }

    public void setAuthorNames(String authorNames) {
        this.authorNames = authorNames;
    }

    public String getAuthorID() {
        return this.authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public int getSemester() {
        return this.semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }

    public String getOrignalName() {
        return orignalName;
    }
    public void setOrignalName(String orignalName) {
        this.orignalName = orignalName;
    }
}
