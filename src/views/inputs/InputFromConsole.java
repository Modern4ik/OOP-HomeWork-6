package views.inputs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InputFromConsole implements Inputter{

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public Queue<Object> inputFromConsole(){
        Queue<Object> orderInfo = new LinkedList<>();
        System.out.println("-------------------------------");
        orderInfo.add(prompt("Client name: "));
        orderInfo.add(prompt("Product: "));
        orderInfo.add(Integer.parseInt(prompt("Quantity: ")));
        orderInfo.add(Integer.parseInt(prompt("Price: ")));
        System.out.println("-------------------------------");

        return orderInfo;
    }
}
