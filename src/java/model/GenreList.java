/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * GenreList is the list of genres used.
 * @author francis
 */
public class GenreList {
    String[] array = {
        "World", 
        "US", 
        "Politics",
        "Entertainment",
        "Sports",
        "Tech",
        "Money",
        "Science",
        "Travel",
        "Living",
        "Other"
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
