package edu.co.icesi.appmoviles.proyectofinal.model;

public class QuestionAndAnswer {

    private String uid;
    private String question;
    private String answer;
    private String area;

    public QuestionAndAnswer(){

    }

    public QuestionAndAnswer(String uid, String question, String answer, String area) {
        this.uid = uid;
        this.question = question;
        this.answer = answer;
        this.area = area;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return this.question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}