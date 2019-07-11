public class Rocket implements Spaceship {
    int cost;
    int weight;
    int maxWeight;
    int loadedWeight;

    public boolean launch(){
        return true;
    };

    public boolean land(){
        return true;
    };

    public boolean canCarry(Item item){
        if(loadedWeight + item.weight <= maxWeight){
            return true;
        }
        else {
            return false;
        }
    }
   public void carry(Item item){
       loadedWeight += item.weight;
   };
}
