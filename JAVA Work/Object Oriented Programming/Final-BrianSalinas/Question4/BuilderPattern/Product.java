public class Product {
    private int Part1;
    private int Part2;
    private int Part3;
    private int Part4;

    private int getPart1(){
        return Part1;
    }

    private int getPart2(){
        return Part2;
    }

    private int getPart3(){
        return Part3;
    }

    private int getPart4(){
        return Part4;
    }

    public void getResult(){
        System.out.println(String.format("Part1= %d Part2= %d Part3= %d Part4= %d", this.getPart1(), this.getPart2(), this.getPart3(), this.getPart4()));
    }

    private Product(PartsBuilder builder){
        this.Part1 = builder.Part1;
        this.Part2 = builder.Part2;
        this.Part3 = builder.Part3;
        this.Part4 = builder.Part4;
    }

    public static class PartsBuilder{
        private int Part1;
        private int Part2;
        private int Part3;
        private int Part4;

        public PartsBuilder(int part1, int part2, int part3, int part4){
            this.Part1 = part1;
            this.Part2 = part2;
            this.Part3 = part3;
            this.Part4 = part4;
        }

        public Product build(){
            return new Product(this);
        }
    }
}
