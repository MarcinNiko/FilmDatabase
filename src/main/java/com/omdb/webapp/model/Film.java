package com.omdb.webapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Film {
    @Id
    private int fid;
    private String title;
    private String year;
    private String director;

    @Override
    public String toString() {
        return "Film{" +
                "fid=" + fid +
                ", ftitle='" + title + '\'' +
                ", fyear='" + year + '\'' +
                ", fdirector='" + director + '\'' +
                '}';
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
