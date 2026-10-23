package com.pluralsight;

import java.util.*;

public class Main {

    static Scanner scanner=new Scanner(System.in);
    static List<Vehicle> vehicleList=new ArrayList<>();
    static int vehicleIndexKey=0;

    static String[] questionList = {"What is the vehicleId?", "What is the makeModel?",
            "Who is the color?", "What is the odometerReading?", "what is the price?"};
    static String[] phoneStatList = {"vehicleId", "makeModel", "color", "odometerReading", "price"};

    public static void main(String[] args) {
        addVehicleToList(101121, "Ford Explorer",
                "Red", 45000,13500);
        addVehicleToList(101122,"Toyota Camry",
                "Blue",60000,11000);
        addVehicleToList(101123,"Chevrolet Malibu",
                "Black",50000,9700);
        addVehicleToList(101124,"Honda Civic",
                "White",70000,7500);
        addVehicleToList(101125,"Subaru Outback",
                "Green",55000,14500);
        addVehicleToList(101126,"Jeep Wrangler",
                "Yellow",30000,16000);
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
                vehicleIndexKey=forloopindex;
                foundVehicle = true;
                break;
            }
            forloopindex++;
        }
        findVehicleResult(foundVehicle);
    }
    private static void searchMakeModel() {
        print("please enter " + phoneStatList[1] + " here ->: ");

        boolean foundVehicle = false;
        String enteredVehicleStat = scanner.nextLine().trim();
        int forLoopIndex=0;

        for (Vehicle vehicle: vehicleList){
            if (vehicle.getMakeModel().equals(enteredVehicleStat)){
                print("""
                
                *==== Found Vehicle ====*
                
                """);
                printVehicleStats(forLoopIndex);
                vehicleIndexKey=forLoopIndex;
                foundVehicle = true;
                break;
            }
            forLoopIndex++;
        }
        findVehicleResult(foundVehicle);
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
                vehicleIndexKey=forloopindex;
                foundVehicle = true;
                break;
            }
            forloopindex++;
        }
        findVehicleResult(foundVehicle);
    }
    private static void searchOdometerReading() {
        print("please enter " + phoneStatList[3] + " here ->: ");

        boolean foundVehicle = false;
        int enteredVehicleStat = scanner.nextInt();
        scanner.nextLine();
        int forLoopIndex=0;

        for (Vehicle vehicle: vehicleList){
            if (vehicle.getOdometerReading() == enteredVehicleStat){
                print("""
                
                *==== Found Vehicle ====*
                
                """);
                printVehicleStats(forLoopIndex);
                vehicleIndexKey=forLoopIndex;
                foundVehicle = true;
                break;
            }
            forLoopIndex++;
        }
        findVehicleResult(foundVehicle);
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
                vehicleIndexKey=forloopindex;
                foundVehicle = true;
                break;
            }
            forloopindex++;
        }
        findVehicleResult(foundVehicle);
    }

    private static void findVehicleResult(boolean foundVehicle){
        if (!foundVehicle){
            print(" *==== No Vehicle Found ====* ");
            searchVehicleMenu();
        } else {auditDataMenu();}
    }

    private static void auditDataMenu() {
        print("""
                
                *==== Audit Vehicle Menu ====*
                
                enter (VID) to edit vehicleId.
                enter (MMD) to edit makeModel.
                enter (CLR) to edit color.
                enter (OMR) to edit odometerReading.
                enter (PR) to edit name of price.
                enter (R)eturn to return to main menu.
                
                Please enter your response here->:"""+" ");

        String resultEntered=scanner.nextLine().toLowerCase().trim();

        switch (resultEntered) {
            case ("vid"),("vehicleid")->editVehicleData(0);
            case ("mmd"),("makemodel")->editVehicleData(1);
            case ("clr"),("color")->editVehicleData(2);
            case ("omr"),("odometerreading")->editVehicleData(3);
            case ("pr"),("price")->editVehicleData(4);
            case ("r"),("return")->startMenu();
            default -> {
                print("Error Invalid request found. Please enter a valid item.");
                auditDataMenu();
            }
        }
    }

    private static void editVehicleData(int query) {
        switch (query) {
            case (0) -> setVehicleId();
            case (1) -> setMakeModel();
            case (2) -> setColor();
            case (3) -> setOdometerReading();
            case (4) -> setPrice();
            default -> {
                print("Error! item not found. queryIndex entered: "+query);
                startMenu();
            }
        }
    }

    private static void setVehicleId(){
        print(String.format("""
                 %s: %s
                 | please change here ->:""" + " "
                , phoneStatList[0], ""+vehicleList.get(vehicleIndexKey).getVehicleId()));
        long answerInput = scanner.nextInt();
        scanner.nextLine();
        vehicleList.get(vehicleIndexKey).setVehicleId(answerInput);
        printVehicleStats(vehicleIndexKey);
        searcherRequestMenu();
    }
    private static void setMakeModel(){
        print(String.format("""
                 %s: %s
                 | please change here ->:""" + " ",
                phoneStatList[1], vehicleList.get(vehicleIndexKey).getMakeModel()));
        String answerInput = scanner.nextLine();
        vehicleList.get(vehicleIndexKey).setMakeModel(answerInput);
        printVehicleStats(vehicleIndexKey);
        searcherRequestMenu();
    }
    private static void setColor(){
        print(String.format("""
                 %s: %s
                 | please change here ->:""" + " ",
                phoneStatList[2], vehicleList.get(vehicleIndexKey).getColor()));
        String answerInput = scanner.nextLine();
        vehicleList.get(vehicleIndexKey).setColor(answerInput);
        printVehicleStats(vehicleIndexKey);
        searcherRequestMenu();
    }
    private static void setOdometerReading(){
        print(String.format("""
                 %s: %s
                 | please change here ->:""" + " ",
                phoneStatList[3], ""+vehicleList.get(vehicleIndexKey).getOdometerReading()));
        int answerInput = scanner.nextInt();
        vehicleList.get(vehicleIndexKey).setOdometerReading(answerInput);
        scanner.nextLine();
        printVehicleStats(vehicleIndexKey);
        searcherRequestMenu();
    }
    private static void setPrice(){
        print(String.format("""
                 %s: %s
                 | please change here ->:"""+" ",
                phoneStatList[4], ""+vehicleList.get(vehicleIndexKey).getPrice()));
        long answerInput = scanner.nextInt();
        vehicleList.get(vehicleIndexKey).setPrice(answerInput);
        scanner.nextLine();
        printVehicleStats(vehicleIndexKey);
        searcherRequestMenu();
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
            case ("a"), ("audit") -> {auditDataMenu();}
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
        vehicleList.add(vehicle);
        printVehicleStats(vehicleList.size() - 1);
        startMenu();
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