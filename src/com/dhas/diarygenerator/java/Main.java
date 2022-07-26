package com.dhas.diarygenerator.java;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату госпитализации в формате dd-MM-yyyy ");
        String inputtedDateOfHospitalisation = scanner.nextLine();

        System.out.println("Выберите препарат, 1 - Доксорубицин, 2 - Имуронвак, 3 - Доцетаксел, 4 - Трипторелин ");
        int drugChoice = scanner.nextInt();

        while (drugChoice != 1 && drugChoice != 2 && drugChoice != 3 && drugChoice != 4) {

            System.out.println("Ошибка при выборе препарата. Повторите ввод.");

            drugChoice = scanner.nextInt();

        }

        System.out.println("Выберите продолжительность схемы 1, 7 или 14 дней ");
        int chemotherapyDuration = scanner.nextInt();

        while (chemotherapyDuration != 1 && chemotherapyDuration != 7 && chemotherapyDuration != 14) {

            System.out.println("Ошибка при выборе продолжительности терапии. Повторите ввод.");

            chemotherapyDuration = scanner.nextInt();

        }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        OutputStream teeStream = new TeeOutputStream(System.out, buffer);//После этой строки весь вывод хранится в buffer
        System.setOut(new PrintStream(teeStream));

        //определяем день недели, предварительно переводим в Date
        Date dateOfWeekToDateParser = new SimpleDateFormat("dd-MM-yyyy").parse(inputtedDateOfHospitalisation);
        Calendar c = Calendar.getInstance();
        c.setTime(dateOfWeekToDateParser);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);


        switch (dayOfWeek) {

            case 2 ->
                    ChemotherapyScheme.getSchemeMonday(inputtedDateOfHospitalisation, drugChoice, chemotherapyDuration);
            case 3 ->
                    ChemotherapyScheme.getSchemeTuesday(inputtedDateOfHospitalisation, drugChoice, chemotherapyDuration);
            case 4 ->
                    ChemotherapyScheme.getSchemeWednesday(inputtedDateOfHospitalisation, drugChoice, chemotherapyDuration);
            case 5 ->
                    ChemotherapyScheme.getSchemeThursday(inputtedDateOfHospitalisation, drugChoice, chemotherapyDuration);
            case 6 ->
                    ChemotherapyScheme.getSchemeFriday(inputtedDateOfHospitalisation, drugChoice, chemotherapyDuration);

            case 1, 7 -> System.out.println("Вы ввели дату выходного дня.");

        }

        //сохраняем buffer в файл
        try (OutputStream fileStream = new FileOutputStream("diary.txt")) {

            buffer.writeTo(fileStream);

        }
    }
}
