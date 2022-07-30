/* Your name: Deyora Perera
     Course Code : ICS3U
     Assignment Title: Arrays Assignment
     Date Completed : Dec 6, 2021
     Program Description: Phone Book Objects & Methods
*/
import java.io.*;//importing java.io*
class MyPhoneBook { //phone book object
 
  static int numEntries; //global variables, count number of entries
 static  String [][] contactFound;
 
  
   static String [][]data = new String [100][5];
  
   public MyPhoneBook () //constructor
   {
   
  numEntries = 0; //tracking number of entries

   } // PhoneBook constructor

 
   public void add (String first, String last, String phoneNumber,String email, String address) //add method
   {
      
 //assigning variables name to position in array using numEntries and column number
data [numEntries][0] = first;
data [numEntries][1] = last ;
data [numEntries][2] = phoneNumber;
data [numEntries][3] = email;
data [numEntries][4] = address;

  numEntries++; //updater
   } // add method
  public String edit (String first, String last, String phoneNumber,String email, String address)//edit method
{
   
   boolean removed = remove(first,last); //boolean variable removed equals the remove method
   if (removed == true) //if remove equals true
   {

  add(first, last, phoneNumber, email, address); //using the add method to add new info
  
   
 return data [numEntries][1] + " "+  data [numEntries][2] + " " + data[numEntries][3] + " " + data[numEntries][4]; //returning all the data
      
   }
  else //if return is false (if the contact is not in the data.txt file)
  {
    return null; //returning nothing
  }  
}


  
static String [][] viewAll () //viewall method for returning array
{

   return data; //returns the pointer to the array DATA

 }
static  int entry (int numEntries)//entry method for returning number of entries
{
  return numEntries;//returns the numEntries number
}


//public void viewCount()

  int  i=0; //intializing variable i
  int j=0; //initializing variable j
   String [][] lookUp (String first,String last, String option) //lookUp method used to look up names
   {
  String [][]dataCopy2 = new String [100][5]; // creating dataCopy2 array
   if (option.equals("1")) //if user chose option 1
   {
for (int cnt = 0 ; cnt< numEntries ; cnt++) //looping through contacts
  { 
  
   if (first.equals (data [cnt][0])) //if first name user entered matches one in the data.txt file
      { 
      
      //making the dataCopy2 entries equals to the data entries (essentially copying the matches into the dataCopy2 array)
       dataCopy2[i][0] = data[cnt][0];
       dataCopy2[i][1] = data[cnt][1];
       dataCopy2[i][2] = data[cnt][2];
       dataCopy2[i][3] = data[cnt][3];
       dataCopy2[i][4] = data[cnt][4];
       i++; //updater


     
      }   
    
     
  }
   }
  
  else if (option.equals("2")) //if user chooses option 2
   {
for (int cnt1 = 0 ; cnt1< numEntries ; cnt1++) //looping through contacts
  { 
  
   if (last.equals (data [cnt1][1]) ) //if last name user entered matches a last name in the data.txt file
      {
        //making the dataCopy2 entries equals to the data entries (essentially copying the matches into the dataCopy2 array)
       dataCopy2[j][0] = data[cnt1][0] ;
       dataCopy2[j][1] = data[cnt1][1] ;
        dataCopy2[j][2] = data[cnt1][2] ;
        dataCopy2[j][3] = data[cnt1][3] ;
      dataCopy2[j][4] = data[cnt1][4] ;
      j++; //updater
      }     
     
  }
   }
  



   return dataCopy2; //returning dataCopy2
     
   } // lookUp method
 
   public boolean remove (String first, String last)//method to remove entry based on first and last name
   {
  for (int cnt = 0 ; cnt < numEntries ; cnt++)//for loop used to loop through entries
  {
      if (first.equals (data [cnt][0]) && last.equals(data[cnt][1])) //if variable first equals the cnt in first name column and cnt in last name column positions
      {
    // Delete the entry
    for (int cnt1 = cnt + 1 ; cnt++ < numEntries ; cnt1++)
    {
      //deleting each entry associated with matching first and last name 
 	   data [cnt1 - 1][0] = data [cnt1][0];
 	   data [cnt1 - 1][1] = data [cnt1][1];
     data [cnt1 - 1][2] = data [cnt1][2];
     data [cnt1 - 1][3] = data [cnt1][3];
     data [cnt1 - 1][4] = data [cnt1][4];
    }
    numEntries--; //subtract the number of entries by 1
       return true; //name matched
      }
  }
  return false; //no match for name found
   } // lookUp method
  
 
  public void write () //method used to write to the file
  {
     
  
    try //because the PrintWriter object can generate IO exceptions use the try and catch Blocks
       {
           PrintWriter output; //object to connect to a file
           output = new PrintWriter (new FileWriter ("data.txt")); //instantiate object
           for (int number = 0 ; number <numEntries; number ++) //for loop to loop throuhg entries
           {
               
               output.println(data[number][0]); //store entry first name
               output.println(data[number][1]); //store entry last name
               output.println(data[number][2]);//store entry phone number
               output.println(data[number][3]); //store entry email
               output.println(data[number][4]);//store entry address
 
           }
          
           output.close (); //you must close the object to save the data in the file
           //System.out.println ("data.txt file created with data!");
       }
       catch (Exception e)  ////need this line for try catch
       { //need this line for try catch
           System.out.println ("error");
       } //need this line for try catch
 
  
 }
 
 
 
 
public void read() //method used to read contents of the file
{
  
  
      
       try
       {
           BufferedReader input; //object to connect to file for read only
           input = new BufferedReader (new FileReader ("data.txt"));
           
           String line="";
          line = input.readLine (); //variable line is equal to input.readline()
           String first="", last = "", num="",email="",address=""; //initializing String variables
          
           while (line != null) // while the line doesnt equal null
           {
            
           first = line; //variable first equals line
           //variables last,num,email, and line equals input.readline();
           last = input.readLine(); 
           num = input.readLine();
           email=input.readLine();
           address = input.readLine();
           add(first,last,num,email,address); //using add method
           line = input.readLine ();
             
           }
        
           input.close (); //close the file
       }
       catch (Exception e)  //need this line for try catch
       { //need this line for try catch
           System.out.println ("error");
       } //need this line for try catch
  
 }
 
 
}

