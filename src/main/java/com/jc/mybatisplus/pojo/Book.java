package com.jc.mybatisplus.pojo;

import java.io.Serializable;

/**
 * 
 * @TableName book
 */
public class Book implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private String publish;

    /**
     * 
     */
    private Integer pages;

    /**
     * 
     */
    private Double price;

    /**
     * 
     */
    private Integer bookcaseid;

    /**
     * 
     */
    private Integer abled;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     */
    public String getPublish() {
        return publish;
    }

    /**
     * 
     */
    public void setPublish(String publish) {
        this.publish = publish;
    }

    /**
     * 
     */
    public Integer getPages() {
        return pages;
    }

    /**
     * 
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * 
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 
     */
    public Integer getBookcaseid() {
        return bookcaseid;
    }

    /**
     * 
     */
    public void setBookcaseid(Integer bookcaseid) {
        this.bookcaseid = bookcaseid;
    }

    /**
     * 
     */
    public Integer getAbled() {
        return abled;
    }

    /**
     * 
     */
    public void setAbled(Integer abled) {
        this.abled = abled;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Book other = (Book) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getPublish() == null ? other.getPublish() == null : this.getPublish().equals(other.getPublish()))
            && (this.getPages() == null ? other.getPages() == null : this.getPages().equals(other.getPages()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getBookcaseid() == null ? other.getBookcaseid() == null : this.getBookcaseid().equals(other.getBookcaseid()))
            && (this.getAbled() == null ? other.getAbled() == null : this.getAbled().equals(other.getAbled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getPublish() == null) ? 0 : getPublish().hashCode());
        result = prime * result + ((getPages() == null) ? 0 : getPages().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getBookcaseid() == null) ? 0 : getBookcaseid().hashCode());
        result = prime * result + ((getAbled() == null) ? 0 : getAbled().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", author=").append(author);
        sb.append(", publish=").append(publish);
        sb.append(", pages=").append(pages);
        sb.append(", price=").append(price);
        sb.append(", bookcaseid=").append(bookcaseid);
        sb.append(", abled=").append(abled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}