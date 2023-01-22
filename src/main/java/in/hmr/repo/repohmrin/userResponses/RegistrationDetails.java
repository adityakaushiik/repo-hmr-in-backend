package in.hmr.repo.repohmrin.userResponses;

public class RegistrationDetails {
    private String teacherName;
    private String title;
    private String branch;
    private String semester;
    private String subjectCode;
    private String description;
    private String type;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RegistrationDetails{" +
                "teacherName='" + teacherName + '\'' +
                ", title='" + title + '\'' +
                ", branch='" + branch + '\'' +
                ", semester='" + semester + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
