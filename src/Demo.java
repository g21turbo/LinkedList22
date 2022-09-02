import javax.swing.*;
import java.util.*;

public class Demo {

    public static void main(String[] args) {

        //Creating a linked list
        LinkedList<String> placesToVisit = new LinkedList<>();

        //Adding items to the linked list
        placesToVisit.add("Hawaii");
        placesToVisit.add("Australia");
        placesToVisit.add("New York");
        placesToVisit.add("Vermont");
        placesToVisit.add("North Carolina");
        placesToVisit.add("West Virginia");

        //Printing the linked list
        printList(placesToVisit);

        //Adding items to the linked list, Printing the linked list
        placesToVisit.add(1, "Florida");
        printList(placesToVisit);
        placesToVisit.add(4, "New Hampshire");
        printList(placesToVisit);

        //Adding items to the linked list, Printing the linked list
        placesToVisit.remove(5);
        printList(placesToVisit);


        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Hawaii");
        printList(placesToVisit);
        visit(placesToVisit);


    }

    //Method used to print the passed linked list
    private static void printList(LinkedList<String> linkedList) {

        //Iterator used to sort through list
        Iterator<String> i = linkedList.iterator();

        //Continue printing each next item in the list
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==========================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                //equal, do not add
                System.out.println(newCity + " is already included as a destination");
            } else if (comparison > 0) {
                //new City should appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move on next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean  quit = false;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    break;
                case 1:
                    if (listIterator.hasNext()) {
                        System.out.println("now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list.");
                    }
                    break;
                case 2:
                    if (listIterator.hasPrevious()) {
                        System.out.println("now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list.");
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                    "1 - go to the next city\n" +
                    "2 - go to the previous city\n" +
                    "3 - print menu options");

    }

}
