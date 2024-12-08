package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class RegistrationWithPageObjectsTests extends TestSetting {

    RegistrationPage registrationPage = new RegistrationPage();
    DateFormat dateFormat = new SimpleDateFormat("dd MMMMM,yyyy", Locale.UK);
    Date date =new Date();
    String time = dateFormat.format(date);


    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Ivanov@gmail.com")
                .setGender("Male")
                .setUserNumber("79101111111")
                .setDateOfBirth("13", "November", "2013")
                .subjectsInput("History")
                .subjectsInput("Physics")
                .hobbiesWrapperInput("Reading")
                .uploadPictureInput("Test.jpg")
                .currentAddressInput("Red street")
                .cityInput("NCR")
                .nexCityInput("Noida")
                .submit()


                .submissionModal("Thanks for submitting the form")
                .checkResultTable("Student Name", "Ivan Ivanov")
                .checkResultTable("Student Email", "Ivanov@gmail.com")
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", "7910111111")
                .checkResultTable("Date of Birth", "13 November,2013")
                .checkResultTable("Subjects", "History, Physics")
                .checkResultTable("Hobbies", "Reading")
                .checkResultTable("Picture", "Test.jpg")
                .checkResultTable("Address", "Red street")
                .checkResultTable("State and City", "NCR Noida");
    }


    @Test
    void successMinFullRegistrationTest() {registrationPage.openPage()
            .setFirstName("Ivan")
            .setLastName("Ivanov")
            .setUserNumber("79101111111")
            .setGender("Male")
            .submit()


            .submissionModal("Thanks for submitting the form")
            .checkResultTable("Student Name", "Ivan Ivanov")
            .checkResultTable("Mobile", "7910111111")
            .checkResultTable("Gender", "Male")
            .checkResultTable("Date of Birth", time);
    }

    @Test
    void notSuccessMinFullRegistrationTest() {registrationPage.openPage()
            .submit()
            .CheckLineRedColor();



    }

}