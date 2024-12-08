package testingnore;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class  RegistrationFormTest  {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";


    }

    @Test
    void registrationTest() {
        open("/automation-practice-form");


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
        $("#uploadPicture").uploadFromClasspath("Test.jpg");

        //Current Address
        $("#currentAddress").setValue("Red street");

        //State and City
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        //Checking the result
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Ivanov@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7910111111"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("13 November,2013"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("History, Physics"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Red street"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }

}
