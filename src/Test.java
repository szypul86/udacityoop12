public class Test {
    public static void main(String[] args){
        U1 u1 = new U1();

        Item i1 = new Item();
        i1.weight = 5;

        System.out.println("rocket max weight: "+u1.maxWeight);

        if(u1.canCarry(i1)) {
            u1.carry(i1);
        }
        else{
            System.out.println("rocket loaded");

        }
        System.out.println("actual rocket weight: "+u1.loadedWeight);

        u1.launch();

        if(u1.launch()){
            System.out.println("we launched");
        }
    }
}
