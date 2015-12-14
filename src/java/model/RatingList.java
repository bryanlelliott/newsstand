/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * RatingList is the list of ratings used.
 * @author francis
 */
public class RatingList {
    String[] array = {
        "1", 
        "2", 
        "3",
        "4",
        "5"
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
