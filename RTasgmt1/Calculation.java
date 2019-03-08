public class Calculation{   

    public static int calWeightActor(int a, int b, int c){
        return ((a*1) + (b*2) + (c*3));
    }

    public static int calWeightUC(int x, int y, int z){
        return ((x*5) + (y*10) + (z*15));
    }

    public static double calTFactor(double num1[]){
        double weightTF [] = {2, 1, 1, 1, 1, 0.5, 0.5, 2, 1, 1, 1, 1, 1};
        double sum;
        double total = 0;

        for (int i=0; i<weightTF.length; i++){
            sum = weightTF[i] * num1[i];
            total += sum;
        }
        return total;
    }

    public static double calEFactor(double num2[]){
        double eFactor [] = {1, 0.5, 1, 0.5, 0, 2, -1, -1};
        double sum;
        double total = 0;

        for (int i=0; i<eFactor.length; i++){
            sum = eFactor[i] * num2[i];
            total+=sum;
        }
        return total;
    }

    public static int calReportMH(int quantity[], int average[]){
        int sum;
        int total=0;

        for (int i=0; i<quantity.length; i++){
            sum = quantity[i]*average[i];
            total+=sum;
        }
        return total;
    }
} 