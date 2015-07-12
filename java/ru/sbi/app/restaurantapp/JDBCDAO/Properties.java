/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCDAO;

/**
 *
 * @author Vladimir
 */
public class Properties {
    public static String url = "jdbc:sqlite:test.db";
    
    public static void setUrl(String newUrl){
        url = newUrl;
    }
}
