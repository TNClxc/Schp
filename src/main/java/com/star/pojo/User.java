package com.star.pojo;

public class User {
    private int id;
    private String realName;
    private String userName;
    private String  passWord;
    private String sex;
    private String usePhone;
    private int userRoleId;
    private Role Role;
    private int companyId;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsePhone() {
        return usePhone;
    }

    public void setUsePhone(String usePhone) {
        this.usePhone = usePhone;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public com.star.pojo.Role getRole() {
        return Role;
    }

    public void setRole(com.star.pojo.Role role) {
        Role = role;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", usePhone='" + usePhone + '\'' +
                ", userRoleId=" + userRoleId +
                ", Role=" + Role +
                ", companyId=" + companyId +
                '}';
    }
}
