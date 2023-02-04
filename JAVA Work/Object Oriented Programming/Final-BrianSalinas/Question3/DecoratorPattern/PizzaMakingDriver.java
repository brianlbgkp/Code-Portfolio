public class PizzaMakingDriver {
    public static void main(String[] args){
        Pizza loadedPizza = new Mushroom(new Olive(new Pepper(new BasicPizza())));
        loadedPizza.getPizza();
    }
}
