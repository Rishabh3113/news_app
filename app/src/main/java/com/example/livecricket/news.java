package com.example.livecricket;

import java.util.ArrayList;

public class news {
    private String status;
    private int totalResults;
    private ArrayList<model>articles;

    public news(String status, int totalResults, ArrayList<model> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<model> articles) {
        this.articles = articles;
    }
    //shift+downarrow for selecting all
}
