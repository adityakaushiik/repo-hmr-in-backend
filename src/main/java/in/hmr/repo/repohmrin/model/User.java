package in.hmr.repo.repohmrin.model;

public class User {
    private String teacherName;
    private String title;
    private String branch;
    private String semester;
    private String subjectCode;
    private String description;
    private boolean isAuthor;

    public User() {
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSubjectCode() {
        return this.subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSemester() {
        return this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public boolean isAuthor() {
        return this.isAuthor;
    }

    public void setAuthor(boolean author) {
        this.isAuthor = author;
    }

    public String toString() {
        return "User{teacherName='" + this.teacherName + '\'' + ", title='" + this.title + '\'' + ", branch='" + this.branch + '\'' + ", semester='" + this.semester + '\'' + ", subjectCode='" + this.subjectCode + '\'' + ", description='" + this.description + '\'' + '}';
    }
}
