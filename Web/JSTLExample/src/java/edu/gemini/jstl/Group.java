package edu.gemini.jstl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Group {

    private Integer groupId;
    private String groupName;
    private String curator;
    private String speciality;

    public Group() {
    }

    public Group(ResultSet rs) throws SQLException {
        groupId = rs.getInt("group_id");
        groupName = rs.getString("groupName");
        curator = rs.getString("curator");
        speciality = rs.getString("speciality");
    }

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
