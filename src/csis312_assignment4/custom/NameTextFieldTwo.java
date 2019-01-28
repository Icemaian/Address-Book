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
public class NameTextFieldTwo extends TextField {
    
     public NameTextFieldTwo() {
         this.setPromptText("Smith");
     }
     
     @Override
     public void replaceText(int i, int il, String string) {
         if(string.matches("[a-zA-Z]") || string.isEmpty()) {
             super.replaceText(i, il, string);
         }
     }
     
     @Override
     public void replaceSelection(String string) {
         super.replaceSelection(string);
     }
}
