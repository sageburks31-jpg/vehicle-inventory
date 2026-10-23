package com.pluralsight;

import java.util.*;

public class Main {

    static Scanner scanner=new Scanner(System.in);
    static List<Vehicle> vehicleList=new ArrayList<>();

    static String[] questionList = {"What is the vehicleId?", "What is the makeModel?",
            "Who is the color?", "What is the odometerReading?", "what is the price?"};
    static String[] phoneStatList = {"vehicleId", "makeModel", "color", "odometerReading", "price"};

    public static void main(String[] args) {
        addVehicleToList(101121, "Ford Explorer",
                "Red", 45000,13500);

        startMenu();
    }

    public static void startMenu() {
        print("""
                
                *==== Main Vehicle Menu ====*
                
                enter (S)earch to find Vehicle data.
                enter (E)nd to end program.
                enter (A)dd to add new Vehicle data.
                
                Please enter your response here->:""" + " ");

        String stringInput = scanner.nextLine().toLowerCase();

        switch (stringInput) {
            case ("s"), ("search") -> searchVehicleMenu();
            case ("e"), ("end") -> print("program has ended");
            case ("a"), ("add") -> addVehicleMenu();
            default -> {
                print(String.format("Please enter a valid Input %n"));
                startMenu();
            }
        }
    }

    private static void searchVehicleMenu() {
        print("""
                
                *==== Search Vehicle Menu ====*
                
                enter (VID) to search for vehicleId.
                enter (MMD) to search for makeModel.
                enter (CLR) to search for color.
                enter (OMR) to search for odometerReading.
                enter (PR) to search for price.
                enter (R)eturn to return to main menu.
                
                Please enter your response here->:"""+" ");

        String stringInput = scanner.nextLine().toLowerCase();

        switch (stringInput){
            case ("r"), ("return") -> startMenu();
            case ("vid"), ("vehicleid") -> searchVehicleID();
            case ("mmd"), ("makemodel") -> searchMakeModel();
            case ("clr"), ("color") -> searchColor();
            case ("omr"), ("odometerreading") -> searchOdometerReading();
            case ("pr"), ("price") -> searchPrice();
            default -> {
                print(String.format("Please enter a valid Input %n"));
                searchVehicleMenu();
            }
        }
    }

    private static void searchVehicleID() {
        print("please enter " + phoneStatList[0] + " here ->: ");

        boolean foundVehicle = false;
        int enteredVehicleStat = scanner.nextInt();
        scanner.nextLine();
        int forloopindex=0;

        for (Vehicle vehicle: vehicleList){
            if (vehicle.getVehicleId() == enteredVehicleStat){
                print("""
                
                *==== Found Vehicle ====*
                
                """);
                printVehicleStats(forloopindex);
                foundVehicle = true;
                break;
            }
            forloopindex++;
        }
        if (!foundVehicle){
            print(" *==== No Vehicle Found ====* ");
        }
        searcherRequestMenu();
    }

    private static void searchMakeModel() {
        print("please enter " + phoneStatList[1] + " here ->: ");

        boolean foundVehicle = false;
        String enteredVehicleStat = scanner.nextLine().trim();
        int forloopindex=0;

        for (Vehicle vehicle: vehicleList){
            if (vehicle.getMakeModel().equals(enteredVehicleStat)){
                print("""
                
                *==== Found Vehicle ====*
                
                """);
                printVehicleStats(forloopindex);
                foundVehicle = true;
                break;
            }
            forloopindex++;
        }
        if (!foundVehicle){
            print(" *==== No Vehicle Found ====* ");
        }
        searcherRequestMenu();
    }

    private static void searchColor() {
        print("please enter " + phoneStatList[3] + " here ->: ");

        boolean foundVehicle = false;
        String enteredVehicleStat = scanner.nextLine().trim();
        int forloopindex=0;

        for (Vehicle vehicle: vehicleList){
            if (vehicle.getColor().equals(enteredVehicleStat)){
                print("""
                
                *==== Found Vehicle ====*
                
                """);
                printVehicleStats(forloopindex);
                foundVehicle = true;
                break;
            }
            forloopindex++;
        }
        if (!foundVehicle){
            print(" *==== No Vehicle Found ====* ");
        }
        searcherRequestMenu();
    }

