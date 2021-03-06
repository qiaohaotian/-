import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.substring;

public class Change {
    private static String reverseString(String str) {

        return new StringBuffer(str).reverse().toString();
    }

    public static List<String> reverseString(List<String> str) {
        for (int i = 0; i < str.size(); i++) {
            if (i % 2 != 0) {
                Collections.replaceAll(str, str.get(i), reverseString(str.get(i)));
            }
        }
        return str;
    }

    public static List<String> replaceW(List<String> str) {
        char[][] map = changeToChar(str);
        List<Pair> pair = new ArrayList<Pair>();
        pair = Change.get_D_coordinate(map);
        set_point_warning(map, pair);
        List<String> terrain = new ArrayList<String>();
        for (int i = 0; i < map.length; i++) {
            terrain.add(String.valueOf(map[i]));
        }
        return terrain;
    }

    public static void set_point_warning(char[][] map, List<Pair> pairlist) {
        for (int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++) {
                if (a == 0 && b == 0) {
                    continue;
                }
                change_W_limited(map, pairlist, a, b);
            }
        }
    }

    protected static void change_W_limited(char[][] map, List<Pair> pairlist, int a, int b) {
        int max_x = map.length;
        int max_y = map[0].length;
        for (int i = 0; i < pairlist.size(); i++) {
            Pair<Integer, Integer> pair = pairlist.get(i);
            int x = pair.getKey() + a;
            int y = pair.getValue() + b;
            if (is_in_range(x, y, max_x, max_y) && is_not_D(x, y, pairlist)) {
                System.out.println("ssss");
                map[x][y] = 'W';
                System.out.println(map[x][y]);
            }
        }
    }

    private static boolean is_not_D(int x, int y, List<Pair> pairlist) {
        for (Pair<Integer, Integer> p : pairlist) {
            if (x == p.getKey() && y == p.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static char[][] changeToChar(List<String> str) {
        char[][] result = new char[str.size()][str.get(0).length()];
        for (int i = 0; i < str.size(); i++) {
            result[i] = str.get(i).toCharArray();
        }
        return result;
    }

    public static List<Pair> get_D_coordinate(char[][] map) {
        List<Pair> row = new ArrayList<Pair>();
        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(1, 1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'D') {
                    row.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }
        return row;
    }

    public static List<String> splitStrList(String inputString, int length, int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length, (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    public static boolean is_in_range(int key, int value, int max_x, int max_y) {
        if (key >= 0 && key < max_x && value >= 0 && value < max_y) {
            return true;
        }
        return false;
    }
}
