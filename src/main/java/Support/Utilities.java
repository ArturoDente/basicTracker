/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

/**
 *
 * @author franc
 */
public class Utilities {
    public static boolean isNumber(String s){
        try {
            Integer i=Integer.valueOf(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
