/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * ArticleBox is the action class for article.jsp.
 * @author francis
 */
public class ArticleBox {
    String articleName;
    double rating;
    String genre;
    
    /********
     * Setter for String articleName.
     * @param String articleName
     * 
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    /********
     * Getter for String array.
     * 
     * @return string array
     */
    public String getArray() {
        return articleName;
    }
    
    /********
     * Setter for double rating.
     * @param double rating
     * 
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /********
     * Getter for double rating.
     * 
     * @return double rating
     */
    public double getRating() {
        return rating;
    }
    
    /********
     * Setter for String genre.
     * @param String genre
     * 
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /********
     * Getter for String genre.
     * 
     * @return string genre
     */
    public String getGenre() {
        return genre;
    }
}
