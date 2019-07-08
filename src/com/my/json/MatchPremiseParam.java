package com.my.json;

import java.util.List;

/**
 * @author : chensai
 * @date : 2019/1/16 15:47
 * @version 1.0
 */

public class MatchPremiseParam {

    private String city;
    /**
     * 供应商
     */
    private String supplier;

    private Long beginTime;

    private Long endTime;

    private String trade;

    private String type;

    private String second;

    private String count;

    private List<String> premiseIds;

    private boolean moreTwo;

    private boolean continuation;

    private String pointStatus="1";

    private List<Person> persons;



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<String> getPremiseIds() {
        return premiseIds;
    }

    public void setPremiseIds(List<String> premiseIds) {
        this.premiseIds = premiseIds;
    }

    public boolean isMoreTwo() {
        return moreTwo;
    }

    public void setMoreTwo(boolean moreTwo) {
        this.moreTwo = moreTwo;
    }

    public boolean isContinuation() {
        return continuation;
    }

    public void setContinuation(boolean continuation) {
        this.continuation = continuation;
    }

    public String getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(String pointStatus) {
        this.pointStatus = pointStatus;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
