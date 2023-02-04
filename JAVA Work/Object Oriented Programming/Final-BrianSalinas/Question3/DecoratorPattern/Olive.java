public class Olive extends PizzaDecorator{
    public Olive(Pizza p){
        super(p);
    }
    @Override
    public void getPizza(){
        super.getPizza();
        System.out.print(" With Olive");
    }
}
