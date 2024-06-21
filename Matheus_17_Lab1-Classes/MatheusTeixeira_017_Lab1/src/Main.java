

import java.util.Scanner;

/**
* <h1>Add Two Numbers!</h1>
* The AddNum program implements an application that
* simply adds two given integer numbers and Prints
* the output on the screen.
* <p>
* <b>Note:</b> Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
*
* @author  Zara Ali
* @version 1.0
* @since   2014-03-31
*/

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        //singer first constructor
        Singers singer1 = new Singers();
        System.out.println("--- default values ---");
        //testing getters
        System.out.println("Singer ID: " + singer1.getSingerID());
        System.out.println("Singer Name: " + singer1.getSingerName());
        System.out.println("Singer Address: " + singer1.getSingerAddress());
        System.out.println("Singer DOB: " + singer1.getSingerDOB());
        System.out.println("Number of Albuns: " + singer1.getAlbunsQt());

        singer1.setSingerID(1);
        singer1.setSingerName("Matheus");
        singer1.setSingerAddress("10 Progress Ave.");
        singer1.setSingerDOB("1/Jan/2001");
        singer1.setAlbunsQt(10);

        System.out.println("\n--- after using setters ---");
        System.out.println(singer1);

        System.out.println("+++++++ End of the first test +++++++\n");

        //singer second constructor
        Singers singer2 = new Singers(2);

        System.out.println("--- constructor with 1 argument ---");
        System.out.println(singer2);

        singer2.setSingerID(20);
        singer2.setSingerName("Vinicius");
        singer2.setSingerAddress("20 Taguatinga street");
        singer2.setSingerDOB("2/Fev/2002");
        singer2.setAlbunsQt(20);

        System.out.println("\n--- after using setters ---");
        System.out.println(singer2);

        System.out.println("+++++++ End of the second test +++++++\n");

        //singer third constructor
        Singers singer3 = new Singers(3,
                "Ferreira");

        System.out.println("--- constructor with 2 argument ---");
        System.out.println(singer3);

        singer3.setSingerID(30);
        singer3.setSingerName("Carlos");
        singer3.setSingerAddress("30 Queen Ave.");
        singer3.setSingerDOB("3/Mar/2003");
        singer3.setAlbunsQt(30);

        System.out.println("\n--- after using setters ---");
        System.out.println(singer3);
        System.out.println("+++++++ End of the third test +++++++\n");

        //singer 4th constructor
        Singers singer4 = new Singers(4,
                "Figueiredo",
                "40 king Street");

        System.out.println("--- constructor with 3 argument ---");
        System.out.println(singer4);

        singer4.setSingerID(40);
        singer4.setSingerName("Paula");
        singer4.setSingerAddress("80 Queen Ave.");
        singer4.setSingerDOB("4/Apr/2004");
        singer4.setAlbunsQt(40);

        System.out.println("\n--- after using setters ---");
        System.out.println(singer4);
        System.out.println("+++++++ End of the 4th test +++++++\n");

        //singer 5th constructor
        Singers singer5 = new Singers(5,
                "Teixeira",
                "50 Prince Street",
                "5/May/2005");

        System.out.println("--- constructor with 4 argument ---");
        System.out.println(singer5);

        singer5.setSingerID(50);
        singer5.setSingerName("Rebecca");
        singer5.setSingerAddress("100 Prince Ave.");
        singer5.setSingerDOB("10/May/2005");
        singer5.setAlbunsQt(50);

        System.out.println("\n--- after using setters ---");
        System.out.println(singer5);
        System.out.println("+++++++ End of the 5th test +++++++\n");

        //singer 6th constructor
        Singers singer6 = new Singers(6,
                "Maria",
                "60 London Street",
                "6/Jun/2006",
                60);

        System.out.println("--- constructor with 5 argument ---");
        System.out.println(singer6);

        //testing setAll()

        singer6.setAll(60,
                "Areco",
                "120 Prince Ave.",
                "12/Jun/2006",
                120);

        System.out.println("\n--- after using setAll ---");
        System.out.println(singer6);

        System.out.println("+++++++ End of the 6th test +++++++\n");
    }
}