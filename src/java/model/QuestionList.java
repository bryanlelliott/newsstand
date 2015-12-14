/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * QuestionList is the list of questions used.
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

    /********
     * Setter for String[] array.
     * @param String[] array
     * 
     */
    public void setArray(String[] array) {
        this.array = array;
    }

    /********
     * Getter for String[] array.
     * 
     * @return String[] userId
     */
    public String[] getArray() {
        return array;
    }
}
