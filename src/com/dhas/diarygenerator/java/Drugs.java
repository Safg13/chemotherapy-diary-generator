package com.dhas.diarygenerator.java;

public enum Drugs {
    DOXORUBICINE_INTRAVESICAL("Пациент получил курс внутрипузырной терапии препаратом Доксорубицин 50 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.", true, false, null),
    BCG_INTRAVESICAL("Пациент получил курс внутрипузырной терапии препаратом Имурон-Вак 100 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.", true, false, null),
    GEMCITABINE_INTRAVESICAL("Пациент получил курс внутрипузырной терапии препаратом Гемцитабин 1 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.", true, false, null),
    DOCETAXEL_INTRAVESICAL("Пациент получил курс внутрипузырной терапии препаратом Доцетаксел 75 мг в/п, экспозиция препарата в мочевом пузыре 2 часа, перенес удовлетворительно.", true, false, null),
    DOCETAXEL("Пациент получил курс ХТ препаратом Доцетаксел 75 мг/м2 в/в, перенес удовлетворительно.", false, false, null),
    CABAZITAXEL("Пациент получил курс ХТ препаратом Кабазитаксел 25 мг/м2 в/в, перенес удовлетворительно.", false, false, null),
    DEGARELIX("Пациент получил курс АДТ препаратом Дегареликс 80 мг п/к, перенес удовлетворительно.", false, false, null),
    GOSERELIN_3_6("Пациент получил курс АДТ препаратом Гозерелин 3.6 мг п/к, перенес удовлетворительно.", false, false, null),
    TRIPTORELIN_11_25("Пациент получил курс АДТ препаратом Трипторелин 11.25 мг в/м, перенес удовлетворительно.", false, false, null),
    AVELUMAB("Пациент получил курс ИТ препаратом Авелумаб 800 мг в/в, перенес удовлетворительно", false, false, null),
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
