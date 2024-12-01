package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SearchIntoGithubTests {

        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://github.com";
            Configuration.pageLoadStrategy = "eager";
        }
        @Test
    void searchIntoGithubTest(){
            open("");
            $(".HeaderMenu-nav").$(byText("Solutions")).hover();
            $(byTagAndText("a","Enterprises")).click();
            $(".enterprise-hero-grid").shouldHave(text("The AI-powered developer platform"));

        }

}


