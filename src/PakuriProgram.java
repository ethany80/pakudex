/*
This program allows users to store Pakuris, which are
magical creatures, in a Pakudex. This Pakudex also allows
them to sort their list of Pakuris, retrieve information
on them, and evolve them.
 */
import java.util.Scanner;

public class PakuriProgram
{
    /*
    main method
     */
    public static void main(String[] args)
    {
        /*
        scanner object created for user input,
        and int variables made for user inputted
        option and capacity of pakudex
         */
        Scanner scan = new Scanner(System.in);
        int userOption = 0, maxCap = 0, size = 0;
        boolean validInput = true;
        /*
        welcome message displayed and
        user prompted to enter pakudex
        capacity
         */
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        /*
        while loop checks for valid
        user input
         */
        while(validInput)
        {
            System.out.print("Enter max capacity of the Pakudex: ");
            /*
            if statement uses hasNextInt() as
            condition, which returns true if
            next inputted token in scanner is
            an integer
             */
            if (scan.hasNextInt())
            {
                maxCap = scan.nextInt();
                /*
                nested if statement checks that
                inputted value is a positive,
                non-zero integer
                 */
                if (maxCap > 0)
                {
                    validInput = false;
                }
                else
                {
                    System.out.println("Please enter a valid size.");
                }
            }
            else
            {
                System.out.println("Please enter a valid size.");
                scan.next();
            }
        }

        Pakudex pakudex = new Pakudex(maxCap);

        System.out.println("The Pakudex can hold " + maxCap + " species of Pakuri.\n");
        /*
        while loop allows user to continue
        using pakuri program until they
        choose to exit
         */
        while(true)
        {
            validInput = true;
            /*
            user enters their option;
            program checks validity of
            option through similar process
            as capacity input
             */
            while(validInput)
            {
                /*
                main menu (user options) displayed
                */
                System.out.print("Pakudex Main Menu\n" +
                        "-----------------\n" +
                        "1. List Pakuri\n" +
                        "2. Show Pakuri\n" +
                        "3. Add Pakuri\n" +
                        "4. Evolve Pakuri\n" +
                        "5. Sort Pakuri\n" +
                        "6. Exit\n\n" +
                        "What would you like to do? ");

                if (scan.hasNextInt())
                {
                    userOption = scan.nextInt();
                /*
                nested if statement checks that
                inputted value one of the 6 from
                the menu
                 */
                    if (userOption > 0 && userOption < 7)
                    {
                        validInput = false;
                    }
                    else
                    {
                        System.out.println("Unrecognized menu selection!\n");
                    }
                }
                else
                {
                    System.out.println("Unrecognized menu selection!\n");
                    scan.next();
                }
            }
            /*
            first option displays list
            of pakuris
             */
            if (userOption == 1)
            {
                /*
                if pakudex contains pakuris,
                species name string array is
                retrieved, and for loop is used
                to list out the existing pakuris
                 */
                if (pakudex.getSize() != 0)
                {
                    String[] arr = pakudex.getSpeciesArray();

                    System.out.println("Pakuri In Pakudex:");

                    for (int i = 0; i < arr.length; ++i)
                    {
                        System.out.println((i + 1) + ". " + arr[i]);
                    }
                    System.out.println();
                }
                /*
                if pakudex has a size of zero,
                it currently holds no pakuris
                and user is told so
                 */
                else
                {
                    System.out.println("No Pakuri in Pakudex yet!\n");
                }
            }
            /*
            second option allows user to
            show the name and stats of a
            chosen pakuri in the pakudex
             */
            else if (userOption == 2)
            {
                String name;
                /*
                user prompted to enter pakuri name
                 */
                System.out.print("Enter the name of the species to display: ");
                name = scan.next();
                /*
                reference variable points to
                returned stats array retrieved
                from getStats method
                 */
                int[] stats = pakudex.getStats(name);
                /*
                stats of chosen pakuri displayed
                 */
                if (stats != null)
                {
                    System.out.println("\nSpecies: " + name +
                                       "\nAttack: " + stats[0] +
                                       "\nDefense: " + stats[1] +
                                       "\nSpeed: " + stats[2]);
                    System.out.println();
                }
                else
                {
                    System.out.println("Error: No such Pakuri!\n");
                }
            }
            /*
            third option allows user to
            add pakuri to the pakudex
             */
            else if (userOption == 3)
            {
                String name;
                boolean success;
                /*
                if the capacity of the pakudex is
                reached, no pakuri is stored and
                user is given error message
                */
                if (size >= maxCap)
                {
                    System.out.println("Error: Pakudex is full!\n");
                }
                else
                {
                    /*
                    user enters name of pakuri,
                    and message is displayed to
                    tell whether or not it was
                    done successfully
                     */
                    System.out.print("Enter the name of the species to add: ");
                    name = scan.next();

                    success = pakudex.addPakuri(name);

                    if (success)
                    {
                        System.out.println("Pakuri species " + name + " successfully added!\n");
                        ++size;
                    }
                    /*
                    error message if addPakuri
                    method returns false (pakuri
                    already exists in pakudex)
                     */
                    else
                    {
                        System.out.println("Error: Pakudex already contains this species!\n");
                    }
                }
            }
            /*
            fourth option allows user to
            evolve an existing pakuri within
            the pakudex
             */
            else if (userOption == 4)
            {
                String name;
                boolean success;
                /*
                user enters name of
                pakuri to be evolved
                 */
                System.out.print("Enter the name of the species to evolve: ");
                name = scan.next();

                success = pakudex.evolveSpecies(name);
                /*
                message displayed to user based
                on whether pakuri was successfully
                found pakudex and evolved
                 */
                if (success)
                {
                    System.out.println(name + " has evolved!\n");
                }
                else
                {
                    System.out.println("Error: No such Pakuri!\n");
                }
            }
            /*
            fifth option allows user to sort
            the pakudex
             */
            else if (userOption == 5)
            {
                pakudex.sortPakuri();

                System.out.println("Pakuri have been sorted!\n");
            }
            /*
            fifth option allows user
            to exit the program
             */
            else if (userOption == 6)
            {
                System.out.println("Thanks for using Pakudex! Bye!");
                break;
            }
        }
    }
}
