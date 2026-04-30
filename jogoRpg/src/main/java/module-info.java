module com.mycompany.jogorpg {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.jogorpg to javafx.fxml;
    exports com.mycompany.jogorpg;
}
