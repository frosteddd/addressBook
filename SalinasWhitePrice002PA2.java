/**
 *@#SalinasWhitePrice002PA2.java
 *@author Jonathan Salinas && Cameron White-Price
 *@version 1.00 2023/04/05 06:36:10PM
 *
 * 
 *PROGRAM PURPOSE: This program is made to store a users address books 
 * for their friends, family, and work.
 * 
 * by Jonathan Salinas
 * 
 */

import java.util.Scanner; //Class to handle keyboard entries by Jonathan Salinas

public class SalinasWhitePrice002PA2 //main method by Jonathan Salinas
{
  /**
   * 
   *PURPOSE: This method asks the user if they would like to begin entering addresses.
 * Depending on the users input, the program may continue or terminate. If the user selects yes, the 
 * program will then ask the user which address book type they would like to use. Either will contain 
 * the same information, however, one will be titled Personal and the other would be titled Business. 
 * After the user makes their choice, they will be asked their name, the addressee's name, 
 * street address, and phone number. The user will then be asked what their relationship to the addressee 
 * is. Afterwards, the user would be asked if they would like to add another addressee. If their answer 
 * is yes, the program will ask for the next addressee's name, address, and phone number until the users
 * answer is no. Once the answer is no, the user will be shown the information they input. The user would
 * then be asked if they would like to create another address book. If the user says yes, the program will
 * then ask the same series of questions until the user answers 'no' to creating another address book.
 * 
 * by Jonathan Salinas 
 * 
 */
  //Field Variables
  private static Scanner input = new Scanner(System.in); //initialize Scanner by Jonathan Salinas
  private static StringBuilder phoneFormatted; //initialize StringBuilder by Jonathan Salinas
  private static char correct = ' '; //initialize char by Jonathan Salinas
  private static String addressBook = ""; //initialize String by Jonathan Salinas
  private static String addressee = ""; //initialize String by Jonathan Salinas
  private static String family = String.format("%nFAMILY%n"); //initialize String object by Jonathan Salinas
  private static String friends = String.format("%nFRIENDS%n"); //initialize String object by Jonathan Salinas
  private static int bookType = 0; //initialize Int by Jonathan Salinas
  private static String street = ""; //initialize String by Jonathan Salinas
  private static String cityStateZip = ""; //initialize String by Jonathan Salinas
  private static String work = ""; //initialize String by Jonathan Salinas
  private static boolean validInteger = true; //initialize Boolean by Jonathan Salinas
    
    public static void main(String[] args)
  {
    char another = ' '; //initialize char by Jonathan Salinas
    char anotherAddress = ' '; //initialize char by Jonathan Salinas
    String ownerAddrBk = ""; //initialize String by Jonathan Salinas
    String phone = ""; //initialize String by Jonathan Salinas
    int relationship = 0; //initialize Int by Jonathan Salinas
    
     System.out.printf("%nBegin entering addresses? \'Y\' or \'N\': "); //Asks the user if they would like to begin 
                                                                                                            //entering addresses. by Jonathan Salinas
     
     another = input.nextLine().charAt(0); //Reads another by Jonathan Salinas      
    
    if (Character.toUpperCase(another) != 'Y') //If 'another' is not 'Y' then. by Jonathan Salinas
    {
      System.out.printf("%nExiting program.  "); //Exiting progrma prompt by Jonathan Salinas
    }//Exits program if user input is not 'Y' by Jonathan Salinas
    
    while (Character.toUpperCase(another) == 'Y') //While 'another' is 'Y' then. by Jonathan Salinas
    {
        setAddressBook(); //call setAddressBook by Jonathan Salinas
        setOwner(); //call setOwner by Jonathan Salinas
        do
        {
          setAddressee(); //call setAddressee by Jonathan Salinas
          setStreet(); //call setStreet by Jonathan Salinas
          setCityStateZip(); //call setCityStateZip by Jonathan Salinas
          setPhone(); //call setPhone by Jonathan Salinas
          setRelationship(); //call setRelationship by Jonathan Salinas
          
          System.out.printf("%nDo you want to enter another address? "
                              +"\'Y\' or \'N\': ", anotherAddress); //Asks the user if they would like to enter another address
                                                                                                                                              //by Jonathan Salinas
          anotherAddress = input.nextLine().charAt(0); //Reads anotherAddress by Jonathan Salinas
        }//Ends do-while of addressee's contact info prompts. by Jonathan Salinas
        while (Character.toUpperCase(anotherAddress)== 'Y'); //While 'anotherAddress is 'Y' then. 
                                                                                                  //by Jonathan Salinas
        printAddressBook(); //calls printAddressBook by Jonathan Salinas
            
            System.out.printf("%nDo you want to create another address book? "
                                +"\'Y\' or \'N\': "); //Asks the user if they would like to create another address book 
                                                           //by Jonathan Salinas
            
            another = input.nextLine().charAt(0); //Reads another by Jonathan Salinas
        }//END while by Jonathan Salinas
    }//End of Main by Jonathan Salinas
  
  
//========================================================================================
//========================================================================================  
  
