package testingnore;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTests {

    String the_original_text = """
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
               \s
                $("#first").should(visible).click();
                $("#second").should(visible).click();
              }
            }""";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";



    }

    @Test
    void foundSoftAssertionsTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").scrollTo().$(byText("Show 3 more pages…")).click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        $$(".markdown-heading .heading-element")
                .findBy(text("3. Using JUnit5 extend test class:"))
                .parent()
                .sibling(0)
                .shouldHave(text(the_original_text));

    }

    @Test
    void  searchSoftAssertionsTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();


        $$(".markdown-heading .heading-element")
                .findBy(text("3. Using JUnit5 extend test class:"))
                .parent()
                .sibling(0)
                .shouldHave(text(the_original_text));
    }

}

