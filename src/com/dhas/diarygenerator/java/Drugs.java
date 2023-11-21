package com.dhas.diarygenerator.java;

public enum Drugs {
    DOXORUBICINE("������� ������� ���� �������������� ������� ���������� ������������ 50 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������."),
    BCG("������� ������� ���� �������������� ������� ���������� ������-��� 100 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������."),
    DOCETAXEL("������� ������� ���� �� ���������� ���������� 75 ��/�2 �/�, ������� �����������������"),
    CABAZITAXEL("������� ������� ���� �� ���������� ������������ 25 ��/�2 �/�, ������� �����������������"),
    DEGARELIX("������� ������� ���� ��� ���������� ���������� 80 �� �/�, ������� �����������������"),
    DOCETAXEL_DEGARELIX(DOCETAXEL.getDiaryEntry()),
    CABAZITAXEL_DEGARELIX(CABAZITAXEL.getDiaryEntry()),
    DEGARELIX_DOCETAXEL(DEGARELIX.getDiaryEntry()),
    DEGARELIX_CABAZITAXEL(DEGARELIX.getDiaryEntry());

    private final String diary;

    Drugs(String diary) {
        this.diary = diary;
    }

    public String getDiaryEntry() {
        return diary;
    }
}
