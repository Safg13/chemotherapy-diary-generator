package com.dhas.diarygenerator.java;

public enum Drugs {
    DOXORUBICINE("Пациент получил курс внутрипузырной терапии препаратом Доксорубицин 50 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.", false),
    BCG("Пациент получил курс внутрипузырной терапии препаратом Имурон-Вак 100 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.", false),
    DOCETAXEL("Пациент получил курс ХТ препаратом Доцетаксел 75 мг/м2 в/в, перенес удовлетворительно", false),
    CABAZITAXEL("Пациент получил курс ХТ препаратом Кабазитаксел 25 мг/м2 в/в, перенес удовлетворительно", false),
    DEGARELIX("Пациент получил курс АДТ препаратом Дегареликс 80 мг п/к, перенес удовлетворительно", false),
    GOSERELIN("Пациент получил курс АДТ препаратом Гозерелин 3.6 мг п/к, перенес удовлетворительно", false),
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
