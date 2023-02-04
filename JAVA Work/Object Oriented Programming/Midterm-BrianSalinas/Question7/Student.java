import java.util.LinkedHashSet;
import java.util.Set;

public class Student {
    private String name;
    private int year;
    private Set<String> courses;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.courses = new LinkedHashSet<String>();
    }

    public void addCourse(String name){
        courses.add(name);
    }

    public void dropAll(){
        courses.clear();
    }

    public int getCourseCount(){
        return courses.size();
    }

    public String getName(){
        return name;
    }

    public double getTuition(){
        return 1450 * courses.size();
    }

    public int getYear(){
        return year;
    }
}


class GradStudent extends Student{

    String advisor;

    public GradStudent(String name, int year, String advisor) {
        super(name, year);
        this.advisor = advisor;
    }

    public int getYear(){
        return super.getYear() + 4;
    }

    public void addCourse(String name){
        if(this.getCourseCount() < 6){
            super.addCourse(name);
        }
    }

    public double getTuition(){
        if(this.getCourseCount() <= 1){
            return 1000;
        } else {
            return super.getTuition() * 2;
        }
    }

    public boolean isBurntOut(){
        if(this.getCourseCount() >= 5 ){
            return true;
        } else if(this.getYear() >= 8){
            return true;
        } else {
            return false;
        }
    }

    public String getAdvisor(){
        return advisor;
    }

}
