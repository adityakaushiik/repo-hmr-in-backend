package in.hmr.repo.repohmrin.userResponses;

import org.springframework.web.multipart.MultipartFile;

public class RegistrationDetails {
    private String teacherName;
    private String title;
    private String branch;
    private String semester;
    private String scode;
    private String description;
    private String type;
    private MultipartFile pdf;

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

//    public boolean isAuthor() {
//        return isAuthor;
//    }
//
//    public void setAuthor(boolean author) {
//        isAuthor = author;
//    }

//    public MultipartFile getImage() {
//        return image;
//    }
//
//    public void setImage(MultipartFile image) {
//        this.image = image;
//    }

    public MultipartFile getPdf() {
        return pdf;
    }

    public void setPdf(MultipartFile pdf) {
        this.pdf = pdf;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
