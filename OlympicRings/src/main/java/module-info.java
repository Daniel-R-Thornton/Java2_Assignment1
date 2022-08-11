module olympicrings.olympicrings {
  requires javafx.controls;
  requires javafx.fxml;

  opens olympicrings.olympicrings to javafx.fxml;
  exports olympicrings.olympicrings;
}