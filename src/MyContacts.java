import  java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class MyContacts {
    ArrayList<Person> arrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addContact()
    {
        Person person = new Person();
        System.out.println("You have chosen to add a new contact: ");
        System.out.println("Please enter the name of the Person.");
        System.out.print("First Name: ");
        person.setFirst_Name(sc.next());
        System.out.print("Last Name: ");
        person.setLast_Name(sc.next());
        System.out.print("Contact Number: ");
        person.setArr(sc.nextLong());
        int t=4;



        while(t>0)
        {
            System.out.println("Would you like to add another contact number? (y/n): ");
            String s = sc.next();
            if (s.equals("y")) {
                System.out.println("Contact Number: ");
                person.setArr(sc.nextLong());
            } else if (s.equals("n")) {
                break;
            } else {
                System.out.println("Enter only y(for yes) or n(for no).");
            }
            t--;
        }



        while(true) {
            System.out.println("Would you like to add email address? (y/n):");
            String s2 = sc.next();
            if (s2.equals("y")) {
                System.out.print("Email Address: ");
                person.setEmail_ID(sc.next());
                break;
            } else if(s2.equals("n")) {
                break;
            }
            else
            {
                System.out.println("Enter only y(for yes) or n(for no).");
            }
        }

        arrayList.add(person);
    }
    public void viewContacts()
    {
        System.out.println("---Here are all your contacts---");
        for(int i=0;i<arrayList.size();i++)
        {
            System.out.println("-------- * -------- * -------- * --------");
            System.out.print(i+1+". ");
            System.out.print("Name: ");
            System.out.println(arrayList.get(i).getFirst_Name()+" "+arrayList.get(i).getLast_Name());
            int l=0;
            if(arrayList.get(i).getArr()[l] != 0 && arrayList.get(i).getArr()[l+1] == 0)
            {
                System.out.print("   Contact: ");
                checkNullContact(i);
            }
            else if(arrayList.get(i).getArr()[l] != 0 && arrayList.get(i).getArr()[l+1] != 0)
            {
                System.out.print("   Contact(s): ");
                checkNullContact(i);
            }
            System.out.print("   Emails: ");
            System.out.println(arrayList.get(i).getEmail_ID());
            System.out.println("-------- * -------- * -------- * --------");
        }
    }

    private void checkNullContact(int i) {
        for(int k=0;k<arrayList.get(i).getArr().length; k++)
        {
            if (arrayList.get(i).getArr()[k] != 0)
            {
                System.out.print(arrayList.get(i).getArr()[k]+" ");
            }                }
        System.out.println();
    }

    public void searchContact()
    {
        System.out.println("You could search for a contact from their first names:  ");
        String str = sc.next();
        str = str.toLowerCase();
        int c=0;
        for(int j=0; j<arrayList.size(); j++) {
            String str2 = arrayList.get(j).getFirst_Name();
            str2 = str2.toLowerCase();
            if (str.equals(str2))
            {
                System.out.println("1 match found!");
                System.out.println("-------- * -------- * -------- * --------");
                System.out.print("Name:");
                System.out.println(" "+arrayList.get(j).getFirst_Name()+" "+arrayList.get(j).getLast_Name());
                int l=0;
                if(arrayList.get(j).getArr()[l] != 0 && arrayList.get(j).getArr()[l+1] == 0)
                {
                    System.out.print("Contact: ");
                    checkNullContact(j);
                }
                else if(arrayList.get(j).getArr()[l] != 0 && arrayList.get(j).getArr()[l+1] != 0)
                {
                    System.out.print("Contact(s): ");
                    checkNullContact(j);
                }
                System.out.print("Emails: ");
                System.out.println(arrayList.get(j).getEmail_ID());
                c=1;
            }
        }
        if(c==0)
        {
            System.out.println("NO RESULTS FOUND!");
        }
    }
    public void delContact()
    {
        viewContacts();
        System.out.println("Press the number against the contact to delete it: ");
        int i = sc.nextInt();
        String name = arrayList.get(i-1).getFirst_Name() + " " + arrayList.get(i-1).getLast_Name();
        arrayList.remove(i-1);
        System.out.println(name + "'s contact deleted from list!");
    }

}




class MyContacts_Main
{
    public static void main(String[] args) {

        int i = 0;
        MyContacts obj = new MyContacts();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Sarvendra's contact list manager application :)");
            System.out.println("Press 1 to add a new contact.");
            System.out.println("Press 2 to view all contacts.");
            System.out.println("Press 3 to search for a contact.");
            System.out.println("Press 4 to delete a contact.");
            System.out.println("Press 5 to exit program.");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.addContact();
                    break;
                case 2:
                    obj.viewContacts();
                    break;
                case 3:
                    obj.searchContact();
                    break;
                case 4:
                    obj.delContact();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct option.");
            }
        }
    }
}