  public static void setAddressBook() 
  {
    do
      {
//Prompt 2 
        
        System.out.printf("%nAddress Book Type:"
                            + "%n%n1.Personal"
                            +"%n2. Business"
                            +"%n%nChoose from above the address book type:  "); //Asks which address book type the 
                                                                                                   //user would like to create. by Jonathan Salinas
        validInteger = input.hasNextInt(); //read boolean into validInteger by Jonathan Salinas                                               
        bookType = validateInteger(); //call validateInteger to bookType by Jonathan Salinas
        input.nextLine();
        switch(bookType) //prints the vaildation prompts for bookType by Jonathan Salinas
        {  
          case 1:
            System.out.printf("%nYou entered %d for %s. Is this correct? "
                                +"\'Y\' or \'N\': ", bookType, "Personal"); //Double checks that the user input the correct 
                                                                                                //information. by Jonathan Salinas
            correct = input.nextLine().charAt(0); //Reads correct by Jonathan Salinas                                                      
            break;
          case 2:
            System.out.printf("%nYou entered %d for %s. Is this correct? "
                                +"\'Y\' or \'N\': ", bookType, "Business"); //Double checks that the user input the correct 
                                                                                                //information. by Jonathan Salinas
            correct = input.nextLine().charAt(0); //Reads correct by Jonathan Salinas                                                     
            break;
            
          default:
            System.out.printf("%nYou entered %d which is the wrong address "
                                + "book type. Try again.%n", bookType); //Instructs the user to try again as their input 
                                                                                                                     //was invalid. by Jonathan Salinas
            
        }//End bookType validation prompts by Jonathan Salinas
      }//Ends do-while confirming the address book type by Jonathan Salinas
    while (Character.toUpperCase(correct)!= 'Y'); 
       addressBook = String.format("%n%n%S ADDRESS BOOK FOR ",
                                    bookType == 1 ? "personal" : "business"); //assign formatted string for address book
                                                                                               //title to addressBook field. by Jonathan Salinas
  }//END setAddressBook() by Jonathan Salinas
  
//========================================================================================    
//========================================================================================  
  
  public static void setOwner() 
  {
    String ownerAddrBk = ""; //declaring ownerAddrBk by Jonathan Salinas
    do
      {
       
//Prompt 3 
        System.out.printf("%nEnter your name:  "); //Asks the user their name. by Jonathan Salinas
        ownerAddrBk = input.nextLine(); //Reads ownerAddrBk by Jonathan Salinas
        
        System.out.printf("%nYou entered %s. Is this correct? " //Double checks that the user input the correct
                            +"\'Y\' or \'N\': ", ownerAddrBk);                                 //information. by Jonathan Salinas
        
        correct = input.nextLine().charAt(0); //Reads correct by Jonathan Salinas
      }//Ends do-while confirming users name by Jonathan Salinas
    while (Character.toUpperCase(correct)!= 'Y'); //while 'correct' is 'Y' then. by Jonathan Salinas
      addressBook += String.format("%S%n", ownerAddrBk); //assigning ownerAddrBk to addressBook 
                                                                                                 //by Jonathan Salinas
  }//END setOwner() by Jonathan Salinas
  
//========================================================================================    
//========================================================================================  
  
