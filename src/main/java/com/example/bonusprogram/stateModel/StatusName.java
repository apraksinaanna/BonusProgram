package com.example.bonusprogram.stateModel;

// перечисление вида покупки
public enum StatusName {
    SHOP("Shop"),
    ONLINE("Online");

    String value;

    StatusName(String value) {
        this.value = value;
    }
}
