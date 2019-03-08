import java.util.*; 

public class RTasgmt1 extends Thread{



    public static Scanner scan;

	public static void main(String[]args){
        System.out.println("                   ==================================");
        System.out.println("                   ||  Software Effort Estimation  ||");
        System.out.println("                   ==================================");
        System.out.println("");
        System.out.println("");
        userInput();
    }

    public static void userInput(){
        scan = new Scanner(System.in);

        try{
            //---------------- Calculate Weighted Actors ---------------------
            int WeightAct [] = new int [3];
            System.out.println("1. Weighting Actors for Complexity");
            System.out.println("Please input the quantity for each actor type.");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("[Actor Type |              Description                 | Weight Factor |  Quantity  ]");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("|  Simple   |              Defined API                 |       1       |     ");
            WeightAct[0] = scan.nextInt();
            System.out.print("|  Average  | Interactive or Protocol driven interface |       2       |     ");
            WeightAct[1] = scan.nextInt();
            System.out.print("|  Complex  |          Graphical User Interface        |       3       |     ");
            WeightAct[2] = scan.nextInt();
            System.out.println("-------------------------------------------------------------------------------------");
            int weightAct = Calculation.calWeightActor(WeightAct[0], WeightAct[1], WeightAct[2]);
            System.out.println("");
            System.out.println("Total Actor Points : " + weightAct);
            System.out.println("=====================================================================================================================");
            System.out.println("");


            //----------- Calculate Weighted Use Cases -----------
            int WeightUC [] = new int [3];
            System.out.println("2. Weighting Use Cases for Complexity");
            System.out.println("Please input the quantity for each use case type.");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("[Use Case Type |         Description             | Weight Factor |   Quantity  ]");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("|  Simple      |     3 or fewer transactions     |       5       |     ");
            WeightUC[0] = scan.nextInt();
            System.out.print("|  Average     |       4 to 7 transactions       |       10      |     ");
            WeightUC[1] = scan.nextInt();
            System.out.print("|  Complex     |   Greater than 7 transactions   |       15      |     ");
            WeightUC[2] = scan.nextInt();
            System.out.println("--------------------------------------------------------------------------------");
            int weightUC = Calculation.calWeightUC(WeightUC[0], WeightUC[1], WeightUC[2]);
            System.out.println("");
            System.out.println("Total Use Case : " + weightUC);
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //--------------- Calculate Unadjusted Use Case Points (UUCP) ------------------
            int uucp = weightAct + weightUC ;
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| Weighted Actors + Weighted Use Cases = Unadjusted Use Case Points(UUCP) |");
            System.out.printf("| Unadjusted Use Case Points : %-42d |\n", uucp);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("===========================================================================");
            System.out.println("");

            //--------------- Calculate Technical Factors -----------------------
            double WeightTF [] = new double[13];
            System.out.println("3. Weighting Technical Factors");
            System.out.println("Rate each factor from 0 to 5.");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("[ Technical Type  |              Factor Description                   | Weight Factor |  Project Rating (0 to 5) ]");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.print("|       T1        |         Must have a distributed solution          |       2       |            ");
            WeightTF[0] = scan.nextDouble();
            System.out.print("|       T2        |  Must respond to specific performance objectives  |       1       |            ");
            WeightTF[1] = scan.nextDouble();
            System.out.print("|       T3        |       Must meet end-user efficiency desire        |       1       |            ");
            WeightTF[2] = scan.nextDouble();
            System.out.print("|       T4        |           Complex internal processing             |       1       |            ");
            WeightTF[3] = scan.nextDouble();
            System.out.print("|       T5        |              Code must be reusable                |       1       |            ");
            WeightTF[4] = scan.nextDouble();
            System.out.print("|       T6        |              Must be easy to install              |       .5      |            ");
            WeightTF[5] = scan.nextDouble();
            System.out.print("|       T7        |               Must be easy to use                 |       .5      |            ");
            WeightTF[6] = scan.nextDouble();
            System.out.print("|       T8        |                 Must be portable                  |       2       |            ");
            WeightTF[7] = scan.nextDouble();
            System.out.print("|       T9        |               Must be easy to change              |       1       |            ");
            WeightTF[8] = scan.nextDouble();
            System.out.print("|       T10       |             Must allow concurrent users           |       1       |            ");
            WeightTF[9] = scan.nextDouble();
            System.out.print("|       T11       |         Includes special security features        |       1       |            ");
            WeightTF[10] = scan.nextDouble();
            System.out.print("|       T12       |     Must provide direct access for 3rd parties    |       1       |            ");
            WeightTF[11] = scan.nextDouble();
            System.out.print("|       T13       |     Requires special user training facilities     |       1       |            ");
            WeightTF[12] = scan.nextDouble();
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            double tFactor = Calculation.calTFactor(WeightTF);
            System.out.println("TFactor : " + tFactor);
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //-------- Calculate Technical Complexity Factor (TCF) & Size of the sofware (Use case)/ (SzUC) -----------------
            double tcf = ((0.01*tFactor)+0.6);
            double szuc = uucp*tcf;
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.printf("| Technical Complexity Factor (TCF) : %.2f TCF |\n", tcf);
            System.out.println("|----------------------------------------------|");
            System.out.printf("| Size of the sofware (Use case) : %.2f       |\n", szuc);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");

            //----------------------- Calculate Experience Factors (EF) --------------------------------
            double WeightEF [] = new double [8];
            System.out.println("4. Weighting Experience Factors");
            System.out.println("Rate each factor from 0 to 5.");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println("[ Experience Factor  |              Factor Description                   | Weight Factor |  Project Rating (0 to 5) ]");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.print("|         E1         |        Familiar with FPT software process         |       1       |            ");
            WeightEF[0] = scan.nextDouble();
            System.out.print("|         E2         |              Application experience               |      0.5      |            ");
            WeightEF[1] = scan.nextDouble();
            System.out.print("|         E3         |              Paradigm experience (OO)             |       1       |            ");
            WeightEF[2] = scan.nextDouble();
            System.out.print("|         E4         |              Lead analyst capability              |      0.5      |            ");
            WeightEF[3] = scan.nextDouble(); 
            System.out.print("|         E5         |                    Motivation                     |       0       |            ");
            WeightEF[4] = scan.nextDouble();
            System.out.print("|         E6         |                Stable Requirements                |       2       |            ");
            WeightEF[5] = scan.nextDouble();
            System.out.print("|         E7         |                 Part-time workers                 |      -1       |            ");
            WeightEF[6] = scan.nextDouble();
            System.out.print("|         E8         |        Difficulty of programming language         |      -1       |            ");
            WeightEF[7] = scan.nextDouble();
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            double eFactor = Calculation.calEFactor(WeightEF);
            System.out.println("Efactor : " + eFactor);
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //----------- Calculate EF & UCP ---------------------
            double ef = ((-0.03)*eFactor)+1.4;
            double ucp = szuc*ef;   //ucp = size of software(use case)* experience factor
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.printf("| Experience Factor(EF) : %.2f    |\n", ef);
            System.out.println("|---------------------------------|");
            System.out.printf("| Use Case Points (UCP) : %.3f  |\n", ucp);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //------------------- Calculate Man-hours from UCP -----------------------------
            int er;
            System.out.println("5. Calculating Man-hours from UCP");
            System.out.println("");
            System.out.println("Please enter the effort rate(ER).");
            System.out.print("Effort Rate : ");
            er = scan.nextInt();
            double totalMH = er*ucp;  //total man-hours = effort rate * use case point
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| Effort Rate(ER) * Use Case Points(UCPs) = total man-hours |");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("| Total Man-hours : %.3f                                |\n", totalMH);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //-------------------- Calculate Adjusted man-hours ------------------------------
            double percent;
            System.out.println("6. Adjusting Man-hours for Risk");
            System.out.println("");
            System.out.print("Enter a coefficient as a percentage : ");
            percent = scan.nextDouble();
            double adjustMH = (1.0 + percent)* totalMH; //adjusted man-hours = (1.0 + .xx[%])*total man-hours
            System.out.println("");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.printf("| Adjusted man-hours : %.2f |\n", adjustMH);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("=====================================================================================================================");
            System.out.println("");

            //-------------------- Calculate Report Man-hour Estimate ---------------------
            int Quantity [] = new int[3];
            int Average [] = new int[3];
            System.out.println("7. Weighting Reports for Complexity");
            System.out.println("");
            System.out.println("Report type: Simple");
            System.out.println("--------------------");
            System.out.print("Quantity          : ");
            Quantity[0] = scan.nextInt();
            System.out.print("Average Man-hours : ");
            Average[0] = scan.nextInt();
            System.out.println("");
            System.out.println("");
            System.out.println("Report type: Average");
            System.out.println("---------------------");
            System.out.print("Quantity          : ");
            Quantity[1]= scan.nextInt();
            System.out.print("Average Man-hours : ");
            Average[1] = scan.nextInt();
            System.out.println("");
            System.out.println("");
            System.out.println("Report type: Complex");
            System.out.println("---------------------");
            System.out.print("Quantity          : ");
            Quantity[2] = scan.nextInt();
            System.out.print("Average Man-hours : ");
            Average[2] = scan.nextInt();
            System.out.println("");
            System.out.println("------------------------------");
            System.out.println("");
            int totalReportMH = Calculation.calReportMH(Quantity, Average);
            System.out.println("Total Report Man-hour Estimate : " + totalReportMH);
            System.out.println("");
            System.out.println("");

            //-------------------- Calculate Total Man-hours ----------------------------
            double totalMh = adjustMH + totalReportMH;   //total man-hours = adjusted man-hours + Reporting man-hours
            System.out.println("==============================");
            System.out.printf("| Total man-hours : %.2f  |\n", totalMh);
            System.out.println("==============================");


        } catch (InputMismatchException e){
            System.out.println("");
            System.out.println("");
            System.out.println("=====================");
            System.out.println("| Input digit only! |");
            System.out.println("=====================");
            System.out.println("");
            userInput();
        }       
    }
}