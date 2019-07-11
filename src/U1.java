public class U1 extends Rocket {
    {
        cost = 100;
        weight = 10000;
        maxWeight = 18000;
        loadedWeight = weight;
    }
    public boolean launch() {

        double random = Math.random() * 100 + 1;
        double launchExpChance = 5 * ((double)(loadedWeight - weight) / (maxWeight - weight));
//        System.out.println("random is:" + random);
//        System.out.println("launchExpChance is:" + launchExpChance);
//        System.out.println("loadedWeight is:" + loadedWeight);
//        System.out.println("weight is:" + weight);
        if (random < launchExpChance) {
            //System.out.println("kaboooom");
            return false;
        }
        else
            return true;
    }
    public boolean land() {
        double random = Math.random() * 100 + 1;
        double landExpChance = 1 * ((double)(loadedWeight - weight) / (maxWeight - weight));
        if (random < landExpChance)
            return false;
        else
            return true;
    }
}