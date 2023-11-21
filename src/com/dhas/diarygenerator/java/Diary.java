package com.dhas.diarygenerator.java;

public class Diary {

    final static double BODY_TEMPERATURE_MIN = 36.5; //нижний порог температуры в дневниках
    final static double BODY_TEMPERATURE_MAX = 36.9; //верхний порог температуры в дневниках
    final static double BODY_TEMPERATURE_SCALE = Math.pow(10, 1); //округление температуры в дневниках
    final static int PULSE_MIN = 64; //нижний порог пульса в дневниках
    final static int PULSE_MAX = 78; //верхний порог пульса в дневниках
    final static int SYSTOLIC_PRESSURE_MAX = 135; //верхний порог систолического давления в дневниках
    final static int SYSTOLIC_PRESSURE_MIN = 110; //нижний порог систолического давления в дневниках
    final static int DIASTOLIC_PRESSURE_MAX = 85; // верхний порог диастолического давления в дневниках
    final static int DIASTOLIC_PRESSURE_MIN = 70; //нижний порог диастолического давления в дневниках

    static String getHeadOfDepartmentRounds() {
        return " Совместный обход с зав. отделением Гуриным Э.В.";
    }

    static void getDiary(boolean isDischarged) {

        var bodyTemp = Math.ceil(((Math.random() * (BODY_TEMPERATURE_MAX - BODY_TEMPERATURE_MIN) + BODY_TEMPERATURE_MIN))
                * BODY_TEMPERATURE_SCALE) / BODY_TEMPERATURE_SCALE;
        var pulse = Math.round((Math.random() * (PULSE_MAX - PULSE_MIN)) + PULSE_MIN);

        if (pulse % 2 != 0) {
            pulse = pulse + 1;
        }

        var systolicPressure = Math.round((Math.random() * (SYSTOLIC_PRESSURE_MAX - SYSTOLIC_PRESSURE_MIN)) +
                SYSTOLIC_PRESSURE_MIN);

        while (systolicPressure % 5 != 0) {
            systolicPressure = systolicPressure + 1;
        }

        var diastolicPressure = Math.round((Math.random() * (DIASTOLIC_PRESSURE_MAX - DIASTOLIC_PRESSURE_MIN)) +
                DIASTOLIC_PRESSURE_MIN);

        while (diastolicPressure % 5 != 0) {
            diastolicPressure = diastolicPressure + 1;
        }

        System.out.println("Жалобы на учащенное мочеиспускание. Общее состояние удовлетворительное. Температура тела " + bodyTemp +
                " С." + " Пульс " + pulse + " уд/мин. АД " + systolicPressure + "/" + diastolicPressure + " мм рт. ст. " +
                "Дыхание выслушивается во всех отделах, везикулярное, хрипов нет. Тоны сердца приглушены, ритмичные. " +
                "Кожные покровы чистые, обычной окраски и влажности. Живот при пальпации мягкий, безболезненный. " +
                "Поясничная область при поколачивании безболезненна с обеих сторон. Мочеиспускание свободное, " +
                "безболезненное, диурез достаточный. Стул оформленный. Рекомендации выполняются." +
                (isDischarged ? "\nВыписывается в удовлетворительном состоянии. Рекомендации при выписке даны." : "")
                + "\nЛеч. врач Майстренко Е.В.");
    }

    static void getTherapy(Drugs drugChoice) {
        switch (drugChoice) {
            case DOXORUBICINE ->
                    System.out.println(Drugs.DOXORUBICINE.getDiaryEntry());
            case BCG ->
                    System.out.println(Drugs.BCG.getDiaryEntry());
            case DOCETAXEL, DOCETAXEL_DEGARELIX ->
                    System.out.println(Drugs.DOCETAXEL.getDiaryEntry());
            case CABAZITAXEL, CABAZITAXEL_DEGARELIX ->
                    System.out.println(Drugs.CABAZITAXEL.getDiaryEntry());
            case DEGARELIX, DEGARELIX_DOCETAXEL, DEGARELIX_CABAZITAXEL ->
                    System.out.println(Drugs.DEGARELIX.getDiaryEntry());

            default -> System.out.println("Пациент получил __________ перенес удовлетворительно.");
        }
    }
}
