package com.hellokoding.springboot.model;

public class Marks {

    //10th Marks
    private Integer tenthBestOne;
    private Integer tenthBestTwo;
    private Integer tenthBestThree;

    //11th Marks
    private Integer eleventhTotal;

    private String result;

    public Integer getTenthBestOne() {
        return tenthBestOne;
    }

    public void setTenthBestOne(Integer tenthBestOne) {
        this.tenthBestOne = tenthBestOne;
    }

    public Integer getTenthBestTwo() {
        return tenthBestTwo;
    }

    public void setTenthBestTwo(Integer tenthBestTwo) {
        this.tenthBestTwo = tenthBestTwo;
    }

    public Integer getTenthBestThree() {
        return tenthBestThree;
    }

    public void setTenthBestThree(Integer tenthBestThree) {
        this.tenthBestThree = tenthBestThree;
    }

    public Integer getEleventhTotal() {
        return eleventhTotal;
    }

    public void setEleventhTotal(Integer eleventhTotal) {
        this.eleventhTotal = eleventhTotal;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
