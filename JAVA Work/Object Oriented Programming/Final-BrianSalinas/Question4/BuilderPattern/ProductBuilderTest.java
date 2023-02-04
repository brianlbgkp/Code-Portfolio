public class ProductBuilderTest {
    public static void main(String[] args){
        Product builder1 = new Product.PartsBuilder(11, 12 , 13, 14).build();
        Product builder2 = new Product.PartsBuilder(21, 22 , 23, 24).build();
        Product builder3 = new Product.PartsBuilder(31, 32 , 33, 34).build();
        Product builder4 = new Product.PartsBuilder(41, 42 , 43, 44).build();

        System.out.println("Builder1: ");
        builder1.getResult();
        System.out.println("Builder2: ");
        builder2.getResult();
        System.out.println("Builder3: ");
        builder3.getResult();
        System.out.println("Builder4: ");
        builder4.getResult();
    }
}
