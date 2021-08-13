package kz.bitlab.almatgroup.almatboot.beans;

import org.springframework.context.annotation.Bean;

public class SecondBean {

    private String text;
    private int number;

    public SecondBean(String text, int number) {
        System.out.println("Using parametrized constructor of Second Bean");
        this.text = text;
        this.number = number;
    }

    public SecondBean() {
        System.out.println("Using default constructor of Second Bean");
        this.number = 555;
        this.text = "This is a second Bean";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
