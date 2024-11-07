import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;
import java.util.Scanner;

public class con {
    public static Scanner inp = new Scanner(System.in);
    public static Random rand = new Random();

    public static JSONObject main = new JSONObject();
    public static JSONArray stars = new JSONArray();
    public static JSONArray worms = new JSONArray();



    public static int min(int factor){
        return switch (factor) {
            case 1 -> 1;
            case 2 -> 3;
            case 3 -> 5;
            case 4 -> 7;
            case 5 -> 10;
            default -> 3;
        };
    }
    public static int bound(int factor)
    {
        return switch (factor) {
            case 1 -> 3;
            case 2 -> 5;
            case 3 -> 8;
            case 4 -> 10;
            case 5 -> 15;
            default -> 5;
        };
    }


}
