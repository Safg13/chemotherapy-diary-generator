package com.dhas.diarygenerator.java;

public enum Drugs {
    DOXORUBICINE("������� ������� ���� �������������� ������� ���������� ������������ 50 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", false),
    BCG("������� ������� ���� �������������� ������� ���������� ������-��� 100 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", false),
    DOCETAXEL("������� ������� ���� �� ���������� ���������� 75 ��/�2 �/�, ������� �����������������", false),
    CABAZITAXEL("������� ������� ���� �� ���������� ������������ 25 ��/�2 �/�, ������� �����������������", false),
    DEGARELIX("������� ������� ���� ��� ���������� ���������� 80 �� �/�, ������� �����������������", false),
    GOSERELIN("������� ������� ���� ��� ���������� ��������� 3.6 �� �/�, ������� �����������������", false),
    DOCETAXEL_DEGARELIX(DOCETAXEL.getDiaryEntry(), true),
    DOCETAXEL_GOSERELIN(DOCETAXEL.getDiaryEntry(), true),
    CABAZITAXEL_DEGARELIX(CABAZITAXEL.getDiaryEntry(), true),
    DEGARELIX_DOCETAXEL(DEGARELIX.getDiaryEntry(), true),
    DEGARELIX_CABAZITAXEL(DEGARELIX.getDiaryEntry(), true);

    private final String diary;
    private final boolean isTwoDrugsScheme;

    Drugs(String diary, boolean isTwoDrugsScheme) {
        this.diary = diary;
        this.isTwoDrugsScheme = isTwoDrugsScheme;
    }

    public String getDiaryEntry() {
        return diary;
    }

    public boolean getTwoDrugsScheme() {
        return isTwoDrugsScheme;
    }
}