  public static void setAddressee() 
  {
     do
        {
//Prompt 4 
          System.out.printf("%nEnter the name of the addressee:  "); //Asks the user the name of the addressee
                                                                                                           //by Jonathan Salinas
          addressee = input.nextLine(); //Reads addressee by Jonathan Salinas
          
          System.out.printf("%nYou entered %s. Is this correct? "  
                              +"\'Y\' or \'N\': ", addressee); //Double checks that the user input the correct information.
                                                                           // by Jonathan Salinas
          correct = input.nextLine().charAt(0); //Reads correct by Jonathan Salinas
        }//Ends do-while confirming name of addressee by Cameron White-Price
     while (Character.toUpperCase(correct)!= 'Y'); //while 'correct' is 'y' then. by Cameron White-Price
  }//END setAddressee() by Cameron White-Price
  
//========================================================================================    
//========================================================================================  
  
  public static void setStreet() 
  {
    do 
        {
//Prompt 5
          System.out.printf("%nEnter the street for %s:  ", addressee); //Asks the user for the street address 
                                                                                                              //by Cameron White-Price
          street = input.nextLine(); //Reads street by Cameron White-Price                           
          
          System.out.printf("%nYou entered %s. Is this correct? " 
                              +"\'Y\' or \'N\': ", street); //Prompts if this is correct by Cameron White-Price 
          correct = input.nextLine().charAt(0); //Reads correct by Cameron White-Price
        }//Ends do-while confirming street address by Cameron White-Price
    while (Character.toUpperCase(correct)!= 'Y');
  }//END setStreet() by Cameron White-Price
  
//========================================================================================    
//========================================================================================  
  
  public static void setCityStateZip()
  {
    do 
        {
//Prompt 6 by Cameron White-Price
          System.out.printf("%nEnter the city, state and zip code for %s. " //Asks the user for the city, state, and 
                              +"in the correct format: ", addressee); //zip code for the addressee. by Cameron White-Price
          cityStateZip = input.nextLine(); //Reads cityStateZip by Cameron White-Price
          
          System.out.printf("%nYou entered %s. Is this correct? " //Checks that the user input the correct 
                              +"\'Y\' or \'N\': ", cityStateZip);                       //information by Cameron White-Price                                                        
          correct = input.nextLine().charAt(0); //Reads correct by Cameron White-Price
        }//Ends do-while confirming city, state, and zip by Cameron White-Price
    while (Character.toUpperCase(correct)!= 'Y'); 
  }//END setCityStateZip() by Cameron White-Price
  
//========================================================================================    
//========================================================================================  
  
  public static void setPhone() //Start of setPhone by Cameron White-Price
  {
    String phone = ""; //initializes phone as a string by Cameron White-Price
    do
        {
          //Prompt 7 by Cameron White-Price
          System.out.printf("%nEnter the 10 digit phone number for %s "
                              +"without dashes or parentheses: ", addressee); //Asks the user for the phone number 
                                                                                                             //by Cameron White-Price
          phone = input.nextLine(); //Reads phone by Cameron White-Price                                                                     
          phoneFormatted = new StringBuilder(phone); //Initializes StringBuilder by Cameron White-Price
          phoneFormatted.insert(3, '-'); //Inserts a dash at the 3rd space by Cameron White-Price
          phoneFormatted.insert(7, '-'); //Inserts a dash at the 7th space by Cameron White-Price
          
          System.out.printf("%nYou entered %s. Is this correct? " 
                              +"\'Y\' or \'N\': ", phoneFormatted); //Double checks that user input the correct information. 
                                                                                                                                       //by Cameron White-Price
          correct = input.nextLine().charAt(0); //Reads correct by Cameron White-Price
        }//Ends do-while confirming phone number and adding approriately placed dashes 
                                                                                                    //by Cameron White-Price
    while (Character.toUpperCase(correct)!= 'Y');
  }//END setPhone() by Cameron White-Price
  
//========================================================================================    
//========================================================================================  
  
