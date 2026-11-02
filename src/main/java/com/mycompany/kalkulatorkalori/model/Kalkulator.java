package com.mycompany.kalkulatorkalori.model;

public class Kalkulator {
    public static double hitungBMR(double berat, double tinggi, int usia, String gender) {
        if ("Laki-laki".equalsIgnoreCase(gender)) {
            return (10 * berat) + (6.25 * tinggi) - (5 * usia) + 5;
        } else {
            return (10 * berat) + (6.25 * tinggi) - (5 * usia) - 161;
        }
    }

    public static double hitungTDEE(double bmr, String aktivitas) {
        switch (aktivitas) {
            case "Sangat Jarang (Hampir tidak olahraga)": return bmr * 1.2;
            case "Jarang (1-3 hari/minggu)": return bmr * 1.375;
            case "Sedang (3-5 hari/minggu)": return bmr * 1.55;
            case "Sering (6-7 hari/minggu)": return bmr * 1.725;
            case "Sangat Sering (Pekerja fisik/Atlet)": return bmr * 1.9;
            default: return bmr * 1.2;
        }
    }
}