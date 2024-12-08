package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapperInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement cityInput = $("#react-select-3-input");
    private final SelenideElement nexCityInput = $("#react-select-4-input");
    private final SelenideElement submit = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage hobbiesWrapperInput(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPictureInput(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage currentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage cityInput(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage nexCityInput(String value) {
        nexCityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submit() {
        submit.click();

        return this;
    }

    public RegistrationPage submissionModal(String value) {
        resultComponent.getTittleText(value);
        return this;
    }

    public RegistrationPage checkResultTable(String key, String value) {
        resultComponent.getCellValueByKey(key, value);
        return this;
    }

    public void CheckLineRedColor() {
        userNumberInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        lastNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        userNumberInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
    }


}