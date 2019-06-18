package com.my.algorithm;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/13 16:45
 */

public class Entity {
    private Integer id;
    private String industry;
    private int time;
    private int hz;
    private boolean industrySuccession;


    public Entity(){}

    public Entity(Integer id, String industry,int time,int hz) {
        this.id = id;
        this.industry = industry;
        this.time = time;
        this.hz = hz;
    }

    public boolean isIndustrySuccession() {
        return industrySuccession;
    }

    public void setIndustrySuccession(boolean industrySuccession) {
        this.industrySuccession = industrySuccession;
    }

    public int getHz() {
        return hz;
    }

    public void setHz(int hz) {
        this.hz = hz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
