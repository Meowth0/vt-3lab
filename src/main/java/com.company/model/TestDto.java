package com.company.model;

public class TestDto {

    private String type;
    private String questionsAmount;
    private String additionalInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestionsAmount() {
        return questionsAmount;
    }

    public void setQuestionsAmount(String questionsAmount) {
        this.questionsAmount = questionsAmount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "type='" + type + '\'' +
                ", questionsAmount='" + questionsAmount + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
