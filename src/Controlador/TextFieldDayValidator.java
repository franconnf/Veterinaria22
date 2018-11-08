/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.JTextField;

/**
 *
 * @author Aceites
 */
public class TextFieldDayValidator implements Validator {

    @Override
    public boolean validate(JTextField textField) {
        return textField.getText().matches("\\d{1,2}") & Integer.parseInt(textField.getText()) <= 31;
    }
    
}
