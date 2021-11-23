package com.moodyjun;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static List<IceCream> iceCreamList;
    public static OrderRequestHandler orderRequestHandler;
    public static IceCreamFactory iceCreamFactory;

    public static List<IceCream> getIceCreamList() {
        return List.of(iceCreamFactory.getIceCream("Cone","Coffee")
                , iceCreamFactory.getIceCream("Cone", "Raspberry")
                , iceCreamFactory.getIceCream("Stick", "Coffee")
                , iceCreamFactory.getIceCream("Stick", "Raspberry")
        );
    }

    public static void configureRequestHandler() {
        BranchManagerHandler branchManagerHandler = new BranchManagerHandler();
        RegionalDirectorHandler regionalDirectorHandler = new RegionalDirectorHandler();
        VicePresidentHandler vicePresidentHandler = new VicePresidentHandler();
        PresidentHandler presidentHandler = new PresidentHandler();

        vicePresidentHandler.setNextHandler(presidentHandler);
        regionalDirectorHandler.setNextHandler(vicePresidentHandler);
        branchManagerHandler.setNextHandler(regionalDirectorHandler);
        orderRequestHandler = branchManagerHandler;
    }

    public static void main(String[] args) {
        iceCreamFactory = new IceCreamFactory();
        iceCreamList = getIceCreamList();
        configureRequestHandler();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Menu - [Moody Food]");
            iceCreamList.forEach(System.out::println);
            System.out.println("-----------------------------------");
            System.out.print("Enter ice cream name (q for exit): ");
            String input = scanner.nextLine();
            if (input.equals("q")) break;
            IceCream iceCream;
            try {
                String finalInput = input;
                Optional<IceCream> item = iceCreamList.stream().filter(i -> i.getName().equals(finalInput)).findFirst();
                if (item.isEmpty()) {
                    throw new Exception();
                }
                iceCream = item.get();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            System.out.print("Enter quantity (default 1, q for exit) : ");
            input = scanner.nextLine();
            if (input.equals("q")) break;
            int quantity = 1;
            try {
                quantity = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            OrderRequest orderRequest = new OrderRequest(UUID.randomUUID().toString(), iceCream, quantity, quantity * iceCream.getPrice());
            sendRequest(orderRequest);
        }
    }

    public static void sendRequest(OrderRequest orderRequest){
        orderRequestHandler.handleRequest(orderRequest);
    }
}
