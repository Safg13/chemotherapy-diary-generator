package com.dhas.diarygenerator.java;

public enum Drugs {
    DOXORUBICINE("������� ������� ���� �������������� ������� ���������� ������������ 50 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", true, false, null),
    BCG("������� ������� ���� �������������� ������� ���������� ������-��� 100 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", true, false, null),
    DOCETAXEL("������� ������� ���� �� ���������� ���������� 75 ��/�2 �/�, ������� �����������������", false, false, null),
    CABAZITAXEL("������� ������� ���� �� ���������� ������������ 25 ��/�2 �/�, ������� �����������������", false, false, null),
    DEGARELIX("������� ������� ���� ��� ���������� ���������� 80 �� �/�, ������� �����������������", false, false, null),
    GOSERELIN("������� ������� ���� ��� ���������� ��������� 3.6 �� �/�, ������� �����������������", false, false, null),
    DOCETAXEL_DEGARELIX(DOCETAXEL.getDiaryEntry(), false, true, DEGARELIX),
    DOCETAXEL_GOSERELIN(DOCETAXEL.getDiaryEntry(), false, true, GOSERELIN),
    CABAZITAXEL_DEGARELIX(CABAZITAXEL.getDiaryEntry(), false, true, DEGARELIX),
    DEGARELIX_DOCETAXEL(DEGARELIX.getDiaryEntry(), false, true, DOCETAXEL),
    DEGARELIX_CABAZITAXEL(DEGARELIX.getDiaryEntry(), false, true, CABAZITAXEL);

    private final String diary;
    private final boolean isIntraVesicalScheme;
    private final boolean isTwoDrugsScheme;
    private final Drugs secondDrug;

    Drugs(String diary, boolean isIntraVesicalScheme, boolean isTwoDrugsScheme, Drugs secondDrug) {
        this.diary = diary;
        this.isIntraVesicalScheme = isIntraVesicalScheme;
        this.isTwoDrugsScheme = isTwoDrugsScheme;
        this.secondDrug = secondDrug;
    }

    public String getDiaryEntry() {
        return diary;
    }

    public boolean getIsTwoDrugsScheme() {
        return isTwoDrugsScheme;
    }

    public boolean getIsIntravesical() {
        return isIntraVesicalScheme;
    }

    public Drugs getSecondDrug() {
        return secondDrug;
    }
}
