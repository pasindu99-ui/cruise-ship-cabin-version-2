package Cabin;
import myqueue.MyQueue;
import passenger.passenger;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.Integer.parseInt;


public class cabin {
    static Scanner myObj = new Scanner(System.in);
    MyQueue queue=new MyQueue(12);


    public void menu() throws IOException {
        var cruiseShipCabin = new String[12][3][3];
        int i=0;
        while (true){
            passenger imethod = new passenger();
            System.out.println("");
            System.out.println("                <==== MENU ====>                ");
            System.out.println("");
            System.out.println("A :     add a customer to a cabin");
            System.out.println("V :     view all cabins");
            System.out.println("E :     Display Empty cabins");
            System.out.println("D :     Delete customer from cabin");
            System.out.println("F :     Find cabin from customer name ");
            System.out.println("S :     Store program data into file");
            System.out.println("L :     Load program data from file");
            System.out.println("O :     View passengers Ordered alphabetically by name.");
            System.out.println("T :     View total expenses of all passengers.");
            System.out.println("");
            System.out.println("");
            System.out.print("Choose What You Want To Do? ");
            var choosedLetter = myObj.nextLine();
            System.out.println("");
            String value = choosedLetter.toUpperCase();
            if (value.equals("A")) {
                if (i==12){
                    queue.enqueue();
                }else {
                    try {
                        i++;
                        imethod.addCabin(cruiseShipCabin);
                    }
                    catch(Exception e) {
                        System.out.println("Something went wrong. make sure the information you entered is correct.");
                    }
                }

            } else if (value.equals("V")) {
                imethod.viewCabin(cruiseShipCabin);
            } else if (value.equals("E")) {
                imethod.viewEmptyCabin(cruiseShipCabin);
            }else if (value.equals("F")){
                imethod.findCabin(cruiseShipCabin);
            }else if (value.equals("O")){
                imethod.sortCabin(cruiseShipCabin);
            }else if (value.equals("S")){
                imethod.writeFile(cruiseShipCabin);
            }else if (value.equals("L")){
                imethod.readFile(cruiseShipCabin);
            }else if (value.equals("D")){
                System.out.print("Enter Cabin number : ");
                int removedCabin = parseInt(myObj.nextLine());
                try {
                    imethod.removeCabin(cruiseShipCabin,removedCabin);
                }
                catch(Exception e) {
                    System.out.println("No cabins are reserved here");
                }
                queue.peek(cruiseShipCabin,removedCabin);
                System.out.println("The first reservation in the queue was added instead of the deleted cabin.");
                queue.dequeue();

            } else if (value.equals("T")){
                imethod.calTot(cruiseShipCabin);
            } else {
                System.out.println("");
                System.out.println("<===There is no menu corresponding to the charactor entered you===>");
                System.out.println("");
            }

        }
    }
}

