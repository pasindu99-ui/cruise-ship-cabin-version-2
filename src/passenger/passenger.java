package passenger;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class passenger {
    static Scanner myObj = new Scanner(System.in);


    public passenger() throws IOException {
    }


    public String[][][] addCabin(String[][][] cruiseShipCabin) {
        System.out.print("How many passengers do you have to insert cabin? (MAXIMUM 3 PASSENGERS) : ");
        int passenger1 = parseInt(myObj.nextLine());
        System.out.println();
        int i=0;
        System.out.print("Enter Cabin number :  ");
        int CabinNumber = parseInt(myObj.nextLine());
        System.out.println("");
        while (i<passenger1){
            System.out.print("Enter first name :  ");
            String firstname = myObj.nextLine();
            System.out.print("Enter sur name :   ");
            String surname = myObj.nextLine();
            System.out.print("Enter expenses :   ");
            String expenses = myObj.nextLine();
            cruiseShipCabin[CabinNumber - 1][i][0] = String.valueOf(firstname);
            cruiseShipCabin[CabinNumber - 1][i][1] = String.valueOf(surname);
            cruiseShipCabin[CabinNumber - 1][i][2] = String.valueOf(expenses);
            System.out.println();
            System.out.println("Added this person to the cabin.");
            System.out.println();
            i++;
        }
        return cruiseShipCabin;
    }

    public static void viewCabin(String[][][] cruiseShipCabin) {
        System.out.println("");
        System.out.println("<<<--- VIEW CABINS --->>>");
        System.out.println("");
        for (int i = 0; i < cruiseShipCabin.length; i++) {
            if (cruiseShipCabin[i][0][0]!=null) {
                System.out.println(cruiseShipCabin[i][0][0]+"  "+cruiseShipCabin[i][1][0]+"  "+cruiseShipCabin[i][2][0]+"  has reserved this");

            }else{
                System.out.println("cabin "+ (i+1)+" is empty");
            }
        }
    }

    public static void viewEmptyCabin(String[][][] cruiseShipCabin) {
        System.out.println("<===  THE CABINS BELOW ARE EMPTY  ===>");
        System.out.println("");
        for (int i = 0; i < cruiseShipCabin.length; i++) {
            if (cruiseShipCabin[i][0][0]==null) {
                System.out.println(" cabin "+ (i+1)+" is empty");
            }
        }
    }
    public static void findCabin(String[][][] cruiseShipCabin) {
        System.out.print("Enter first name :  ");
        String findCabin = (myObj.nextLine().toString());
        System.out.println("");
        for(int i=0; i< cruiseShipCabin.length; i++){
            for(int j=0; j < cruiseShipCabin[i].length; j++) {
                String loopedCabin = cruiseShipCabin[i][j][0];
                if (loopedCabin != null) {
                    if (loopedCabin.equals(findCabin)) {
                        System.out.println(findCabin+" Is in the Cabin number => "+(i+1));
                        System.out.println("");
                       }
                    }
                }
            }
        }


    public static void sortCabin(String[][][] cruiseShipCabin) {
        System.out.println("");
        System.out.println("<<<--- ALPHABETICALLY ORDERED --->>> ");
        System.out.println("");
        String [] names = {};
        for(int i=0; i< cruiseShipCabin.length; i++){
            for(int j=0; j < cruiseShipCabin[i].length; j++) {
                String fName=cruiseShipCabin[i][j][0];
                if (cruiseShipCabin[i][j][0] != null){
                names = Arrays.copyOf(names, names.length + 1);
                names[names.length - 1] = String.valueOf(fName);
                }
            }
        }
        Arrays.sort(names);
        for (var p = 0; p < names.length; p++) {
            System.out.println(names[p]);
        }
    }

    public void writeFile(String[][][] cruiseShipCabin) throws IOException {
        File file = new File("output.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw =new PrintWriter(fw);
        pw.println("<---------      Passenger Details     --------->");
        pw.println("");
        for (int i = 0; i < cruiseShipCabin.length; i++) {
            if (cruiseShipCabin[i][0][0] != null){
                pw.println("Cabin No "+(i+1)+" is reserved by "+cruiseShipCabin[i][0][0]+", "+cruiseShipCabin[i][1][0]+" and  "+cruiseShipCabin[i][2][0]+".");
                pw.println("");

            }
        }
        pw.close();
        System.out.println("ALL DATA STORED");
    }

    public void readFile(String[][][] cruiseShipCabin) throws FileNotFoundException {
        File file = new File("D:\\Cruise ship cabin version 2\\output.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }

    public static void removeCabin(String[][][] cruiseShipCabin, int removedCabin) {

        int i=0;
        while (i<=2){
            cruiseShipCabin[removedCabin - 1][i][0] = null;
            cruiseShipCabin[removedCabin - 1][i][1] = null;
            cruiseShipCabin[removedCabin - 1][i][2] = null;
            i++;
        }
        System.out.println("removed cabin No :"+(removedCabin));
    }
    public void calTot(String[][][] cruiseShipCabin) {
        System.out.println("");
        System.out.println("<<<--- TOTAL EXPENSES --->>>");
        System.out.println("");
        int Total=0;
        for (int i = 0; i < cruiseShipCabin.length; i++) {
            for (int j = 0; j < cruiseShipCabin[i].length; j++) {
                if (cruiseShipCabin[i][j][2] != null) {
                    int expen = Integer.parseInt(cruiseShipCabin[i][j][2]);
                    System.out.println(cruiseShipCabin[i][j][0]+" cost is ==>>"+expen);
                    Total= expen + Total;
                }
            }
        }
        System.out.println("");
        System.out.println("Total expenses of all passengers in cruise ship : "+Total);
    }
    public static void main(String[] args) {

    }

}
