package com.malanau.sensorsapi.shared.domain;

public class DoubleMother {

    public static Double random() {
        return MotherCreator.random().number().randomDouble(2, 0, 99);
    }
}
