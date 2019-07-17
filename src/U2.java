public class U2 extends Rocket{
    {   //see U1
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
        loadedWeight = weight;
    }

    public boolean launch() {

        double random = Math.random() * 100 + 1;
        double launchExpChance = 4 * ((double)(loadedWeight - weight) / (maxWeight - weight));
        if (random < launchExpChance) {
            return false;
        }
        else
            return true;
    }
    public boolean land() {
        double random = Math.random() * 100 + 1;
        double landExpChance = 8 * ((double)(loadedWeight - weight) / (maxWeight - weight));
        if (random < landExpChance)
            return false;
        else
            return true;
    }
}