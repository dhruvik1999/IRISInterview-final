
package com.example.dhruvik.iris_interview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {

    //java class for convert response into java object

    @SerializedName("company")
    @Expose
    private Company company;
    @SerializedName("deadline")
    @Expose
    private String deadline;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("recruitment_date")
    @Expose
    private String recruitmentDate;
    @SerializedName("recruitment_type")
    @Expose
    private String recruitmentType;
    @SerializedName("url")
    @Expose
    private String url;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(String recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public String getRecruitmentType() {
        return recruitmentType;
    }

    public void setRecruitmentType(String recruitmentType) {
        this.recruitmentType = recruitmentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
