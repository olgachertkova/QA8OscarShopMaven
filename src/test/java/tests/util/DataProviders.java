package tests.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviders {

    @DataProvider(name="loginNegative")
    public static Object[][] getDataFromDataprovider() {
        return new Object[][]{
                {"OLGA@gmail.com", "qw123456"},
                {" ", "qw123456"},
                {"!@#olga@gmail.com", "qw123456"}

        };
    }


    @DataProvider
    public static Iterator<Object[]> usingDataFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataFile.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> usingCSVFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/login.csv")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(","));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> anotherNegativeLogin() {
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"olga123456789@gmail.com", "olga123456789"});
        data.add(new Object[]{"OLGA123@gmail.com", "olga123456789"});

        return data.iterator();
    }



    @DataProvider
    public Iterator<Object[]> randomUsersString() {

        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 3; ++i) {
            data.add(new Object[]{this.generateRandomNameString(), this.generateRandomPasswordString()});
        }

        return data.iterator();
    }
    static Random gen = new Random();
    private Object generateRandomPasswordString() {return generateRandomWord(8);}

    private Object generateRandomNameString() {
        return generateRandomWord(6);
    }

    public static String generateRandomWord(int strLen)
    {
        String randomStrings = "";
        Random random = new Random();
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < strLen; j++) {
                word[j] = (char)('a' + random.nextInt(26));
                randomStrings = randomStrings + word[j];
            }


        return randomStrings;
    }


    @DataProvider
    public Iterator<Object[]> randomUsers() {
        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 10; ++i) {
            data.add(new Object[]{this.generateRandomName(), this.generateRandomPassword()});
        }

        return data.iterator();
    }

    private Object generateRandomPassword() {
        return "pass" + (new Random()).nextInt();
    }

    private Object generateRandomName() {
        return "demo" + (new Random()).nextInt()+"@gmail.com";
    }


}

