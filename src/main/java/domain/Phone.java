package domain;

import java.util.List;

public class Phone {
    private int pid;
    private String name;
    private String information;
    private String photo;
    private List<PhoneVersion> versions;
    private Color colors;

    public Color getColors() {
        return colors;
    }

    public void setColors(Color colors) {
        this.colors = colors;
    }

    private String belong;
    private String moneyon;
    private String details;
    private String buydetails;
    private String Private;

    public String getPrivate() {
        return Private;
    }

    public void setPrivate(String Private) {
       this.Private = Private;
    }

    public String getMoneyon() {
        return moneyon;
    }

    public void setMoneyon(String moneyon) {
        this.moneyon = moneyon;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBuydetails() {
        return buydetails;
    }

    public void setBuydetails(String buydetails) {
        this.buydetails = buydetails;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public List<PhoneVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<PhoneVersion> versions) {
        this.versions = versions;
    }
}
