module br.edu.ifsc.fln.atv {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.edu.ifsc.fln.atv1 to javafx.fxml;
    exports br.edu.ifsc.fln.atv1;
    exports br.edu.ifsc.fln.atv1.controller;
    opens br.edu.ifsc.fln.atv1.controller to javafx.fxml;
}