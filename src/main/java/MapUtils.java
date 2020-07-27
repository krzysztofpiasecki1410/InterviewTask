import java.util.Map;

public class MapUtils {
    public  static void printMapCustomWay(Map<?, ?> map) {
        for(Object key : map.keySet()) {
            System.out.println(key + " - " + map.get(key).toString());
        }
    }
}
