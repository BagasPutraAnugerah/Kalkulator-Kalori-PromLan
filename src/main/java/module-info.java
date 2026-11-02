module com.mycompany.kalkulatorkalori {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.kalkulatorkalori to javafx.fxml;
    exports com.mycompany.kalkulatorkalori;
    exports com.mycompany.kalkulatorkalori.model;
}