package com.star.pojo;

import java.util.Date;

public class Info {

    private int id;
    private String infoTitle;
    private String infoContent;
    private int infoType;
    private Date infoDate;
    private int userId;
    private int infoPraise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public int getInfoType() {
        return infoType;
    }

    public void setInfoType(int infoType) {
        this.infoType = infoType;
    }

    public Date getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(Date infoDate) {
        this.infoDate = infoDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInfoPraise() {
        return infoPraise;
    }

    public void setInfoPraise(int infoPraise) {
        this.infoPraise = infoPraise;
    }
}
