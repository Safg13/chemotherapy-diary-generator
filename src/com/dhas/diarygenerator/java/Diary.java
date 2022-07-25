package com.dhas.diarygenerator.java;

public class Diary {

    static double bodyTempMin = 36.5; //нижний порог температуры в дневниках
    static double bodyTempMax = 36.9; //верхний порог температуры в дневниках
    static double bodyTempScale = Math.pow(10, 1); //округление температуры в дневниках
    static int pulseMin = 64; //нижний порог пульса в дневниках
    static int pulseMax = 78; //верхний порог пульса в дневниках
    static int systolicPressureMax = 135; //верхний порог систолического давления в дневниках
    static int systolicPressureMin = 110; //нижний порог систолического давления в дневниках
    static int diastolicPressureMax = 85; // верхний порог диастолического давления в дневниках
    static int diastolicPressureMin = 70; //нижний порог диастолического давления в дневниках

    static String complaintsLightDysuria = "Жалобы на учащенное мочеиспускание. ";

    static String getHeadOfDepartmentRounds() {
        return " Совместный обход с зав. отделением Гуриным Э.В.";
    }

    static void getDiary(boolean isDischarged) {


        var bodyTemp = Math.ceil(((Math.random() * (bodyTempMax - bodyTempMin) + bodyTempMin)) * bodyTempScale) /
                bodyTempScale;
        var pulse = Math.round((Math.random() * (pulseMax - pulseMin)) + pulseMin);

        if (pulse % 2 != 0) {
            pulse = pulse + 1;
        }

        var systolicPressure = Math.round((Math.random() * (systolicPressureMax - systolicPressureMin)) +
                systolicPressureMin);

        while (systolicPressure % 5 != 0) {
            systolicPressure = systolicPressure + 1;
        }

        var diastolicPressure = Math.round((Math.random() * (diastolicPressureMax - diastolicPressureMin)) +
                diastolicPressureMin);

        while (diastolicPressure % 5 != 0) {
            diastolicPressure = diastolicPressure + 1;
        }

        System.out.println(complaintsLightDysuria + "Общее состояние удовлетворительное. Температура тела " + bodyTemp +
                " С." + " Пульс " + pulse + " уд/мин. АД " + systolicPressure + "/" + diastolicPressure + " мм рт. ст. " +
                "Дыхание выслушивается во всех отделах, везикулярное, хрипов нет. Тоны сердца приглушены, ритмичные. " +
                "Кожные покровы чистые, обычной окраски и влажности. Живот при пальпации мягкий, безболезненный. " +
                "Поясничная область при поколачивании безболезненна с обеих сторон. Мочеиспускание свободное, " +
                "безболезненное, диурез достаточный. Стул оформленный. Рекомендации выполняются." +
                (isDischarged ? "\nВыписывается в удовлетворительном состоянии. Рекомендации при выписке даны." : "") + "\nЛеч. врач Майстренко Е.В.");
    }

    static void getTherapy(int drugChoice) {
        switch (drugChoice) {
            case 1 ->
                    System.out.println("Пациент получил курс внутрипузырной терапии препаратом Доксорубицин 50 мг в/п," +
                            " экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.");
            case 2 ->
                    System.out.println("Пациент получил курс внутрипузырной терапии препаратом Имурон-Вак 100 мг в/п, " +
                            "экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.");
            case 3 ->
                    System.out.println("Пациент получил курс ХТ препаратом Доцетаксел 75 мг/м2 в/в, перенес " +
                            "удовлетворительно.");
            case 4 ->
                    System.out.println("Пациент получил курс АДТ препаратом Трипторелин 11,25 мг в/м, перенес " +
                            "удовлетворительно.");
        }
    }

    static void getAttendingPhysician() {
        System.out.println("Леч. врач Майстренко Е.В.");
    }

}
