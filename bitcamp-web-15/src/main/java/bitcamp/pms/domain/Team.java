package bitcamp.pms.domain;

import java.sql.Date;

public class Team {
    
    String name;
    String description;
    int maxQuantity;
    Date startDate;
    Date endDate;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getMaxQuantity() {
        return maxQuantity;
    }
    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    } 
} // class
