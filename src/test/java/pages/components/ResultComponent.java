package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    public void getTittleText (String value ){
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
    }
    public void getCellValueByKey(String key, String value) {
        $(".table").$(byText(key)).parent().shouldHave(text(value));
    }
    public  void outputText(String key, String value){
        $("#output").$(withText(key)).shouldHave(text(value));
    }


}
