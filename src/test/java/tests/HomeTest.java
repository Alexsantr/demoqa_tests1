package tests;

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
        Configuration.baseUrl = "http://localhost:63342/demoqa_tests1/demoqa_tests1.test/%D1%81%D0%B0%D0%B9%D1%82.html?_ijt=jpm7khbco1e90l274554on8b5b&_ij_reload=RELOAD_ON_SAVE";
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
