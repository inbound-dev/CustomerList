/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerlist;
import java.io.*;
import java.util.*;
import java.lang.*;
/**
 *
 * @author Jorda
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text, name, address, city, province, postalCode;
        boolean valid = false;
        int newCustomers, curCustomer = 1;
        try{
            
            File file  = new File("E:\\Coding\\ CustomerList\\src\\customerlist\\CustomerList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            
            while((text = reader.readLine()) != null){
                System.out.println(text);
            }
            System.out.println("");
            Scanner Input = new Scanner(System.in);
            
            System.out.println("How Many Customers would you like to add?");
            newCustomers = Input.nextInt();
            
            
            if(newCustomers > 0){
                for(int i = 0 ; i <= newCustomers ; i++){
                    i = i+1;
                    System.out.println("What is Customer " + curCustomer  + "'s name?");
                    name = Input.next();
                    
                    System.out.println("What is Customer " + curCustomer + "'s address?");
                    String customerAddress = Input.next();
                    address = customerAddress.replace("-", " ");
                    
                    System.out.println("What is Customer " + curCustomer  + "'s city of Residence?");
                    city = Input.next();
                    
                    System.out.println("What is Customer " + curCustomer  + "'s province of Residence?");
                    province = Input.next();
                    
                    System.out.println("What is Customer " + curCustomer  + "'s Postal Code?");
                    String customerPostalCode = Input.next();
                    postalCode = customerPostalCode.replace("-", " ");
                    
                   String firstHalf = postalCode.substring(0, postalCode.indexOf(" "));
                   String secondHalf = postalCode.substring(postalCode.indexOf(" "), postalCode.length());
                   secondHalf = secondHalf.trim();
                   
                   if(Character.isLetter(firstHalf.charAt(0)) == true && Character.isDigit(firstHalf.charAt(1)) == true && Character.isLetter(firstHalf.charAt(2)) == true && Character.isDigit(secondHalf.charAt(0)) == true && Character.isLetter(secondHalf.charAt(1)) == true && Character.isDigit(secondHalf.charAt(2)) == true){
                           System.out.println("Thats Vaild");
                           valid = true;
                    }  
                   
                   if(valid == true){
                    System.out.println("Writing...");
                    writer.newLine();
                    writer.write(name + "  " + address + "  " + city + "  " + province + "  " + postalCode);
                    writer.close();
                    System.out.println("Done!");
                   }
                    curCustomer += 1;
                    }
                }
        }
        catch(IOException ex){
            System.out.println("Could Not Find File");
        }
    }
    
}
