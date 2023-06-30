module io.github.seujorgenochurras.fakeregisterjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

                            
    opens io.github.seujorgenochurras.fakeregisterjavafx to javafx.fxml, java.net.http;
    opens io.github.seujorgenochurras.fakeregisterjavafx.controller to javafx.fxml;
    opens io.github.seujorgenochurras.fakeregisterjavafx.domain to com.google.gson;
    opens io.github.seujorgenochurras.fakeregisterjavafx.service to com.google.gson;

    exports io.github.seujorgenochurras.fakeregisterjavafx;
    exports io.github.seujorgenochurras.fakeregisterjavafx.domain to com.google.gson;
    exports io.github.seujorgenochurras.fakeregisterjavafx.service to com.google.gson;
}