public class Mushroom extends PizzaDecorator{
    public Mushroom(Pizza p){
        super(p);
    }
    @Override
    public void getPizza(){
        super.getPizza();
        System.out.print(" With Mushroom");
    }
}
