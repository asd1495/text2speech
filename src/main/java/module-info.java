module armandosd.text2speech {
    requires javafx.controls;
    requires javafx.fxml;
    requires freetts;


    opens armandosd.text2speech to javafx.fxml;
    exports armandosd.text2speech;
}