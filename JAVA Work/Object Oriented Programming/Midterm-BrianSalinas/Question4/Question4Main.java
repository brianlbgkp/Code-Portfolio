public class Question4Main {

    public static void main(String[] args){

        City washington = new City(100000, 500000, "Washington DC");
        Nation unitedStates = new Nation(100000000, "United States of America", washington);

        unitedStates.getInfo();
    }
}
