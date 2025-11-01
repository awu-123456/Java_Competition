import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class day45 {
    public String compressString (String param) {
        int count = 1;
        String result = new String();
        for(int i = 1;i < param.length();i++) {
            if(param.charAt(i) != param.charAt(i-1)) {
                result += param.charAt(i-1);
                if(count != 1) {
                    result += count;
                }
                count = 1;
            } else {
                count++;
            }
        }
        result += param.charAt(param.length()-1);
        if(count != 1) {
            result += count;
        }
        return result;
    }
}
