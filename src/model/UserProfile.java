package model;

public class UserProfile {
    private int uid;
    private String jtitle;
    private String skills;
    private String location;

    public UserProfile(String jtitle, String skills, String location) {
        this.jtitle = jtitle;
        this.skills = skills;
        this.location = location;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getJtitle() {
        return jtitle;
    }

    public void setJtitle(String jtitle) {
        this.jtitle = jtitle;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserProfileRepo{" +
                "uid=" + uid +
                ", jtitle='" + jtitle + '\'' +
                ", skills='" + skills + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
