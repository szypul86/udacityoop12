import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

ArrayList loadedItems = new ArrayList();
ArrayList u1Rockets = new ArrayList();
ArrayList u2Rockets = new ArrayList();
int totalBudget = 0;


    ArrayList loadItems(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        // method that iterate through file line by line, untill there is none left
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Item item = new Item();
            //divide line on '=', input 1st part into item.name
            item.name = line.split("=")[0];
            //input 2nd part into item.weight and change the type to int
            item.weight = Integer.parseInt(line.split("=")[1]);
            // add The item to an array
            loadedItems.add(item);
        }
        //returns created array
        return loadedItems;
    }

    ArrayList loadU1() {
        //create new first U1 rocket
        U1 u1 = new U1();
        // buffer item to get single object from loadedItems array
        Item item = new Item();
        for (int i = 0; i <loadedItems.size(); i++){
            // get one object from the array and change its type to Item
            item = (Item) loadedItems.get(i);
            // check if the item can be added to existing rocket
            if (!u1.canCarry(item)){
                //if not, add existing rocket to arrays of rockets and create a new rocket
                u1Rockets.add(u1);
                   u1 = new U1();
            }
            // adding the item to the loading weight
            u1.loadedWeight += item.weight;
        }
        // adding last rocket to the array
        u1Rockets.add(u1);
        // return the array of rockets
        return u1Rockets;
    }

    ArrayList loadU2() {
        //see load1() - could be done by one method
        U2 u2 = new U2();
        Item item = new Item();
        for (int i = 0; i <loadedItems.size(); i++){
            item = (Item) loadedItems.get(i);
            if (!u2.canCarry(item)){
                u2Rockets.add(u2);
                u2 = new U2();
            }
            u2.loadedWeight += item.weight;
        }
        u2Rockets.add(u2);
        return u2Rockets;
    }

    int runSimulation (ArrayList rockets) {
        //iterate through all the rockets in the array
        for (int i = 0; i < rockets.size(); i++) {
            //create a rocket from a array of objects
            Rocket singleRocket = (Rocket) rockets.get(i);
            //if crashed, reduce i by one that means create the same rocket again in the loop next time
            if (!singleRocket.launch() || !singleRocket.land()) {
                i--;
                //System.out.println("kabooom");
            }
            //add a cost of each rocket
            totalBudget += singleRocket.cost;
        }
        //return totalBudget
        return totalBudget;
    }
}


