package bitcamp.pms.domain;

import java.sql.Date;

public class Board {
    
    int no;
    String title;
    String password;
    String content;
    Date createdDate;
    
    
    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreateDate() {
        return createdDate;
    }
    public void setCreateDate(Date createDate) {
        this.createdDate = createDate;
    }

    
}
