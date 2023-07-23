package com.xwl.pojo;

public class Adress {
    private String city;
    private String qu;

    public Adress() {
    }

    public Adress(String city, String qu) {
        this.city = city;
        this.qu = qu;
    }

    /**
     * 获取
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取
     * @return qu
     */
    public String getQu() {
        return qu;
    }

    /**
     * 设置
     * @param qu
     */
    public void setQu(String qu) {
        this.qu = qu;
    }

    public String toString() {
        return "Adress{city = " + city + ", qu = " + qu + "}";
    }
}
