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

            if (processingDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) { //обход с зав. в случае пятницы
                System.out.println(sdf.format(processingDate.getTime()) + Diary.getHeadOfDepartmentRounds());

            } else {
                System.out.println(sdf.format(processingDate.getTime()));
            }

            ChemotherapyScheme.printTherapyEntry(processingDate, initialDate, dischargeDate, drugChoice);

            if (schemeDuration == 1) { //обработка однодневного случая в т.ч. пятничного
                if (drugChoice == Drugs.DOCETAXEL_GOSERELIN || drugChoice == Drugs.DOCETAXEL_DEGARELIX || drugChoice == Drugs.DEGARELIX_DOCETAXEL || drugChoice == Drugs.DEGARELIX_CABAZITAXEL || drugChoice == Drugs.CABAZITAXEL_DEGARELIX) {
                    ChemotherapyScheme.printTherapyEntry(dischargeDate, initialDate, dischargeDate, drugChoice);
                }
                Diary.getDiaryEntry(false);

                if (processingDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                    processingDate.add(Calendar.DATE, 3);
                } else {
                    processingDate.add(Calendar.DATE, 1);
                }
                System.out.println();
                System.out.println(sdf.format(processingDate.getTime()));
                Diary.getDiaryEntry(true);
                break;
            }

            Diary.getDiaryEntry(processingDate.equals(dischargeDate)); //дневник выписочный если день последний

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

        } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.DOCETAXEL_DEGARELIX)) {

            Diary.getTherapyEntry(Drugs.DEGARELIX);

        } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.DOCETAXEL_GOSERELIN)) {

            Diary.getTherapyEntry(Drugs.GOSERELIN);

        } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.DEGARELIX_DOCETAXEL)) {

            Diary.getTherapyEntry(Drugs.DOCETAXEL_DEGARELIX);

        } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.CABAZITAXEL_DEGARELIX)) {

            Diary.getTherapyEntry(Drugs.DEGARELIX);

        } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.DEGARELIX_CABAZITAXEL)) {

            Diary.getTherapyEntry(Drugs.CABAZITAXEL);
        }
    }
}
