package com.dhas.diarygenerator.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChemotherapyScheme {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void getCircularScheme(String dateOfHospitalisation, Drugs drugChoice, int schemeDuration) throws ParseException {
        Calendar initialDate = Calendar.getInstance();
        initialDate.setTime(sdf.parse(dateOfHospitalisation));

        Calendar processingDate = Calendar.getInstance();
        processingDate.setTime(sdf.parse(dateOfHospitalisation)); //парсим объект календаря в строку

        Calendar dischargeDate = Calendar.getInstance();
        dischargeDate.setTime(sdf.parse(dateOfHospitalisation));
        dischargeDate.add(Calendar.DATE, schemeDuration);

        int i = 0; //итератор по массивам с кол-вом добавляемых дней

        while (processingDate.compareTo(dischargeDate) <= 0) {
            int[] cycles = SchemePeriods.getPeriodByDate(initialDate);

            ChemotherapyScheme.printDateAndRounds(processingDate, dischargeDate);
            ChemotherapyScheme.printTherapyEntry(processingDate, initialDate, dischargeDate, drugChoice);

            if (schemeDuration == 1) { //обработка однодневного случая в т.ч. пятничного
                if (drugChoice.getTwoDrugsScheme()) {
                    ChemotherapyScheme.printTherapyEntry(dischargeDate, initialDate, dischargeDate, drugChoice);
                }
                Diary.getDiaryEntry(false);

                if (isFriday(processingDate)) {
                    processingDate.add(Calendar.DATE, 3);
                } else {
                    processingDate.add(Calendar.DATE, 1);
                }
                System.out.println();
                ChemotherapyScheme.printDateAndRounds(processingDate, dischargeDate);
                Diary.getDiaryEntry(true);
                break;
            }

            Diary.getDiaryEntry(isDischargeDay(processingDate, dischargeDate)); //дневник выписочный если день последний

            processingDate.add(Calendar.DATE, cycles[i]);
            System.out.println();

            i++;

            if (i == cycles.length) {
                i = 0;
            }
        }
    }

    public static void printTherapyEntry(Calendar processingDate, Calendar initialDate, Calendar dischargeDate, Drugs drugChoice) {
        if (processingDate.equals(initialDate)) { //курс терапии в случае дня поступления

            Diary.getTherapyEntry(drugChoice);

        } else if (processingDate.get(Calendar.DAY_OF_WEEK) == initialDate.get(Calendar.DAY_OF_WEEK)
                && (drugChoice == Drugs.DOXORUBICINE || drugChoice == Drugs.BCG)) {

            Diary.getTherapyEntry(drugChoice);

        } else if (isDischargeDay(processingDate, dischargeDate) && (drugChoice == Drugs.DOCETAXEL_DEGARELIX)) {

            Diary.getTherapyEntry(Drugs.DEGARELIX);

        } else if (isDischargeDay(processingDate, dischargeDate) && (drugChoice == Drugs.DOCETAXEL_GOSERELIN)) {

            Diary.getTherapyEntry(Drugs.GOSERELIN);

        } else if (isDischargeDay(processingDate, dischargeDate) && (drugChoice == Drugs.DEGARELIX_DOCETAXEL)) {

            Diary.getTherapyEntry(Drugs.DOCETAXEL_DEGARELIX);

        } else if (isDischargeDay(processingDate, dischargeDate) && (drugChoice == Drugs.CABAZITAXEL_DEGARELIX)) {

            Diary.getTherapyEntry(Drugs.DEGARELIX);

        } else if (isDischargeDay(processingDate, dischargeDate) && (drugChoice == Drugs.DEGARELIX_CABAZITAXEL)) {

            Diary.getTherapyEntry(Drugs.CABAZITAXEL);
        }
    }

    public static void printDateAndRounds(Calendar processingDate, Calendar dischargeDate) {
        if (isFriday(processingDate)) { //обход с зав. в случае пятницы
            System.out.println(sdf.format(processingDate.getTime()) + Diary.getHeadOfDepartmentRounds());

        } else {
            System.out.println(sdf.format(processingDate.getTime()));
        }
    }

    public static boolean isDischargeDay(Calendar processingDate, Calendar dischargeDate) {
        return processingDate.equals(dischargeDate);
    }

    public static boolean isFriday(Calendar processingDate) {
        return processingDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
    }
}
