/* Your name: Deyora Perera
     Course Code : ICS3U
     Assignment Title: Arrays Assignment
     Date Completed : Dec 6, 2021
     Program Description: Phone Book Objects & Methods
*/
import java.util.Scanner; //importing scanner
import java.io.*; //importing java.io

public class Main {
 MyPhoneBook pb = new MyPhoneBook (); //instantiate MyPhoneBook object
 static Scanner kb;           // a global variable
 
   public static void main (String[] args) 
   {
      
       
     
       kb = new Scanner (System.in); // kb equals new scanner
      String [][] dataCopy2 ; //dataCopy2
      //intializing variables to 0
      int i = 0;
      int j = 0;
      int g = 0;
      int y = 0;
       //String [][]blank = new String [100][5];
       MyPhoneBook pb = new MyPhoneBook (); //instantiate MyPhoneBook object
       String [][]dataCopy ; //did not need to instantiate, pointer storage only
       dataCopy = pb.viewAll ( ); //dataCopy equals the viewAll method
      
       
     
       int choice = 0; //variable for choice used in cases
       String first = "", last="", address =""
       ,option ="",num= "",email= ""; //initializing String variables

      
      
       int numEntries =0;//variable containing number of entries
       pb.read();//calling read method
       System.out.println ("Welcome to Deyora's greatest Phonebook!"); //outputting welcome message
      
       while (true) //to keep using the phone book
       {
           //Giving user options for using phone book with numbers to press
           System.out.println ("1) add new contact"); 
           System.out.println ("2) edit");
           System.out.println("3) look up");
           System.out.println("4) remove");
           System.out.println("5) exit");
           System.out.println("6) view all");
           System.out.print ("Please enter your choice (1-6):");
           choice = kb.nextInt ();
           kb.nextLine();//flush enter character
           if (choice <1 || choice > 6) //if variable choice is less than 1 and greater than 6
           {
               System.out.println ("Error, please try again!"); //outputting error message
           }
           else //if the previous if statement is false
           {
               switch (choice)//using switch because of it being a menu 
               {
                   case 1:
                      // System.out.println ("Add option");
                       System.out.print ("Enter first name:");//prompting user to enter first name
                       first = kb.nextLine(); //storing previous input in variable first
                       System.out.print("Enter last name: ");//prompting user for last name
                       last=kb.nextLine(); //storing previous input in variable last
                       System.out.print ("Enter phone number:"); //prompting user for phone number
                       num = kb.nextLine();//storing number in varible num
                       System.out.print("Enter email: ");//prompting user for email
                       email=kb.nextLine(); //storing email in variable email
                       System.out.print("Enter address: "); //prompting user for address
                       address = kb.nextLine();//storing address in variable address
                      System.out.println ("First name: " + first + " Last name: " + last + " Number: " +  num + " Email: "+ email + " Address: "+ address); //outputting user's first and last name, number email and address
                       pb.add (first,last,num,email,address);//calling phonebook and add method
                       break;
                
                  case 2:
                      System.out.println("Enter first name to edit: ");//prompting user to enter name
                      first = kb.nextLine();//saving name to variable first
                      System.out.println("Enter last name to edit");
                      last = kb.nextLine();
                      System.out.println("Enter new number");//prompting user to enter new number
                      num = kb.nextLine();//storing new number in variable num
                     System.out.println("Enter email");//asking user to enter email
                     email=kb.nextLine();//saving to variable email
                     System.out.println("Enter new address");
                     address = kb.nextLine();
                     pb.edit(first,last,num,email,address); //calling add method
                      break;
                  
                   case 3:
                       System.out.print("Enter name to look up, 1) first name, 2) last name");//giving user option to search from first or last name
                       // kb.nextLine();
                       option = kb.nextLine();//the chosen option is stored in variable option
                       int number3 = 0; // intializing variable number3
                       int number1 = pb.j; //variable number1 equals vriable j from phonebook
                       if (option.equals("1"))//if option equals 1
                       {
                        System.out.print("Enter first name: ");//ask user to enter their first name
                        first = kb.nextLine(); //storing user input to variable first
                       dataCopy2= pb.lookUp (first,last,option); //dataCopy2 equals lookUp method
                       number3 = pb.i; //number3 equals variable i from phonebook
                       y = i; //y equals i
                     for (i = i; i <number3; i++) //for loop to loop through matches
                     {
                  //outputting matches (contact user searched for)
                   System.out.println("First name: " + dataCopy2 [i][0] + "\nLast name: "+ dataCopy2[i][1] + "\nPhone Number: " + dataCopy2 [i][2] + "\nEmail " + dataCopy2[i][3] + "\nAddress: " + dataCopy2[i][4]);
                     
                       }
                       }
                       else if (option.equals("2"))//if option equals 2
                       {
                         System.out.println("Enter last name"); //asking user to enter their last name
                         last = kb.nextLine(); //storing user input in variable last
                          dataCopy2= pb.lookUp (first,last,option) ; //dataCopy2 equals lookUp method
                          number1 = pb.j; //number1 equals variable j from phonebook
                          g = j; //g equals j
                     for (j = j; j < number1; j++) //for loop for going through matches
                     {
                  //outputting matches (contact user searched for)
                   System.out.println("First name: " + dataCopy2 [j][0] + "\nLast name: "+ dataCopy2[j][1] + "\nPhone Number: " + dataCopy2 [j][2] + "\nEmail " + dataCopy2[j][3] + "\nAddress: " + dataCopy2[j][4]);
                     
                       }
                       
                       }
                        if (g ==  j && y == i)//g equals j and y equals i
                       {
                         System.out.println("Not found");//outputting not found (meaning the contact was not found in the data)
                       } 
                       
                       
                       break;
                   case 4:
                       System.out.println("Enter first name to remove: ");//prompting user to enter first name
                       first = kb.nextLine();//storing name in variable first
                       System.out.println("Enter last name to choose to remove");//prompting user to enter last name
                       last = kb.nextLine();//sotring last name in variable last
                       pb.remove(first,last);//calling remove method
                       break;
               
                 case 5:
                       System.out.println ("Exiting program"); //outputting exiting program message
                   
                       pb.write(); //calling write method to write to file
                       System.exit(0); //exiting
                       break;
                    

                case 6:
                     int number4 = pb.numEntries; //variable number4 equals method numEntries
                     for (int cnt = 0; cnt < number4; cnt++) //for loop to go through each contact in the data.txt file
                     {
                  //outputting all the contacts
                   System.out.println("First name: " + dataCopy [cnt][0] + "\nLast name: "+ dataCopy[cnt][1] + "\nPhone Number: " + dataCopy [cnt][2] + "\nEmail " + dataCopy[cnt][3] + "\nAddress: " + dataCopy[cnt][4]);
                          }
      
                     break;
                     
                      
                      
               }
           }
       }
 
   }

}