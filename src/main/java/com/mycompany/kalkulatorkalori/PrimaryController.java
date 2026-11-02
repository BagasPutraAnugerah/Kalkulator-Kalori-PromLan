package com.mycompany.kalkulatorkalori;

import com.mycompany.kalkulatorkalori.model.Kalkulator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent; // Pastikan import ini ada
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private TextField txtUsia;

    @FXML
    private TextField txtBerat;

    @FXML
    private TextField txtTinggi;

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private ComboBox<String> cmbAktivitas;

    @FXML
    private Label lblHasil;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbGender.setItems(FXCollections.observableArrayList(
            "Laki-laki",
            "Perempuan"
        ));
        cmbGender.getSelectionModel().selectFirst();

        cmbAktivitas.setItems(FXCollections.observableArrayList(
            "Sangat Jarang (Hampir tidak olahraga)",
            "Jarang (1-3 hari/minggu)",
            "Sedang (3-5 hari/minggu)",
            "Sering (6-7 hari/minggu)",
            "Sangat Sering (Pekerja fisik/Atlet)"
        ));
        cmbAktivitas.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleHitung(ActionEvent event) {
        try {
            int usia = Integer.parseInt(txtUsia.getText().trim());
            double berat = Double.parseDouble(txtBerat.getText().trim());
            double tinggi = Double.parseDouble(txtTinggi.getText().trim());
            String gender = cmbGender.getValue();
            String aktivitas = cmbAktivitas.getValue();

            double bmr = Kalkulator.hitungBMR(berat, tinggi, usia, gender);
            double tdee = Kalkulator.hitungTDEE(bmr, aktivitas);

            lblHasil.setText(String.format("BMR: %.0f kcal/hari\nKebutuhan Harian (TDEE): %.0f kcal/hari", bmr, tdee));
        } catch (NumberFormatException e) {
            lblHasil.setText("Error: Harap masukkan angka yang valid!");
        }
    }
}