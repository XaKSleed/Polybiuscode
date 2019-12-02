import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        EncryptionSys firstCode = new EncryptionSys();

        /* System.out.println("Input your key:");
        String inKey = in.nextLine();
        firstCode.keyEntry(inKey);*/

        firstCode.keyGenerate();
        System.out.println(firstCode);

        Scanner in = new Scanner(new File("C:\\Text.txt"));
        StringBuilder inString = new StringBuilder(10);

        while(in.hasNext()){
            inString.append(in.nextLine());
        }
        in.close();
        System.out.println(inString);

        int [] code = firstCode.encrypt(inString.toString());
        int count=0;
        for (int value : code) {
            if(count%30==0)
                System.out.println();
            System.out.print(value + " ");
            count++;
        }
        System.out.println();
        System.out.println(firstCode.decrypt(code));
    }
}
