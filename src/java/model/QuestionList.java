/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author francis
 */
public class QuestionList {
    String[] array = {
        "What is the name of your childhood best friend?", 
        "What city were you born in?", 
        "What is the name of your first pet?",
        "What is your favorite color?",
        "Who is your favorite celebrity?"
    };

    public void setArray(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }
}
