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
public class ArticleBox {
    String articleName;
    String sentence;
    double rating;
    String genre;
    
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArray() {
        return articleName;
    }
    
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
