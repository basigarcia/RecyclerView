package com.basigarcia.android.recyclerviewtutorial;

/**
 * Created by BasiV on 7/5/2016.
 */
public class Tutorial {

    private String title;
    private String quality;
    private int views;

    public Tutorial(String title, int views, String quality){
        this.title = title;
        this.quality = quality;
        this.views = views;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
