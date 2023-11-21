package com.dhas.diarygenerator.java;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hospitalisation date:");
        String inputtedDateOfHospitalisation = scanner.nextLine();
        String[] parsedDates = getDatesFromString(inputtedDateOfHospitalisation);

        String drugChoice;
        int chemotherapyDuration = 0;

        System.out.println("""
                1 - Doxorubicin\s
                2 - BCG\s
                3 - Docetaxel\s
                4 - Cabazitaxel\s
                5 - Degarelix\s
                6 - Docetaxel + Degarelix\s
                7 - Degarelix + Docetaxel\s
                8 - Cabazitaxel + Degarelix
                9 - Degarelix + Cabazitaxel\s
                or write it manually:""");

        drugChoice = scanner.nextLine();

        while (chemotherapyDuration != 1 && chemotherapyDuration != 7 && chemotherapyDuration != 14) {
            System.out.println("Enter scheme duration 1, 7 or 14 days:");
            chemotherapyDuration = scanner.nextInt();
        }

        try {
            File file = new File("diary.txt"); //создаем текстовый файл

            FileOutputStream fos = new FileOutputStream(file); //создаем поток для записи в файл
            PrintStream ps = new PrintStream(fos);

            System.setOut(ps); //записываем данные из консоли в файл
            ChemotherapyScheme.getCircularScheme(parsedDates[0], drugChoice, chemotherapyDuration);
            Desktop.getDesktop().open(new File("diary.txt")); //открываем файл в приложении по умолчанию
            ps.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to file");
        }
    }

    private static String[] getDatesFromString(String inputedDateAsString) {
        int count = 0;
        String[] allMatches = new String[1]; //количество дат на входной строке (можно добавить дату выписки например)
        Matcher m = Pattern
                .compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d")
                .matcher(inputedDateAsString);

        while (m.find()) {
            allMatches[count] = m.group();
            count++;
        }

        for (int i = 0; i < allMatches.length; i++) {
            allMatches[i] = allMatches[i].replaceAll("/", "-").replaceAll("\\.", "-");
        }

        return allMatches;
    }
}
