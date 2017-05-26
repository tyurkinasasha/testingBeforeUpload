package practice.cipher;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CaesarCipher cc = new CaesarCipher(3);
        if (args[0].equals("-d")) {
            File input = new File(args[1]);
            File output = new File(args[2]);
            FileReader fr = new FileReader(input);
            FileWriter fw = new FileWriter(output);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);

            while (br.ready()) {
                bw.write(cc.decode(br.readLine()) + "\n");
                bw.flush();
            }
            br.close();
            bw.close();
        } else {
            File input = new File(args[0]);
            File output = new File(args[1]);

            FileReader fr = new FileReader(input);
            FileWriter fw = new FileWriter(output);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);

            while (br.ready()) {
                bw.write(cc.encode(br.readLine()) + "\n");
                bw.flush();
            }
            br.close();
            bw.close();
        }
    }
}