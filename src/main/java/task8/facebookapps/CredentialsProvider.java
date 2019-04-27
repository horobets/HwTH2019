package task8.facebookapps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CredentialsProvider {

    private String fbUsername;
    private String fbPassword;

    public CredentialsProvider() {

        File file = new File("C:\\Users\\hserh\\OneDrive\\Desktop\\fbcredentials.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            /*String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);*/

            fbUsername = br.readLine();
            fbPassword = br.readLine();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public String getFbUsername() {
        return fbUsername;
    }

    public String getFbPassword() {
        return fbPassword;
    }
}
