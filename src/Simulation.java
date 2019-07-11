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
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Item item = new Item();
            item.name = line.split("=")[0];
            //System.out.println(item.name);
            item.weight = Integer.parseInt(line.split("=")[1]);
            loadedItems.add(item);
            //System.out.println(loadedItems);
        }
        //System.out.println(Arrays.toString(loadedItems.toArray()));
        return loadedItems;
    }

    ArrayList loadU1() {
        U1 u1 = new U1();
        Item item = new Item();
        for (int i = 0; i <loadedItems.size(); i++){
            item = (Item) loadedItems.get(i);
            if (!u1.canCarry(item)){
                u1Rockets.add(u1);
//                System.out.println("item packed:"+i);
//                System.out.println("rocket weight:"+u1.loadedWeight);
//                System.out.println("It was "+ u1Rockets.size() + " rocket");
                u1 = new U1();
            }
            u1.loadedWeight += item.weight;
        }
        u1Rockets.add(u1);
//        System.out.println("rocket weight:"+u1.loadedWeight);
//        System.out.println("It was "+ u1Rockets.size() + " rocket");
        return u1Rockets;
    }

    ArrayList loadU2() {
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

        for (int i = 0; i < rockets.size(); i++) {
            Rocket singleRocket = (Rocket) rockets.get(i);
            if (!singleRocket.launch() || !singleRocket.land()) {
                i--;
                //System.out.println("kabooom");
            }
            totalBudget += singleRocket.cost;
            //System.out.println("budget: " + totalBudget);

        }
        //System.out.println(totalBudget);
        return totalBudget;
    }
}


