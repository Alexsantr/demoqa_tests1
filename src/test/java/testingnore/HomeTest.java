package testingnore;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class HomeTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "file:///C:/Users/Trek119/IdeaProjects/demoqa_tests1/src/test/resources/%D1%81%D0%B0%D0%B9%D1%82.html";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen=true;



    }

    @Test
    void testOne() {
        open("");
        $("h1 div").text();




    }

    @Test

    void tesTwo() {
        open("");
        $("h1").$("div").text();


    }
}
