/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Hoang Anh
 */
// Hiển thị thông báo lỗi chưa nhập thông tin 
public class DataValidator {
    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage){
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
}
