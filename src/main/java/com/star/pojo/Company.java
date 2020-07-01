package com.star.pojo;

import java.util.List;

public class Company {
    private int id;
    private String companyName;
    private String companyContent;
    private String companyPhone;
    private List<User> userList;


    //该公司下面的所有员工


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContent() {
        return companyContent;
    }

    public void setCompanyContent(String companyContent) {
        this.companyContent = companyContent;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyContent='" + companyContent + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", userList=" + userList +
                '}';
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
