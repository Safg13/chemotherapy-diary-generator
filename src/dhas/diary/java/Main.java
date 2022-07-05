package dhas.diary.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.commons.io.output.TeeOutputStream;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        System.out.println("Введите дату госпитализации в формате dd-MM-yyyy ");
        Scanner scanner = new Scanner(System.in);
        String inputedDateOfHospitalisation = scanner.nextLine();

        System.out.println("Выберите препарат, 1 - Доксорубицин, 2 - Имуронвак ");
        Scanner scannerDrug = new Scanner(System.in);
        int drugChoice = scannerDrug.nextInt();

        if (drugChoice != 1 && drugChoice != 2) {
            System.out.println("Ошибка при выборе препарата");
        }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        OutputStream teeStream = new TeeOutputStream(System.out, buffer);
        //После этой строки весь вывод хранится в buffer
        System.setOut(new PrintStream(teeStream));

        //определяем день недели, предварительно переводим в Date
        Date dateOfWeekToDateParser = new SimpleDateFormat("dd-MM-yyyy").parse(inputedDateOfHospitalisation);
        Calendar c = Calendar.getInstance();
        c.setTime(dateOfWeekToDateParser);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek) {
            case 2 -> IntravesicalScheme.getSchemeMonday14(inputedDateOfHospitalisation, drugChoice);
            case 3 -> IntravesicalScheme.getSchemeTuesday14(inputedDateOfHospitalisation, drugChoice);
            case 4 -> IntravesicalScheme.getSchemeWednesday14(inputedDateOfHospitalisation, drugChoice);
            case 5 -> IntravesicalScheme.getSchemeThursday14(inputedDateOfHospitalisation, drugChoice);
            case 6 -> IntravesicalScheme.getSchemeFriday14(inputedDateOfHospitalisation, drugChoice);
            case 1, 7 -> System.out.println("Вы ввели дату выходного дня.");
        }
        //сохраняем buffer в файл
        try (OutputStream fileStream = new FileOutputStream("diary.txt")) {
            buffer.writeTo(fileStream);
        }
    }
}
