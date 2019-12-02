import java.util.ArrayList;

public class EncryptionSys {
    private int mtrSize;
    private char[][] key;


    EncryptionSys(){
        mtrSize = 0;
    }

    public void keyEntry(String inKey){
        double size;
        size = inKey.length();
        double rows = Math.sqrt(size);
        mtrSize = (int) rows;
        key = new char[mtrSize][mtrSize];
        char[] nKey = inKey.toCharArray();

        int k = 0;
        for(int i = 0; i < mtrSize; i++){
            for(int j = 0; j < mtrSize; j++){
                key[i][j] = nKey[k];
                k++;
            }
        }
    }

     void keyGenerate(){
            mtrSize = 10;
            key = new char [mtrSize][mtrSize];
            ArrayList<Integer> generateList = new ArrayList<>();
            int maxSymbolCode = 126;
            int minSymbolCode = 27;
            int code;
            int alphSize = 100;
            char letter;
            int idx = 0;
            while(alphSize != 0){
                code = (int)(Math.random()*((maxSymbolCode-minSymbolCode)+1))+minSymbolCode;
                if(!(generateList.contains(code))) {
                    alphSize--;
                    generateList.add(code);
                }
            }

            for(int i = 0; i < mtrSize; i++){
                for(int j = 0; j < mtrSize; j++){

                    code = generateList.get(idx);
                    letter = (char) code;
                    key[i][j] = letter;
                    idx++;
                }
            }
    }

    int [] encrypt(String inString){

        int lght = inString.length();
        char[] line = inString.toCharArray();
        int[] codeLine = new int[lght];
        int k = 0;
        while(k != lght) {
            for (int i = 0; i < mtrSize; i++) {
                    for (int j = 0; j < mtrSize; j++) {

                            if (line[k] == key[i][j]) {
                                int tmp = i  * 10 + j;
                                codeLine[k] = tmp;
                                k++;
                                if (k == lght) {
                                    i = mtrSize - 1;
                                    break;
                                }
                                i = 0;
                                j = 0;
                            }

                    }
                }

        }
        return (codeLine);
    }

        String decrypt(int [] code){
        int size  = code.length;
        int i;
        int j;
        char [] resLine = new char[size];
       for(int k = 0; k < code.length; k++){

               i = code[k] / 10;
               j = code[k] % 10;
               resLine[k] = key[i][j];

       }
            return(String.copyValueOf(resLine));
    }
    public String toString(){

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < this.mtrSize; i++){
            for(int j = 0; j < this.mtrSize; j++){
                builder.append(key[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
