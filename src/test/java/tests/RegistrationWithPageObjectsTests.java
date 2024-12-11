package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import until.TestData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class RegistrationWithPageObjectsTests extends TestSetting {

    RegistrationPage registrationPage = new RegistrationPage();
    DateFormat dateFormat = new SimpleDateFormat("dd MMMMM,yyyy", Locale.UK);
    Date date =new Date();
    String time = dateFormat.format(date);
    TestData testData = new TestData();


    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.telephoneNumber)
                .setDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .subjectsInput(testData.subject)
                .hobbiesWrapperInput(testData.hobbies)
                .uploadPictureInput(testData.picture)
                .currentAddressInput(testData.userAddress)
                .cityInput(testData.userState)
                .nexCityInput(testData.userCity)
                .submit()


                .submissionModal("Thanks for submitting the form")
                .checkResultTable("Student Name", testData.firstName+ " " +testData.lastName)
                .checkResultTable("Student Email",testData.userEmail )
                .checkResultTable("Gender", testData.gender)
                .checkResultTable("Mobile", testData.telephoneNumber)
                .checkResultTable("Date of Birth",testData.userBirthDay+ " " +testData.userBirthMonth+ "," +testData.userBirthYear)
                .checkResultTable("Subjects", testData.subject)
                .checkResultTable("Hobbies", testData.hobbies)
                .checkResultTable("Picture", testData.picture)
                .checkResultTable("Address", testData.userAddress)
                .checkResultTable("State and City", testData.userState+" "+testData.userCity);
    }


    @Test
    void successMinFullRegistrationTest() {registrationPage.openPage()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setGender(testData.gender)
            .setUserNumber(testData.telephoneNumber)
            .submit()


            .submissionModal("Thanks for submitting the form")
            .checkResultTable("Student Name", testData.firstName+" "+testData.lastName)
            .checkResultTable("Mobile", testData.telephoneNumber)
            .checkResultTable("Gender", testData.gender)
            .checkResultTable("Date of Birth", time);
    }

    @Test
    void notSuccessMinFullRegistrationTest() {registrationPage.openPage()
            .submit()
            .CheckLineRedColor();



    }

}