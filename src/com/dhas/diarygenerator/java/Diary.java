package com.dhas.diarygenerator.java;

public class Diary {

    public static String getHeadOfDepartmentRounds() {
        return " Совместный обход с зав. отделением Гуриным Э.В.";
    }

    public static void getAttendingPhysician() {
        System.out.println("Леч. врач Майстренко Е.В.");
    }

    public static void getDiary() {
        var bodyTempMin = 36.5;
        var bodyTempMax = 36.9;
        var bodyTempScale = Math.pow(10, 1);
        var pulseMin = 64;
        var pulseMax = 78;
        var systolicPressureMax = 135;
        var systolicPressureMin = 110;
        var diastolicPressureMax = 85;
        var diastolicPressureMin = 70;
        String complaints = "Жалобы на учащенное мочеиспускание. ";
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

        System.out.println(complaints + "Общее состояние удовлетворительное. Температура тела " + bodyTemp + " С." +
                " Пульс " + pulse + " уд/мин. АД " + systolicPressure + "/" + diastolicPressure + " мм рт. ст. " +
                "Дыхание выслушивается во всех отделах, везикулярное, хрипов нет. Тоны сердца приглушены, ритмичные. " +
                "Кожные покровы чистые, обычной окраски и влажности. Живот при пальпации мягкий, безболезненный. " +
                "Поясничная область при поколачивании безболезненна с обеих сторон. Мочеиспускание свободное, " +
                "безболезненное, диурез достаточный. Стул оформленный. Рекомендации выполняются.");
    }

    public static void getTherapy(int drugChoice) {
        switch (drugChoice) {
            case 1 ->
                    System.out.println("Пациент получил курс внутрипузырной терапии препаратом Доксорубицин 50 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.");
            case 2 ->
                    System.out.println("Пациент получил курс внутрипузырной терапии препаратом Имурон-Вак 100 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.");
            case 3 ->
                    System.out.println("Пациент получил курс ХТ препаратом Доцетаксел 75 мг/м2 в/в, перенес удовлетворительно.");
            case 4 ->
                    System.out.println("Пациент получил курс АДТ препаратом Трипторелин 11,25 мг п/к, перенес удовлетворительно.");
        }
    }

    public static void getDischarge() {
        System.out.println("Выписывается в удовлетворительном состоянии. Рекомендации при выписке даны.");
    }

}
