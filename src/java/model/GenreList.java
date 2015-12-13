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
    
    public void setArray(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }
}
