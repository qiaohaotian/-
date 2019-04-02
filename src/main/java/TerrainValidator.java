public class TerrainValidator {
    static MyError isOK(String terrain, int[] matrixSize) {
        if(!isValid_type(terrain))
            return new MyError("Invalid cell type");
        if(!isValid_size(terrain,matrixSize))
            return new MyError("Data mismatch");
        return null;
    }
    static boolean isValid_type(String terrain){
        String[] ar = terrain.split("");

        for (int i = 0; i < ar.length; i++) {
            if (ar[i].equals("G") == false && ar[i].equals("R") == false && ar[i].equals("F") == false&& ar[i].equals("D") == false) {
                return false;
            }
        }
        return true;
    }
    static boolean isValid_size(String terrain,int[] matrixSize){
        int row = matrixSize[0];
        int line = matrixSize[1];
        if (row * line == terrain.length()) {
            return true;
        } else {
            return false;
        }
    }
}
