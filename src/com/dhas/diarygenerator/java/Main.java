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

        System.out.println("������� ���� �������������� � ������� dd-MM-yyyy ");
        String inputtedDateOfHospitalisation = scanner.nextLine();

        System.out.println("�������� ��������, 1 - ������������, 2 - ���������, 3 - ����������, 4 - ����������� ");
        int drugChoice = scanner.nextInt();

        while (drugChoice != 1 && drugChoice != 2 && drugChoice != 3 && drugChoice != 4) {

            System.out.println("������ ��� ������ ���������. ��������� ����.");

            drugChoice = scanner.nextInt();

        }

        System.out.println("�������� ����������������� ����� 1, 7 ��� 14 ���� ");
        int chemotherapyDuration = scanner.nextInt();

        while (chemotherapyDuration != 1 && chemotherapyDuration != 7 && chemotherapyDuration != 14) {

            System.out.println("������ ��� ������ ����������������� �������. ��������� ����.");

            chemotherapyDuration = scanner.nextInt();

        }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        OutputStream teeStream = new TeeOutputStream(System.out, buffer);//����� ���� ������ ���� ����� �������� � buffer
        System.setOut(new PrintStream(teeStream));

        //���������� ���� ������, �������������� ��������� � Date
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

            case 1, 7 -> System.out.println("�� ����� ���� ��������� ���.");

        }

        //��������� buffer � ����
        try (OutputStream fileStream = new FileOutputStream("diary.txt")) {

            buffer.writeTo(fileStream);

        }
    }
}
