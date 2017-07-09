package com.thejacket.ewa;

/**
 * Created by mariusz on 2017-06-21.
 */

public class QuestionnaireData {

    public enum sex {
        K {
            @Override
            public String toString() {
                return "K";
            }
        },
        M {
            @Override
            public String toString() {
                return "M";
            }
        }
    }

    public enum education {
        podstawowe, gimnazjalne, zawodowe, średnie, wyższe
    }

    public enum wasSick {
        NieChorowalo {                      // wwalic na poczatek
            @Override
            public String toString() {
                return "Nie chorowało";
            }
        },
        PorazenieMozgowe {
            @Override
            public String toString() {
                return "Porażenie mózgowe";
            }
        },
        ZapalenieOponMozgowych {
            @Override
            public String toString() {
                return "Zapalenie opon mózgowych";
            }
        },
        Padaczka {
            @Override
            public String toString() {
                return "Padaczka";
            }
        },
        Nowotwor {
            @Override
            public String toString() {
                return "Nowotwór";
            }
        },
        Inne {
            @Override
            public String toString() {
                return "Inne..";
            }
        },

        }

    }