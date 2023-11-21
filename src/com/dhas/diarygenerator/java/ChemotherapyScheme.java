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

            if (processingDate.equals(initialDate)) { //курс терапии в случае дня поступления

                Diary.getTherapy(drugChoice);

            } else if (processingDate.get(Calendar.DAY_OF_WEEK) == initialDate.get(Calendar.DAY_OF_WEEK)
                    && drugChoice == Drugs.DOXORUBICINE || drugChoice == Drugs.BCG) {

                Diary.getTherapy(drugChoice);

            } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.DOCETAXEL_DEGARELIX)) {

                Diary.getTherapy(Drugs.DEGARELIX);

            } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.DEGARELIX_DOCETAXEL)) {

                Diary.getTherapy(Drugs.DOCETAXEL_DEGARELIX);

            } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.CABAZITAXEL_DEGARELIX)) {

                Diary.getTherapy(Drugs.DEGARELIX);

            } else if (processingDate.equals(dischargeDate) && (drugChoice == Drugs.DEGARELIX_CABAZITAXEL)) {

                Diary.getTherapy(Drugs.CABAZITAXEL);
            }

            if (schemeDuration == 1) { //обработка однодневного случая в т.ч. пятничного
                Diary.getDiary(false);

                if (processingDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                    processingDate.add(Calendar.DATE, 3);
                } else {
                    processingDate.add(Calendar.DATE, 1);
                }

                System.out.println();
                System.out.println(sdf.format(processingDate.getTime()));
                Diary.getDiary(true);
                break;
            }

            Diary.getDiary(processingDate.equals(dischargeDate)); //дневник выписочный если день последний

            processingDate.add(Calendar.DATE, cycles[i]);
            System.out.println();

            i++;

            if (i == cycles.length) {
                i = 0;
            }
        }
    }
}



