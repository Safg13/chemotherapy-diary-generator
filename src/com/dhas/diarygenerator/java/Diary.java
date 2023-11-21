package com.dhas.diarygenerator.java;

public class Diary {

    final static double BODY_TEMPERATURE_MIN = 36.5; //������ ����� ����������� � ���������
    final static double BODY_TEMPERATURE_MAX = 36.9; //������� ����� ����������� � ���������
    final static double BODY_TEMPERATURE_SCALE = Math.pow(10, 1); //���������� ����������� � ���������
    final static int PULSE_MIN = 64; //������ ����� ������ � ���������
    final static int PULSE_MAX = 78; //������� ����� ������ � ���������
    final static int SYSTOLIC_PRESSURE_MAX = 135; //������� ����� �������������� �������� � ���������
    final static int SYSTOLIC_PRESSURE_MIN = 110; //������ ����� �������������� �������� � ���������
    final static int DIASTOLIC_PRESSURE_MAX = 85; // ������� ����� ��������������� �������� � ���������
    final static int DIASTOLIC_PRESSURE_MIN = 70; //������ ����� ��������������� �������� � ���������

    static String getHeadOfDepartmentRounds() {
        return " ���������� ����� � ���. ���������� ������� �.�.";
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

        System.out.println("������ �� ��������� ��������������. ����� ��������� ������������������. ����������� ���� " + bodyTemp +
                " �." + " ����� " + pulse + " ��/���. �� " + systolicPressure + "/" + diastolicPressure + " �� ��. ��. " +
                "������� ������������� �� ���� �������, ������������, ������ ���. ���� ������ ����������, ���������. " +
                "������ ������� ������, ������� ������� � ���������. ����� ��� ��������� ������, ��������������. " +
                "���������� ������� ��� ������������� ������������� � ����� ������. �������������� ���������, " +
                "��������������, ������ �����������. ���� �����������. ������������ �����������." +
                (isDischarged ? "\n������������ � ������������������ ���������. ������������ ��� ������� ����." : "")
                + "\n���. ���� ���������� �.�.");
    }

    static void getTherapy(String drugChoice) {
        switch (drugChoice) {
            case "1" ->
                    System.out.println(Drugs.DOXORUBICINE.getDiaryEntry());
            case "2" ->
                    System.out.println(Drugs.BCG.getDiaryEntry());
            case "3", "6" ->
                    System.out.println(Drugs.DOCETAXEL.getDiaryEntry());
            case "4", "8" ->
                    System.out.println(Drugs.CABAZITAXEL.getDiaryEntry());
            case "5", "7", "9" ->
                    System.out.println(Drugs.DEGARELIX.getDiaryEntry());

            default -> System.out.println("������� ������� " + drugChoice + ", ������� �����������������.");
        }
    }
}
