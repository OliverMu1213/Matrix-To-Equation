import Jama.Matrix;
import java.lang.Math;

public class TwoDMatrix {
    private static double a,b,c;

    public TwoDMatrix(double[][] xy){
        double [][]points = new double[xy.length][3];
        double [][]temp = new double[xy.length][1];
        for(int a = 0;a<xy.length;a++){
            temp[a][0]=xy[a][1];
        }

        for(int i =0; i<xy.length;i++){
            points[i][0]=xy[i][0]*xy[i][0];
            points[i][1]=xy[i][0];
            points[i][2]=1;
        }

        Matrix A = new Matrix(points);
        Matrix Y = new Matrix(temp);

        Matrix AT = A.transpose();
        Matrix ATA = AT.times(A);

        Matrix ATAinverse = ATA.inverse();

        Matrix ATY = AT.times(Y);
        Matrix Result = ATAinverse.times(ATY);

        //System.out.println(strung(A));

        /*System.out.println(strung(AT));
        System.out.println(strung(ATA));
        System.out.println(strung(ATAinverse));
        System.out.println(strung(ATY));*/
        //System.out.println(strung(Result));

         /*a = Math.round(Result.get(0,0));
         b = Math.round(Result.get(1,0));
         c = Math.round(Result.get(2,0));*/

        a = Result.get(0,0);
        b = Result.get(1,0);
        c = Result.get(2,0);

        System.out.print(a+" ");
        System.out.print(b+" ");
        System.out.println(c+" ");

        //System.out.println(a+"x^2+"+b+"x+"+c);
    }

    public static String strung(Matrix m) {
        StringBuffer sb = new StringBuffer();
        for (int r = 0; r < m.getRowDimension(); ++ r) {
            for (int c = 0; c < m.getColumnDimension(); ++c)
                sb.append(m.get(r, c)).append("\t");
            sb.append("\n");
        }
        return sb.toString();
    }

     String GetEquation(){
        return (a+"x^2+"+b+"x+"+c);
    }
}
