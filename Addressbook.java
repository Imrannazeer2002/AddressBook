package Github;

import java.util.ArrayList;
import java.util.Scanner;

public class Addressbook {
    static ArrayList<ContactAddress> contacts =new ArrayList<>();
    static Scanner input = new Scanner(System.in);
       

    public static void addContact(){
        System.out.println("Enter Name: ");
        String name = input.next();
        System.out.println("Enter address: ");
        String address = input.next();
        System.out.println("Enter phone number: ");
        String phone = input.next();
        System.out.println("Enter email: ");
        String email=input.next();
        ContactAddress c= new ContactAddress(name,address,phone,email);
        contacts.add(c);
        System.out.println("Contact added successfully!");
    }
    
    public static void viewContacts(){
        if(contacts.isEmpty()){
            System.out.println("No contacts found");
            return;
        }
        for(int i=0;i<contacts.size();i++){
            System.out.println("contact " +(i+1)+":");
            System.out.println(contacts.get(i));
        }
    }

    public static void  searchContact(){
        System.out.print("Enter name to search: ");
        String name = input.next();
        boolean found = false;
        for(ContactAddress c : contacts) {
            if(c.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact details:");
                System.out.println(c);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Contact not found!");
        } 
    }
    public static void deleteContact(){
        System.out.println("Enter name to delete: ");
        String name = input.next();
        boolean found =false;
        for(int i=0;i<contacts.size(); i++){
            if(contacts.get(i).getName().equalsIgnoreCase(name)){
                contacts.remove(i);
                System.out.println("Contact deleted successfully!");
                found = true;
                break;
            }
        }
        if(! found){
            System.out.println("Contact not found!");
        }
    }
    public static void displayMenu() {
        int choice;
        while(true) {
            
        
            System.out.println("ADDRESS BOOK MENU");
            System.out.println("1.Add Contact");
            System.out.println("2.View Contacts");
            System.out.println("3.Search Contact");
            System.out.println("4.Delete Contact");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");
            choice=input.nextInt();
    
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Address Book");
                    break;           
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
public static void main(String args[]){
    displayMenu();
  }
}
class ContactAddress{
    private String name;
    private String address;
    private String phone;
    private String email;

    public ContactAddress(String name,String address, String phone,String email){
        this.name =name;
        this.address = address;
        this.phone = phone;
        this.email =email;
    }
    public String getName() {
        return name;
    }
    public String getaddress() {
        return address;
    }
    public String getphone() {
        return phone;
    }
    public String getemail() {
        return email;
    }
    public String toString(){
        return "Name: "+name+" Address: "+address+" Phone: "+phone+" Email:"+email;
    }

}


