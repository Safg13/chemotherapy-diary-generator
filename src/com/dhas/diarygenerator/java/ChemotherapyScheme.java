package com.dhas.diarygenerator.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChemotherapyScheme {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void printDiaries(String dateOfHospitalisation, Drugs drugChoice, int schemeDuration, boolean isInverted) throws ParseException {
        Calendar initialDate = Calendar.getInstance();
        initialDate.setTime(sdf.parse(dateOfHospitalisation));

        Calendar processingDate = Calendar.getInstance();
        processingDate.setTime(sdf.parse(dateOfHospitalisation)); //парсим объект календаря в строку

        Calendar dischargeDate = Calendar.getInstance();
        dischargeDate.setTime(sdf.parse(dateOfHospitalisation));
        dischargeDate.add(Calendar.DATE, schemeDuration);

        int i = 0; //итератор по массивам с кол-вом добавляемых дней
        int[] cycles = DaysAndPeriods.getPeriodsByDate(initialDate);

        while (processingDate.compareTo(dischargeDate) <= 0) {
            ChemotherapyScheme.printDateAndRounds(processingDate);
            ChemotherapyScheme.printTherapyEntry(processingDate, initialDate, dischargeDate, drugChoice, isInverted);

            if (schemeDuration == 1) { //обработка однодневного случая в т.ч. пятничного
                if (drugChoice.getIsTwoDrugsScheme()) {
                    ChemotherapyScheme.printTherapyEntry(dischargeDate, initialDate, dischargeDate, drugChoice, isInverted);
                }
                Diary.getDiaryEntry(false);

                processingDate.add(Calendar.DATE, isFriday(processingDate) ? 3 : 1);

                ChemotherapyScheme.printDateAndRounds(processingDate);
                Diary.getDiaryEntry(true);
                break;
            }

            Diary.getDiaryEntry(isDischargeDay(processingDate, dischargeDate)); //дневник выписочный если день последний

            processingDate.add(Calendar.DATE, cycles[i]);

            i = (i + 1) % cycles.length;
        }
    }

    public static void printTherapyEntry(Calendar processingDate, Calendar initialDate, Calendar dischargeDate, Drugs drugChoice, boolean isInverted) {
        if (processingDate.equals(initialDate) && drugChoice.getIsTwoDrugsScheme() && isInverted) {
            System.out.println(drugChoice.getSecondDrug().getDiaryEntry());

        } else if (processingDate.equals(initialDate)) { //курс терапии в случае дня поступления
            System.out.println(drugChoice.getDiaryEntry());

        } else if (isSameDayOfWeek(initialDate, processingDate)
                && (drugChoice.getIsIntravesical())) {
            System.out.println(drugChoice.getDiaryEntry());

        } else if (isDischargeDay(processingDate, dischargeDate) && drugChoice.getIsTwoDrugsScheme() && isInverted) {
            System.out.println(drugChoice.getDiaryEntry());

        } else if (isDischargeDay(processingDate, dischargeDate) && drugChoice.getIsTwoDrugsScheme()) {
            System.out.println(drugChoice.getSecondDrug().getDiaryEntry());
        }
    }

    public static void printDateAndRounds(Calendar processingDate) {
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

    public static boolean isSameDayOfWeek(Calendar firstDate, Calendar secondDate) {
        return firstDate.get(Calendar.DAY_OF_WEEK) == secondDate.get(Calendar.DAY_OF_WEEK);
    }
}
