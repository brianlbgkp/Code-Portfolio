public class City {

    int population, area;
    String name;

    public City(int population, int area, String name){
        this.population = population;
        this.area = area;
        this.name = name;
    }

    public String getInfo(){
        String details = "[name: " + name + ", area: " + area + ", population: " + population + "]";
        return details;
    }
}

class Nation {
    int population;
    String name;
    City capital;

    public Nation(int population, String name, City capital){
        this.population = population;
        this.name = name;
        this.capital = capital;
    }

    public void getInfo(){
        System.out.println("Name of nation: " + name + ", with a population of: " + population + ", who's capital is: " + capital.getInfo());
    }
}