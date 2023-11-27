package com.example.viewpage2;

import java.io.Serializable;

public class Page implements Serializable {

    private int image;

    public Page(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
