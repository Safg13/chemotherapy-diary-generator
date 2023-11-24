package com.dhas.diarygenerator.java;

public enum Drugs {
    DOXORUBICINE("Пациент получил курс внутрипузырной терапии препаратом Доксорубицин 50 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.", true, false),
    BCG("Пациент получил курс внутрипузырной терапии препаратом Имурон-Вак 100 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.", true, false),
    DOCETAXEL("Пациент получил курс ХТ препаратом Доцетаксел 75 мг/м2 в/в, перенес удовлетворительно", false, false),
    CABAZITAXEL("Пациент получил курс ХТ препаратом Кабазитаксел 25 мг/м2 в/в, перенес удовлетворительно", false, false),
    DEGARELIX("Пациент получил курс АДТ препаратом Дегареликс 80 мг п/к, перенес удовлетворительно", false, false),
    GOSERELIN("Пациент получил курс АДТ препаратом Гозерелин 3.6 мг п/к, перенес удовлетворительно", false, false),
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
