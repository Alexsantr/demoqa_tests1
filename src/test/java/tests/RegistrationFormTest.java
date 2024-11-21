package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormTest  {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov");
    }
//        $("#currentAddress").setValue("Some street 1");
//        $("#permanentAddress").setValue("Another street 1");
//        $("#submit").click();
//
//        $("#output #name").shouldHave(text("Alex"));
//        $("#output #email").shouldHave(text("alex@egorov.com"));
//        $("#output #currentAddress").shouldHave(text("Some street 1"));
//        $("#output #permanentAddress").shouldHave(text("Another street 1"));

}
