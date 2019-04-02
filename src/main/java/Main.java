
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String rowandline = input.nextLine();
        String terrain = input.nextLine();
        input.close();
        if(execute(rowandline, terrain)!=null)
            printMatrix(execute(rowandline, terrain));
    }

    protected static List<String> execute(String rowandline, String terrain) {
        if (MatrixValidator.isOK(rowandline)!=null)
            return null;
        int[] matrixSize = getMatrix(rowandline);
        if (TerrainValidator.isOK(terrain, matrixSize)!=null)
            return null;
        int row = matrixSize[0];
        int line = matrixSize[1];
        List<String> finallis = Change.splitStrList(terrain, line,row);
        return Change.replaceW(Change.reverseString(finallis));
    }

    private static void printMatrix(List<String> finallis) {
        for (int i = 0; i < finallis.size(); i++) {
            System.out.println(finallis.get(i));
        }
    }

    private static int[] getMatrix(String rowandline) {
        String[] ral = rowandline.split(" ");
        int[] result = new int[2];
        result[0] = Integer.valueOf(ral[0]);
        result[1] = Integer.valueOf(ral[1]);
        return result;
    }

}
