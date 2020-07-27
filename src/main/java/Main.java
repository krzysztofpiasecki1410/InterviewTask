import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileParseUtils fpu = new FileParseUtils();
        Map<String, TextRowRepresentation> result =  fpu.parse(fpu.getClass().getClassLoader().getResourceAsStream("zadanie.txt"));
        MapUtils.printMapCustomWay(result);
    }

}