  public static void setRelationship() //start of setRelationship  by Cameron White-Price
  {
    int relationship = 0; //intializes relationship to 0 by Cameron White-Price
    do
        {
//Prompt 8  by Cameron White-Price
          System.out.printf("%nRelationship of the addressee:  "
                              +"%n%n1. Family"
                              +"%n2. Friends"
                              +"%n3. Work"
                              
                              +"%n%nChoose from the above:  "); //Asks to choose from the relationships above 
                                                                                                                          //by Cameron White-Price
          validInteger = input.hasNextInt(); //Sets validInteger to the next input by Cameron White-Price
          relationship = validateInteger(); //Sets relationship equal to validateInteger by Cameron White-Price
          input.nextLine();
          switch(relationship) //prints the validation prompts for relationship by Cameron White-Price
          {
            case 1:
              System.out.printf("%nYou entered %d for %s. Is this "
                                  + "correct? \'Y\' or \'N\': ", relationship, relationship == 1 ?
                                  "Family" : "Friends"); //Double checks that the user input the correct information. 
                                                                                                                             //by Cameron White-Price
            correct = input.nextLine().charAt(0); //Reads correct by Cameron White-Price
            break; //break statement by Cameron White-Price
            case 2:
              System.out.printf("%nYou entered %d for %s. Is this "
                                  + "correct? \'Y\' or \'N\': ", relationship, relationship == 1 ?
                                  "Family" : "Friends"); //Double checks that the user input the correct information. 
                                                                                                                             //by Cameron White-Price
            correct = input.nextLine().charAt(0); //Reads correct by Cameron White-Price
            break; //break statement by Cameron White-Price
            case 3:
              System.out.printf("%nYou entered %d for work. Is this correct? "
                                  +"\'Y\' or \'N\': ", relationship); //Double checks that the user input the correct information. 
                                                                                                                                          //by Cameron White-Price
              correct = input.nextLine().charAt(0); //Reads correct by Cameron White-Price
              break; //break statement by Cameron White-Price
            default: //initializes to default value by Cameron White-Price
              System.out.printf("%nYou entered %d which is incorrect. " 
                                  +"Try again.%n", relationship); //Instructs the user to try again as their input was invalid. 
                                                                                                                                         //by Cameron White-Price
              correct = 'n'; //Initializes correct to 'n' by Cameron White-Price
          }//ends relationship validation prompts by Cameron White-Price
           
        }//ends do-while confirming relationship of addressee by Cameron White-Price
    while (Character.toUpperCase(correct)!= 'Y'); 
    switch(relationship) //switch statement to relationship by Cameron White-Price
          {
            case 1:
              family += formatAddressee(); 
              
              break;                                                                 
            case 2:
              friends += formatAddressee();
              
              break;                                                                                                                  
            case 3:
              work += formatAddressee();
              
              break;                                                                                                              
          }//Ends relationship validation prompts by Cameron White-Price
  }//END setRelationship() by Cameron White-Price
  
//========================================================================================    
//========================================================================================  
  
  public static String formatAddressee() //Start of formatAddressee by Cameron White-Price
  {
    return String.format("%nAddressee: %s"
                                      +"%nStreet: %s"
                                      +"%nCity, State Zip: %s"
                                      +"%nPhone: %s%n", addressee, street, cityStateZip,
                                    phoneFormatted); //Formats the output for Addressee, Street, City, State, Zip, Phone 
                                                                                                                                    //by Cameron White-Price
  }//END formatAddressee() by Cameron White-Price
  
//========================================================================================    
//========================================================================================  
  
