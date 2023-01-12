package in.hmr.repo.repohmrin.entities;

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
    @Column("book_type")
    @CassandraType(type = Name.TEXT)
    private String type;
    @Column("subject_code")
    @CassandraType(type = Name.TEXT)
    private String subjectCode;
    @Column("pdf_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String pdfOriginalName;
    @Column("pdf_path")                 //not needed anymore
    @CassandraType(type = CassandraType.Name.TEXT)
    private String pdfFilePath;

//    @Column("is_temp")                                // implement these
//    @CassandraType(type = Name.BOOLEAN)
//    private boolean isTemp;

//    @Column("is_deleted")
//    @CassandraType(type = Name.BOOLEAN)
//    private boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(String authorNames) {
        this.authorNames = authorNames;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public int getSemester() {
        return semester;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getPdfOriginalName() {
        return pdfOriginalName;
    }

    public void setPdfOriginalName(String pdfOriginalName) {
        this.pdfOriginalName = pdfOriginalName;
    }

    public String getPdfFilePath() {
        return pdfFilePath;
    }

    public void setPdfFilePath(String pdfFilePath) {
        this.pdfFilePath = pdfFilePath;
    }
}
