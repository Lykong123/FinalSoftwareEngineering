import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();
    public ContactList() {

    }
    //method to add contact
    public void addContact() {
        System.out.print("Input firstname: ");
        String firstname = sc.nextLine();
        System.out.print("Input lastname: ");
        String lastname = sc.nextLine();
        System.out.print("How many telephone number for a user? :");
        int numberOfTel = Integer.parseInt(sc.nextLine());
        ArrayList<String> telephone = new ArrayList<>();
        ArrayList<String> purpose = new ArrayList<>();
        for (int i = 0; i < numberOfTel; i++) {
            System.out.print("Enter telephone number " + i + ":");
            String tel = sc.nextLine();
            System.out.print("Enter purpose of each telephone number: ");
            String purposes = sc.nextLine();
            telephone.add(tel);
            purpose.add(purposes);
        }
        Contact acontact = new Contact(firstname, lastname, telephone, purpose);
        contacts.add(acontact);
    }

    public void listContact() {
        System.out.println("List Contact");
        for (Contact c : contacts) {
            System.out.println(c.getFistname()+"\t"+ c.lastname+"\t"+c.getTelephone()+"\t"+c.getPurpose());
        }
        if (contacts.isEmpty()) {
            System.out.println("There isn't any contacts");
        }
    }

    public void updateContactByIndex() {
        System.out.print("Input index:");
        int index = Integer.parseInt(sc.nextLine());
        Contact updateContact = findByIndex(index);
        if (updateContact != null) {
            System.out.println("New update telephone number");
            System.out.print("Input update firstname:");
            String firstname = sc.nextLine();
            System.out.print("Input update lastname: ");
            String lastname = sc.nextLine();
            System.out.print("How many telephone do you want to updated? ");
            int numberOfTel = Integer.parseInt(sc.nextLine());
            ArrayList<String> telephone = new ArrayList<>();
            ArrayList<String> purpose = new ArrayList<>();
            for (int i = 0; i < numberOfTel; i++) {
                System.out.print("Enter each telephone number " + i + ": ");
                String tel = sc.nextLine();
                System.out.print("Enter purpose for each telephone number "+i+": ");
                String purposes = sc.nextLine();
                telephone.add(tel);
                purpose.add(purposes);
            }
            updateContact.setTelephone(telephone);
            updateContact.setFistname(firstname);
            updateContact.setLastname(lastname);
            updateContact.setPurpose(purpose);
        } else {
            System.out.println("There is no contact at " + index);
        }
    }
    public void deleteContact() {

        System.out.println("Enter index to delete:");
        int index = Integer.parseInt(sc.nextLine());
        Contact c = findByIndex(index);
        if (c != null) {
            System.out.println("The question at index " + index + " is deleted");
            contacts.remove(c);
        } else {
            System.out.println("there is no index at" + index);
        }
    }

    public Contact findByIndex(int i) {
        int j = 0;
        for (Contact c : contacts) {
            if (i == j) {
                return c;
            }
        }
        return null;
    }
    public void readMenu() {
        System.out.println("-------------Contact List--------------");
        System.out.println("1. Add contact (Phone number and name)");
        System.out.println("2. Update contact by index");
        System.out.println("3. Delete contact by index");
        System.out.println("4. List all contact");
        System.out.println("5. Exit the program");
        System.out.println("---------------------------------------");
    }
    public static void main(String[] args) {
        int opt;
        ContactList contactList = new ContactList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            contactList.readMenu();
            System.out.print("Input your option: ");
            opt = Integer.parseInt(sc.nextLine());
            switch (opt){
                case 1:
                    contactList.addContact();
                    break;
                case 2:
                    contactList.updateContactByIndex();
                    break;
                case 3:
                    contactList.deleteContact();
                    break;
                case 4:
                    contactList.listContact();
                    break;
                default:
                    System.out.println("Exit the program");
                    System.exit(0);
            }
        }
    }
}

class Contact {
    String fistname;
    String lastname;
    ArrayList<String> telephone = new ArrayList<>();
    ArrayList<String> purpose = new ArrayList<>();

    public Contact(String fistname, String lastname, ArrayList<String> telephone, ArrayList<String> purpose) {
        this.fistname = fistname;
        this.lastname = lastname;
        //set condition for telephone
        //a user can only have 2 to 4 telephone number
        if(telephone.size()>=2 && telephone.size()<=4){
            this.telephone = telephone;
            this.purpose = purpose;
        }
        else{
            System.out.print("Exceed range telephone number and purpose");
        }
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTelephone(ArrayList<String> telephone) {
        this.telephone = telephone;
    }

    public String getFistname() {
        return fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public ArrayList<String> getTelephone() {
        return telephone;
    }

    public ArrayList<String> getPurpose() {
        return purpose;
    }

    public void setPurpose(ArrayList<String> purpose) {
        this.purpose = purpose;
    }
}