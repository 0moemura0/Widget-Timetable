package com.example.worst_first;

public enum Buildings {
    KRONVA("Кронверкский проспект, д.49"),
    BIRGA_D4("Биржевая линия д.4, лит.М"),
    BIRGA_D1416("Биржевая линия д. 14-16"),
    VYAZMA("Вяземский переулок д.5-7, лит.А (спортивный комплекс)"),
    GASTELLO("Гастелло улица д.12, лит.А"),
    GRIVZOVA("Гривцова переулок д.14-16, лит.А"),
    KADETSKAYA("Кадетская линия В.О. д.3, кор.2, лит.А"),
    LOMO("Ломоносова улица д.9"),
    NOVOIZM("Новоизмайловский проспект д.34, кор.3, лит.А"),
    PESOCHNAYA("Песочная набережная д. 14, лит."),
    CHAIKOVSKOGO("Чайковского улица д.11/2, лит.А"),
    CHRYSTALNAYA("Хрустальная улица д.14, лит.А"),
    KOMSOMOL_D5("2-я Комсомольская улица д.5, лит.А"),
    KOMSOMOL_D7("2-я Комсомольская улица д.7, кор.1, лит.А"),
    DISTANT("Дистанционно");

    private String address;

    Buildings(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