  public static void printAddressBook() //Start of printAddressBook by Cameron White-Price
  {
    switch(bookType) //Prints the validation prompts for bookType by Cameron White-Price
      {
        case 1:
          System.out.printf("%s"
                              +"%s"
                              +"%s", addressBook, family, friends); //Displays the book types family and friends. 
                                                                                                                        //by Cameron White-Price
          break;
          
        case 2:
          System.out.printf("%s"
                              +"%s", addressBook, work); //Displays the book type work. by Cameron White-Price
          break;
      }//Ends bookType validation prompts by Cameron White-Price
  }//END printAddressBook() by Cameron White-Price
  
//========================================================================================    
//========================================================================================  
  
  public static int validateInteger() //start of validInteger by Cameron White-Price
  {
    while(!validInteger) //while loop for valid Integer by Cameron White-Price
    {
      input.nextLine();
      System.out.printf("%nNot an integer! Enter a valid integer:  "); //Not an integer prompt 
                                                                                                            //by Cameron White-Price
      validInteger = input.hasNextInt(); // Assigning validInteger using input.hasNextInt();  
                                                                                                     //by Cameron White-Price
    }
    return input.nextInt(); //returning input by Cameron White-Price
  }//END validateInteger() by Cameron White-Price
//========================================================================================    
  
  
}//End of Class by Cameron White-Price

//========================================================================================

