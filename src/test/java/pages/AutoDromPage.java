package pages;

import autotests.TestDromSetting;
import autotests.data.CarName;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutoDromPage extends TestDromSetting {

    public void openAutoPage() {
        open("");
    }
    private final SelenideElement car = $("[data-ftid=component_cars-list]");
    private final ElementsCollection carNames = $$("[data-ftid=component_cars-list] [data-ftid=component_cars-list-item_hidden-link]");
    private final ElementsCollection modelsCars = $$("[data-ftid=component_cars-list] [data-ftid=component_cars-list-item_hidden-link]");
    private final ElementsCollection checkCarName = $$(".sptubg0 [data-ftid=bulls-list_bull]");


    public void getCar(String carNames) {
        car.shouldHave(text(carNames));
    }

    public AutoDromPage getCarName(CarName carName) {
        carNames.findBy(text(carName.name())).click();
        return this;
    }
    public AutoDromPage getCarName(String carMarkNames) {
        carNames.findBy(text(carMarkNames)).click();
        return this;
    }

    public void getModesCars(List<String> models) {
        modelsCars.shouldHave(texts(models));
    }

    public void checkCarsNames() {
        checkCarName.shouldBe(sizeGreaterThan(1));
    }


}
