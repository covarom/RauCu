/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Doan
 */
public class ConvertDate {
    public Date StringtoDate(String date) throws ParseException{
    String pattern="yyyy-MM-dd";
        SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
        Date day=dateFormat.parse(date);
        return day;
}
    public String DateToString(Date day){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String strDate=sdf.format(day);
        return strDate;
    }
    
    public int GetID(){
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddss");  
        String formattedDate = myDateObj.format(myFormatObj);
        int dai=Integer.parseInt(formattedDate);
        return dai;
    }
    public Date getDate() throws ParseException{
        LocalDateTime myDateObj = LocalDateTime.now();
        String date=myDateObj.toString();
        String pattern="yyyy-MM-dd";
        SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
        Date day=dateFormat.parse(date);
        return day;
    }
}
