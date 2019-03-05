package demo.pojo;

import java.util.Date;

public class blog {
    private Integer blogId;

    private Integer userId;

    private Integer classId;

    private String blogTitle;

    private String blogLabel;

    private Integer viewTimes;

    private Date createTime;

    private String blogContent;

    public blog(Integer blogId, Integer userId, Integer classId, String blogTitle, String blogLabel, Integer viewTimes, Date createTime, String blogContent) {
        this.blogId = blogId;
        this.userId = userId;
        this.classId = classId;
        this.blogTitle = blogTitle;
        this.blogLabel = blogLabel;
        this.viewTimes = viewTimes;
        this.createTime = createTime;
        this.blogContent = blogContent;
    }

    public blog() {
        super();
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getBlogLabel() {
        return blogLabel;
    }

    public void setBlogLabel(String blogLabel) {
        this.blogLabel = blogLabel == null ? null : blogLabel.trim();
    }

    public Integer getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}