package calculator.advanced.android.fr.advancedcalculator;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Kitchen-PC on 06/02/2018.
 */

public class CalculusServer {


    public static double doOp(double op1, double op2, char op) throws Exception
    {
        switch (op) {

            case '+':
                return op1 + op2;

            case '-':
                return op1 - op2;

            case'*':
                return op1 * op2;

            case '/':
                if (op2 != 0)
                    return op1 / op2;
                else
                    throw new Exception();

            default:
                throw new Exception();
        }

    }



    public static void main(String[] args) throws Exception {

        // Example of a distant calculator
        ServerSocket ssock = new ServerSocket(9876);

        while (true) { // infinite loop
            Socket comm = ssock.accept();
            System.out.println("connection established");

            new Thread(new MyCalculusRunnable(comm)).start();

        }

    }

}
