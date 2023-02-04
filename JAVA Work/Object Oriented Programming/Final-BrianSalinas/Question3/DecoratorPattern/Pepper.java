public class Pepper extends PizzaDecorator{
    public Pepper(Pizza p){
        super(p);
    }
    @Override
    public void getPizza(){
        super.getPizza();
        System.out.print(" With Pepper");
    }
}