/**
Begin entering addresses? 'Y' or 'N': n
 
Exiting program.   
Begin entering addresses? 'Y' or 'N': y
 
Address Book Type: 
 
1.Personal 
2. Business 
 
Choose from above the address book type:  3
 
You entered 3 which is the wrong address book type. Try again. 
 
Address Book Type: 
 
1.Personal 
2. Business 
 
Choose from above the address book type:  l
 
Not an integer! Enter a valid integer:  1
 
You entered 1 for Personal. Is this correct? 'Y' or 'N': y
 
Enter your name:  James Kork
 
You entered James Kork. Is this correct? 'Y' or 'N': n
 
Enter your name:  James Kirk
 
You entered James Kirk. Is this correct? 'Y' or 'N': y
 
Enter the name of the addressee:  Jorge Kirk
 
You entered Jorge Kirk. Is this correct? 'Y' or 'N': n
 
Enter the name of the addressee:  George Kirk
 
You entered George Kirk. Is this correct? 'Y' or 'N': y
 
Enter the street for George Kirk:  123 Main
 
You entered 123 Main. Is this correct? 'Y' or 'N': n
 
Enter the street for George Kirk:  718 Enterprise Cir
 
You entered 718 Enterprise Cir. Is this correct? 'Y' or 'N': y
 
Enter the city, state and zip code for George Kirk. in the correct format: Riverdale, CA
 
You entered Riverdale, CA. Is this correct? 'Y' or 'N': n
 
Enter the city, state and zip code for George Kirk. in the correct format: Riverside, IA 52327
 
You entered Riverside, IA 52327. Is this correct? 'Y' or 'N': y
 
Enter the 10 digit phone number for George Kirk without dashes or parentheses: 7197890123
 
You entered 719-789-0123. Is this correct? 'Y' or 'N': n
 
Enter the 10 digit phone number for George Kirk without dashes or parentheses: 3197890123
 
You entered 319-789-0123. Is this correct? 'Y' or 'N': y
 
Relationship of the addressee:   
 
1. Family 
2. Friends 
3. Work 
 
Choose from the above:  4
 
You entered 4 which is incorrect. Try again. 
 
Relationship of the addressee:   
 
1. Family 
2. Friends 
3. Work 
 
Choose from the above:  2
 
You entered 2 for Friends. Is this correct? 'Y' or 'N': n
 
Relationship of the addressee:   
 
1. Family 
2. Friends 
3. Work 
 
Choose from the above:  1
 
You entered 1 for Family. Is this correct? 'Y' or 'N': y
 
Do you want to enter another address? 'Y' or 'N': y
 
Enter the name of the addressee:  Spock
 
You entered Spock. Is this correct? 'Y' or 'N': y
 
Enter the street for Spock:  15 Triple Moon
 
You entered 15 Triple Moon. Is this correct? 'Y' or 'N': y
 
Enter the city, state and zip code for Spock. in the correct format: Surak, Vulcan
 
You entered Surak, Vulcan. Is this correct? 'Y' or 'N': y
 
Enter the 10 digit phone number for Spock without dashes or parentheses: 4151234567
 
You entered 415-123-4567. Is this correct? 'Y' or 'N': y
 
Relationship of the addressee:   
 
1. Family 
2. Friends 
3. Work 
 
Choose from the above:  2
 
You entered 2 for Friends. Is this correct? 'Y' or 'N': y
 
Do you want to enter another address? 'Y' or 'N': n
 
 
PERSONAL ADDRESS BOOK FOR JAMES KIRK 
 
FAMILY 
 
Addressee: George Kirk 
Street: 718 Enterprise Cir 
City, State Zip: Riverside, IA 52327 
Phone: 319-789-0123 
 
FRIENDS 
 
Addressee: Spock 
Street: 15 Triple Moon 
City, State Zip: Surak, Vulcan 
Phone: 415-123-4567 
 
Do you want to create another address book? 'Y' or 'N': y
 
Address Book Type: 
 
1.Personal 
2. Business 
 
Choose from above the address book type:  2
 
You entered 2 for Business. Is this correct? 'Y' or 'N': y
 
Enter your name:  James Kirk
 
You entered James Kirk. Is this correct? 'Y' or 'N': y
 
Enter the name of the addressee:  Star Fleet Command
 
You entered Star Fleet Command. Is this correct? 'Y' or 'N': y
 
Enter the street for Star Fleet Command:  1 Star Fleet
 
You entered 1 Star Fleet. Is this correct? 'Y' or 'N': y
 
Enter the city, state and zip code for Star Fleet Command. in the correct format: Fort Baker, CA 98210
 
You entered Fort Baker, CA 98210. Is this correct? 'Y' or 'N': y
 
Enter the 10 digit phone number for Star Fleet Command without dashes or parentheses: 4158921519
 
You entered 415-892-1519. Is this correct? 'Y' or 'N': y
 
Relationship of the addressee:   
 
1. Family 
2. Friends 
3. Work 
 
Choose from the above:  3
 
You entered 3 for work. Is this correct? 'Y' or 'N': y
 
Do you want to enter another address? 'Y' or 'N': y
 
Enter the name of the addressee: Lt. Commander Montgomery Scott
 
You entered Lt. Commander Montgomery Scott. Is this correct? 'Y' or 'N': y
 
Enter the street for Lt. Commander Montgomery Scott:  5 Star Fleet #62
 
You entered 5 Star Fleet #62. Is this correct? 'Y' or 'N': y
 
Enter the city, state and zip code for Lt. Commander Montgomery Scott. in the correct format: Fort Baker, CA 98210
 
You entered Fort Baker, CA 98210. Is this correct? 'Y' or 'N': y
 
Enter the 10 digit phone number for Lt. Commander Montgomery Scott without dashes or parentheses: 4152345678
 
You entered 415-234-5678. Is this correct? 'Y' or 'N': y
 
Relationship of the addressee:   
 
1. Family 
2. Friends 
3. Work 
 
Choose from the above:  3
 
You entered 3 for work. Is this correct? 'Y' or 'N': y
 
Do you want to enter another address? 'Y' or 'N': n
 
 
BUSINESS ADDRESS BOOK FOR JAMES KIRK 
 
Addressee: Star Fleet Command 
Street: 1 Star Fleet 
City, State Zip: Fort Baker, CA 98210 
Phone: 415-892-1519 
 
Addressee: Lt. Commander Montgomery Scott 
Street: 5 Star Fleet #62 
City, State Zip: Fort Baker, CA 98210 
Phone: 415-234-5678 
 
Do you want to create another address book? 'Y' or 'N': n

 */