/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csis312_assignment4.custom;

import javafx.scene.control.TextField;

/**
 *
 * @author Nick
 */
public class ZipTextField extends TextField {
    
     public ZipTextField() {
         this.setPromptText("24502");
     }
         
     @Override
     public void replaceText(int i, int il, String string) {
         if((i <=4) && string.matches("[0-9]{1,5}") || string.isEmpty()) {
             super.replaceText(i, il, string);
         }
     }
     
     @Override
     public void replaceSelection(String string) {
         super.replaceSelection(string);
     }
     
}