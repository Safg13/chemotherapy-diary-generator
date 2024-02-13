package com.dhas.diarygenerator.java;

public enum Drugs {
    DOXORUBICINE_INTRAVESICAL("������� ������� ���� �������������� ������� ���������� ������������ 50 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", true, false, null),
    BCG_INTRAVESICAL("������� ������� ���� �������������� ������� ���������� ������-��� 100 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", true, false, null),
    GEMCITABINE_INTRAVESICAL("������� ������� ���� �������������� ������� ���������� ���������� 1 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", true, false, null),
    DOCETAXEL_INTRAVESICAL("������� ������� ���� �������������� ������� ���������� ���������� 75 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", true, false, null),
    DOCETAXEL("������� ������� ���� �� ���������� ���������� 75 ��/�2 �/�, ������� �����������������.", false, false, null),
    CABAZITAXEL("������� ������� ���� �� ���������� ������������ 25 ��/�2 �/�, ������� �����������������.", false, false, null),
    DEGARELIX("������� ������� ���� ��� ���������� ���������� 80 �� �/�, ������� �����������������.", false, false, null),
    GOSERELIN_3_6("������� ������� ���� ��� ���������� ��������� 3.6 �� �/�, ������� �����������������.", false, false, null),
    TRIPTORELIN_11_25("������� ������� ���� ��� ���������� ����������� 11.25 �� �/�, ������� �����������������.", false, false, null),
    AVELUMAB("������� ������� ���� �� ���������� �������� 800 �� �/�, ������� �����������������", false, false, null),
    DOCETAXEL_DEGARELIX(DOCETAXEL.getDiaryEntry(), false, true, DEGARELIX),
    DOCETAXEL_GOSERELIN_3_6(DOCETAXEL.getDiaryEntry(), false, true, GOSERELIN_3_6),
    DOCETAXEL_TRIPTORELIN_11_25(DOCETAXEL.getDiaryEntry(), false, true, TRIPTORELIN_11_25),
    CABAZITAXEL_DEGARELIX(CABAZITAXEL.getDiaryEntry(), false, true, DEGARELIX);

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
