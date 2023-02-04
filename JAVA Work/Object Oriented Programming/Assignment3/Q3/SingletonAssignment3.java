import java.util.ArrayList;
import java.util.List;

public class SingletonAssignment3 {

    private static List<SingletonAssignment3> instances = new ArrayList<SingletonAssignment3>();

    private SingletonAssignment3() {}

    public static SingletonAssignment3 createInstance() {
        if (instances.size() < 3) {
            instances.add(new SingletonAssignment3());
            System.out.println("Instance_created_at:" + System.currentTimeMillis());
        } else {
            System.out.println("You cannot create more than three instances");
        }
        return instances.get(instances.size()-1);
    }
}
