package com.dhas.diarygenerator.java;

public enum Drugs {
    DOXORUBICINE("������� ������� ���� �������������� ������� ���������� ������������ 50 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", true, false),
    BCG("������� ������� ���� �������������� ������� ���������� ������-��� 100 �� �/�, ���������� ��������� � ������� ������ 2 ����, ������� �����������������.", true, false),
    DOCETAXEL("������� ������� ���� �� ���������� ���������� 75 ��/�2 �/�, ������� �����������������", false, false),
    CABAZITAXEL("������� ������� ���� �� ���������� ������������ 25 ��/�2 �/�, ������� �����������������", false, false),
    DEGARELIX("������� ������� ���� ��� ���������� ���������� 80 �� �/�, ������� �����������������", false, false),
    GOSERELIN("������� ������� ���� ��� ���������� ��������� 3.6 �� �/�, ������� �����������������", false, false),
    DOCETAXEL_DEGARELIX(DOCETAXEL.getDiaryEntry(), false, true),
    DOCETAXEL_GOSERELIN(DOCETAXEL.getDiaryEntry(), false, true),
    CABAZITAXEL_DEGARELIX(CABAZITAXEL.getDiaryEntry(), false, true),
    DEGARELIX_DOCETAXEL(DEGARELIX.getDiaryEntry(), false, true),
    DEGARELIX_CABAZITAXEL(DEGARELIX.getDiaryEntry(), false, true);

    private final String diary;
    private final boolean isIntraVesicalScheme;
    private final boolean isTwoDrugsScheme;

    Drugs(String diary, boolean isIntraVesicalScheme, boolean isTwoDrugsScheme) {
        this.diary = diary;
        this.isIntraVesicalScheme = isIntraVesicalScheme;
        this.isTwoDrugsScheme = isTwoDrugsScheme;
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
}
