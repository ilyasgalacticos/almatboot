package kz.bitlab.almatgroup.almatboot.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FirstBean {

    private String text;
    private int number;

    public FirstBean(){
        this.text = "Hello bean";
        this.number = 23;
        System.out.println("I am initializing a new my First Bean");
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