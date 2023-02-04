public class PizzaDecorator implements Pizza{
    protected Pizza pizza;
    public PizzaDecorator(Pizza p){
        this.pizza=p;
    }
    @Override
    public void getPizza(){
        this.pizza.getPizza();
    }
}
