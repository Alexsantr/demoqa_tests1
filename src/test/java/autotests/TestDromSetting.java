package autotests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestDromSetting {
    @BeforeAll
    static  void setupAuto(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://auto.drom.ru/";
        Configuration.pageLoadStrategy = "eager";
    }
}
