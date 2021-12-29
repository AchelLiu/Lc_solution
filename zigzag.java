
import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * solution nums:2729_18
 *
 */



class zigzag {
    public static String zigzag(String s, int numRows) {
        int len = s.length();
        if(len<=numRows){
            return s;
        }
        return s;
    }

    //充分讨论了return 0 的情况
    public String zigzag_official(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }


    public static void main(String args[]){
        String x = "PAYPALISHIRING";
        int n = 4;
        String res = zigzag(x,n);
        System.out.println(res);
    }
}
