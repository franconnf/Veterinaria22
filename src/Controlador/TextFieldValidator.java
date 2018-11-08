/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTextField;

/**
 *
 * @author Aceites
 */
public class TextFieldValidator {
    
    ArrayList<Boolean> fieldList;

    public TextFieldValidator() {
        fieldList = new ArrayList<>();
    }
    
    
    public static boolean dayOfMonth(JTextField txtf){
        return txtf.getText().matches("\\d{1,2}") & Integer.parseInt(txtf.getText()) <= 31;
    }
    public static boolean month(JTextField txtf){
        return txtf.getText().matches("\\d{1,2}") & Integer.parseInt(txtf.getText()) <= 12;
    }
    public static boolean year(JTextField txtf){
        return txtf.getText().matches("\\d{4}") & Calendar.getInstance().get(Calendar.YEAR) >= Integer.parseInt(txtf.getText());
    }
    public static boolean onlyNumbers(JTextField txtf){
        return txtf.getText().matches("(\\d)+\\.{1}");
    }
    public static boolean onlyLetters(JTextField txtf){
        return txtf.getText().matches("[A-Za-z]+");
    }
    public static boolean form(ArrayList<Boolean> textFields){
        return textFields.stream().allMatch( t -> t);
    }
    
    public void addField(JTextField field, Validator validator){
        fieldList.add(validator.validate(field));
    }
    
    public boolean validate(){
        return fieldList.stream().allMatch(t -> t);
    }
}
