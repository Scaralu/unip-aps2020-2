package utils;

import java.util.List;

public class Print {
    public static String array(List<Integer> arr) {
        int n = arr.size();
        String arrayCompl = "";

        for (int i = 0; i < n; ++i) {
            arrayCompl = arr.stream().map((item) -> item.toString() + "   ").reduce(arrayCompl, String::concat);
        }

        return arrayCompl;
    }
}
