package myqueue;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MyQueue {
    static Scanner myObj = new Scanner(System.in);
    String [][][] queue;
    int rear;
    int front;
    int size;

    public MyQueue(int sizeOfArray){
        queue=new String[sizeOfArray][3][3];
        rear=-1;
        front=-1;
        size=0;
    }


    public boolean isEmpty(){
        boolean response = false;
        if(size==0){
            response=true;
        }
        return response;
    }

    public boolean enqueue(){
        System.out.println("");
        System.out.println("Ship cabin is full.you can add customers to the queue");
        System.out.println("");
        System.out.println();
        boolean response=false;
        if(rear!= queue.length-1){
            rear++;
            System.out.print("How many passengers do you have to insert cabin? (MAXIMUM 3 PASSENGERS) : ");
            int passenger1 = parseInt(myObj.nextLine());
            int i=0;
            while (i<passenger1){
                System.out.print("Enter first name : ");
                String firstname = myObj.nextLine();
                System.out.print("Enter sur name : ");
                String surname = myObj.nextLine();
                System.out.print("Enter expenses : ");
                String expenses = myObj.nextLine();
                queue[rear][i][0] = String.valueOf(firstname);
                queue[rear][i][1] = String.valueOf(surname);
                queue[rear][i][2] = String.valueOf(expenses);
                i++;
                size++;
                response=true;
            }
        }
        return response;
    }
    public String dequeue(){
        String response ="";
        if(size != 0){
            front++;
            response= Arrays.deepToString(queue[front]);
            size--;
        }
        return response;
    }

    public String[][][] peek(String[][][] cruiseShipCabin, int removedCabin){
        String response="";
        if(!isEmpty()){
            response= Arrays.deepToString(queue[front+1]);
            int i = 0;
            while (i<=2){
                cruiseShipCabin[removedCabin - 1][i][0] = queue[front+1][i][0];
                cruiseShipCabin[removedCabin - 1][i][1] = queue[front+1][i][1];
                cruiseShipCabin[removedCabin - 1][i][2] = queue[front+1][i][2];
                i++;
            }
        }
        return cruiseShipCabin;
    }
    public int getSize(){
        return size;
    }
}


