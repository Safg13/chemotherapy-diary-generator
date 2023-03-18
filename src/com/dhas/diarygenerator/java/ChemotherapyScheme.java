package com.dhas.diarygenerator.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChemotherapyScheme {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void getCircularScheme(String dateOfHospitalisation, String drugChoice, int schemeDuration) throws ParseException {
        Calendar initialDate = Calendar.getInstance();
        initialDate.setTime(sdf.parse(dateOfHospitalisation));

        Calendar processingDate = Calendar.getInstance();
        processingDate.setTime(sdf.parse(dateOfHospitalisation)); //парсим объект календаря в строку

        Calendar dischargeDate = Calendar.getInstance();
        dischargeDate.setTime(sdf.parse(dateOfHospitalisation));
        dischargeDate.add(Calendar.DATE, schemeDuration);

        Calendar finishDate = Calendar.getInstance();
        finishDate.setTime(sdf.parse(dateOfHospitalisation));
        finishDate.add(Calendar.DATE, schemeDuration + 1);

        int i = 0; //итератор по массивам с кол-вом добавляемых дней

        while (processingDate.before(finishDate)) {
            int[] cycles = SchemePeriods.getPeriodByDate(initialDate);

            if (processingDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {

                System.out.println(sdf.format(processingDate.getTime()) + Diary.getHeadOfDepartmentRounds());
            } else {

                System.out.println(sdf.format(processingDate.getTime()));
            }

            if (processingDate.equals(initialDate)) {

                Diary.getTherapy(drugChoice);

            } else if (processingDate.get(Calendar.DAY_OF_WEEK) == initialDate.get(Calendar.DAY_OF_WEEK)
                    && (drugChoice.equals("1") || drugChoice.equals("2"))) {

                Diary.getTherapy(drugChoice);

            } else if (processingDate.equals(dischargeDate) && (drugChoice.equals("6"))) {

                Diary.getTherapy("5");
            } else if (processingDate.equals(dischargeDate) && (drugChoice.equals("7"))) {

                Diary.getTherapy("6");
            } else if (processingDate.equals(dischargeDate) && (drugChoice.equals("8"))) {

                Diary.getTherapy("5");
            } else if (processingDate.equals(dischargeDate) && (drugChoice.equals("9"))) {

                Diary.getTherapy("4");
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



