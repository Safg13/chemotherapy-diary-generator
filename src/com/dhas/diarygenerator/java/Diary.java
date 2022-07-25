package com.dhas.diarygenerator.java;

public class Diary {

    static double bodyTempMin = 36.5; //������ ����� ����������� � ���������
    static double bodyTempMax = 36.9; //������� ����� ����������� � ���������
    static double bodyTempScale = Math.pow(10, 1); //���������� ����������� � ���������
    static int pulseMin = 64; //������ ����� ������ � ���������
    static int pulseMax = 78; //������� ����� ������ � ���������
    static int systolicPressureMax = 135; //������� ����� �������������� �������� � ���������
    static int systolicPressureMin = 110; //������ ����� �������������� �������� � ���������
    static int diastolicPressureMax = 85; // ������� ����� ��������������� �������� � ���������
    static int diastolicPressureMin = 70; //������ ����� ��������������� �������� � ���������

    static String complaintsLightDysuria = "������ �� ��������� ��������������. ";

    static String getHeadOfDepartmentRounds() {
        return " ���������� ����� � ���. ���������� ������� �.�.";
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

        System.out.println(complaintsLightDysuria + "����� ��������� ������������������. ����������� ���� " + bodyTemp +
                " �." + " ����� " + pulse + " ��/���. �� " + systolicPressure + "/" + diastolicPressure + " �� ��. ��. " +
                "������� ������������� �� ���� �������, ������������, ������ ���. ���� ������ ����������, ���������. " +
                "������ ������� ������, ������� ������� � ���������. ����� ��� ��������� ������, ��������������. " +
                "���������� ������� ��� ������������� ������������� � ����� ������. �������������� ���������, " +
                "��������������, ������ �����������. ���� �����������. ������������ �����������." +
                (isDischarged ? "\n������������ � ������������������ ���������. ������������ ��� ������� ����." : "") + "\n���. ���� ���������� �.�.");
    }

    static void getTherapy(int drugChoice) {
        switch (drugChoice) {
            case 1 ->
                    System.out.println("������� ������� ���� �������������� ������� ���������� ������������ 50 �� �/�," +
                            " ���������� ��������� � ������� ������ 2 ����, ������� �����������������.");
            case 2 ->
                    System.out.println("������� ������� ���� �������������� ������� ���������� ������-��� 100 �� �/�, " +
                            "���������� ��������� � ������� ������ 2 ����, ������� �����������������.");
            case 3 ->
                    System.out.println("������� ������� ���� �� ���������� ���������� 75 ��/�2 �/�, ������� " +
                            "�����������������.");
            case 4 ->
                    System.out.println("������� ������� ���� ��� ���������� ����������� 11,25 �� �/�, ������� " +
                            "�����������������.");
        }
    }

    static void getAttendingPhysician() {
        System.out.println("���. ���� ���������� �.�.");
    }

}
