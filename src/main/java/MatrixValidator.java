public class MatrixValidator {
    static boolean has_two_number(String[] input) {
        if (input.length > 1 && input.length < 3) {
            return true;
        } else {
            return false;
        }
    }

    static MyError isOK(String rowandline) {
        String[] ral = rowandline.split(" ");
        if (!has_two_number(ral)) {
            return new MyError("Incorrect mesh size");
        }
        if (!isNumeric(ral[0]) || !isNumeric(ral[1]))
            return new MyError("Incorrect mesh size");
        if (!isSizeInRange(ral))
            return new MyError("Incorrect mesh size");
        return null;
    }

    static boolean isSizeInRange(String[] str) {
        int row = Integer.parseInt(str[0]);
        int line = Integer.parseInt(str[1]);
        if (row > 0 && row <= 100 && line > 0 && line <= 100) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }
}
