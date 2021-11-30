package com.moodyjun;

import java.util.*;

public class Client {
    public static OrderRequestHandler orderRequestHandler;

    public static void main(String[] args) {
        IceCreamFactory iceCreamFactory = new IceCreamFactory();
        configureRequestHandler();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu(getType());
            String type = scanner.nextLine();
            if (type.equals("q")) break;
            showMenu(getFlavour());
            String flavour= scanner.nextLine();
            if (flavour.equals("q")) break;
            IceCream iceCream = iceCreamFactory.getIceCream(type, flavour);
            if (Objects.isNull(iceCream)){
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            System.out.print("Enter quantity (default 1, q for exit) : ");
            String input = scanner.nextLine();
            if (input.equals("q")) break;
            int quantity = 1;
            try {
                quantity = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            OrderRequest orderRequest = new OrderRequest(UUID.randomUUID().toString(),
                    iceCream,
                    quantity,
                    quantity * iceCream.getPrice());
            sendRequest(orderRequest);
        }
    }

    public static void sendRequest(OrderRequest orderRequest){
        orderRequestHandler.handleRequest(orderRequest);
    }

    public static void configureRequestHandler() {
        SeniorExecutiveHandler seniorExecutiveHandler = new SeniorExecutiveHandler();
        BranchManagerHandler branchManagerHandler = new BranchManagerHandler();
        GeneralManagerHandler generalManagerHandler = new GeneralManagerHandler();
        DirectorHandler directorHandler = new DirectorHandler();

        generalManagerHandler.setNextHandler(directorHandler);
        branchManagerHandler.setNextHandler(generalManagerHandler);
        seniorExecutiveHandler.setNextHandler(branchManagerHandler);
        orderRequestHandler = seniorExecutiveHandler;
    }

    public static String getType(){
        return "1. Cone\n2. Stick\n";
    }

    public static String getFlavour(){
        return "1. Coffee\n2. Rasberry\n";
    }

    public static void showMenu(String input){
        System.out.println("-----------------------------------");
        System.out.println("Menu - [Moody Food]");
        System.out.println(input);
        System.out.println("-----------------------------------");
        System.out.print("Enter choice (q for exit): ");
    }
}
