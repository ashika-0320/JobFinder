package model;

public class Job {
    private int jid;
    private String jtitle;
    private String skills;
    private String location;

    public Job(String jtitle, String skills, String location) {
        this.jtitle = jtitle;
        this.skills = skills;
        this.location = location;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
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
        return "Job{" +
                "jid=" + jid +
                ", jtitle='" + jtitle + '\'' +
                ", skills='" + skills + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
