package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class        RegistrationFormTest  {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";



    }

    @Test
    void RegistrationTest() {
        open("/automation-practice-form");
        //Name
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");

        //Email
        $("#userEmail").setValue("Ivanov@gmail.com");

        //Gender
        $("#genterWrapper").$(byText("Male")).click();

        //Mobile
        $("#userNumber").setValue("79101111111");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("2013");
        $(".react-datepicker__day.react-datepicker__day--013").click();

        //Subjects
        $("#subjectsInput").setValue("History").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Reading")).click();

        //Picture
        $("#uploadPicture").uploadFile(new File("C:\\Users\\Trek119\\Pictures\\Camera Roll\\Screenshot_5.png"));

        //Current Address
        $("#currentAddress").setValue("Red street");

        //State and City
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        //Checking the result
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table").shouldHave(text("Student Name")).shouldHave(text("Ivan Ivanov"));
        $(".table").shouldHave(text("Student Email")).shouldHave(text("Ivanov@gmail.com"));
        $(".table").shouldHave(text("Gender")).shouldHave(text("Male"));
        $(".table").shouldHave(text("Mobile")).shouldHave(text("7910111111"));
        $(".table").shouldHave(text("Date of Birth")).shouldHave(text("13 November,2013"));
        $(".table").shouldHave(text("Subjects")).shouldHave(text("History, Physics"));
        $(".table").shouldHave(text("Hobbies")).shouldHave(text("Reading"));
        $(".table").shouldHave(text("Picture")).shouldHave(text("Screenshot_5.png"));
        $(".table").shouldHave(text("Address")).shouldHave(text("Red street"));
        $(".table").shouldHave(text("State and City")).shouldHave(text("NCR Noida"));
    }

}
