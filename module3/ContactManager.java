
import java.util.ArrayList;
import java.util.HashMap;

public class ContactManager
 {
     public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Cristina Terry", new Contact("Cristina Terry", "+1 999 333 0099"));
        contacts.put("Dallas Ferney", new Contact("Dallas Ferney", "+1 999 888 9090"));
        contacts.put("Maria Lovelace", new Contact("Maria Lovelace", "+1 88 555 99"));
        
        // Step 5: look up a contact 
        System.out.println("Contact:");

        printContact(contacts,"Cristina Terry");
        printContact(contacts, "Pedro");
        System.out.println();
        System.out.println("");

    
        // System.out.println("Contact List:");
        // for(Contact contact: contacts.values()){
        //     System.out.println(contact);
        //}

        printContactListOrdered(contacts);
    } 

    public static void printContact(HashMap<String,Contact> contacts, String keyName){
        Contact contactInfo = contacts.get(keyName);
        if(contactInfo == null){
            System.out.println(String.format("Contact not found for %s", keyName));
        }else{
            System.out.println(contactInfo);
        }
    }
    public static void printContactListOrdered(HashMap<String,Contact> contacts){

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  
        
        System.out.println("=== Contacts List===");
        for(Contact contact : sorted){
            System.out.println(contact);
        }

    }   

}