    private static void searchOdometerReading() {
        print("please enter " + phoneStatList[3] + " here ->: ");

        boolean foundVehicle = false;
        int enteredVehicleStat = scanner.nextInt();
        scanner.nextLine();
        int forloopindex=0;

        for (Vehicle vehicle: vehicleList){
            if (vehicle.getOdometerReading() == enteredVehicleStat){
                print("""
                
                *==== Found Vehicle ====*
                
                """);
                printVehicleStats(forloopindex);
                foundVehicle = true;
                break;
            }
            forloopindex++;
        }
        if (!foundVehicle){
            print(" *==== No Vehicle Found ====* ");
        }
        searcherRequestMenu();
    }

    private static void searchPrice() {
        print("please enter " + phoneStatList[4] + " here ->: ");

        boolean foundVehicle = false;
        double enteredVehicleStat = scanner.nextDouble();
        scanner.nextLine();
        int forloopindex=0;

        for (Vehicle vehicle: vehicleList){
            if (vehicle.getPrice()==enteredVehicleStat){
                print("""
                
                *==== Found Vehicle ====*
                
                """);
                printVehicleStats(forloopindex);
                foundVehicle = true;
                break;
            }
            forloopindex++;
        }
        if (!foundVehicle){
            print(" *==== No Vehicle Found ====* ");
        }
        searcherRequestMenu();
    }

    private static void auditVehicleData() {
        print("""
                
                *==== Audit Vehicle Menu ====*
                
                enter (VID) to edit vehicleId.
                enter (MMD) to edit makeModel.
                enter (CLR) to edit color.
                enter (OMR) to edit odometerReading.
                enter (PR) to edit name of price.
                enter (R)eturn to return to main menu.
                
                Please enter your response here->:"""+" ");

    }

    private static void searcherRequestMenu() {
        print("""
                
                *==== Vehicle Searcher Menu ====*
                
                enter (S)earch to search for another Vehicle.
                enter (E)nd to end program.
                enter (A)udit to edit the presented Vehicle data.
                enter (R)eturn to return to main menu.
                
                Please enter your response here->:""" + " ");

        String stringInput = scanner.nextLine().toLowerCase();

        switch (stringInput) {
            case ("s"), ("search") -> searchVehicleMenu();
            case ("e"), ("end") -> print("program has ended");
            case ("a"), ("audit") -> {}
            case ("r"), ("add") -> startMenu();
            default -> {
                print(String.format("Please enter a valid Input %n"));
                searcherRequestMenu();
            }
        }
    }

    private static void addVehicleMenu() {
        Vehicle vehicle;
        vehicle = new Vehicle();
        print("""
                
                *==== Add Vehicle Menu ====*
                
                """);

        for (int i = 0; i <= 4; i++) {
            print(questionList[i] + String.format("%n | enter here ->: "));

            switch (i){
                case (0) -> {
                    long answerInput = scanner.nextInt();
                    vehicle.setVehicleId(answerInput);
                    scanner.nextLine();
                }
                case (1) -> {
                    String answerInput = scanner.nextLine();
                    vehicle.setMakeModel(answerInput);
                }
                case (2) -> {
                    String answerInput = scanner.nextLine();
                    vehicle.setColor(answerInput);
                }
                case (3) -> {
                    int answerInput = scanner.nextInt();
                    vehicle.setOdometerReading(answerInput);
                    scanner.nextLine();
                }
                case (4) -> {
                    double answerInput = scanner.nextDouble();
                    vehicle.setPrice(answerInput);
                    scanner.nextLine();
                }
            }
        }
    }

    private static void print(String printString) {
        System.out.print(printString);
    }

    private static void printVehicleStats(int vehicleIndex) {
        print(questionList[0] + " " + vehicleList.get(vehicleIndex).getVehicleId() + String.format("%n"));
        print(questionList[1] + " " + vehicleList.get(vehicleIndex).getMakeModel() + String.format("%n"));
        print(questionList[2] + " " + vehicleList.get(vehicleIndex).getColor() + String.format("%n"));
        print(questionList[3] + " " + vehicleList.get(vehicleIndex).getOdometerReading() + String.format("%n"));
        print(questionList[4] + " " + vehicleList.get(vehicleIndex).getPrice() + String.format("%n"));
    }

    public static void addVehicleToList(int VID, String MMD, String CLR, int OMR, double PR) {
        Vehicle vehicle = new Vehicle();
        vehicle.vehicle(VID, MMD, CLR, OMR, PR);
        vehicleList.add(vehicle);
        printVehicleStats(vehicleList.size() - 1);
    }
}