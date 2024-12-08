package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestSetting {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fullTextBoxForm() {
        textBoxPage.openPage()
                .setFullName("Ivan Ivanov")
                .setUserEmail("rsss@mail.ru")
                .setCurrentAddress("Red street")
                .setPermanentAddress("Red street")
                .submit();

        textBoxPage.checkResult("Name", "Ivan Ivanov")
                .checkResult("Email", "rsss@mail.ru")
                .checkResult("Current Address", "Red street")
                .checkResult("Permananet Address", "Red street");
    }
}