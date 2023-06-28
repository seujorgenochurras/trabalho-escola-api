module io.github.seujorgenochurras.fakeregisterjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

                            
    opens io.github.seujorgenochurras.fakeregisterjavafx to javafx.fxml;
    opens io.github.seujorgenochurras.fakeregisterjavafx.controller to javafx.fxml;
    exports io.github.seujorgenochurras.fakeregisterjavafx;
}