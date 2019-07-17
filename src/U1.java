public class U1 extends Rocket {
    {
        //changing data for type of rocket
        cost = 100;
        weight = 10000;
        maxWeight = 18000;
        loadedWeight = weight;
    }
    public boolean launch() {
        // random variable to get a random value
        // // // // // // ask if it should be +1 or not
        double random = Math.random() * 100 + 1;
        double launchExpChance = 5 * ((double)(loadedWeight - weight) / (maxWeight - weight));

        if (random < launchExpChance)
            return false;
        else
            return true;
    }
    public boolean land() {
        // same as launch - could be done by one method
        double random = Math.random() * 100 + 1;
        double landExpChance = 1 * ((double)(loadedWeight - weight) / (maxWeight - weight));
        if (random < landExpChance)
            return false;
        else
            return true;
    }
}