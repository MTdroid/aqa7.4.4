import com.codeborne.selenide.Selenide;
import example.elementsLocation.*;
import example.steps.WbSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class TestCases {

    @BeforeEach
    public void openWb() {

        Selenide.open("https://www.wildberries.ru/");
        Selenide.sleep(300);
    }

    @Test
    @DisplayName("Тест-кейс 1: Работа с поисковой строкой")
    public void searchLine() {

        MainPageElements.searchLine.shouldBe(enabled).click();
        MainPageElements.searchLine.shouldBe(editable).sendKeys("Iphone 13");
        MainPageElements.searchButton.shouldBe(visible).click();

        WbSteps.textEquals(SearchingResultsElements.title.getText(), "Iphone 13");
        WbSteps.textEquals(SearchingResultsElements.burgerFilter.getText(), "Iphone 13");
        WbSteps.textEquals(SearchingResultsElements.sortFilter.getText(), "По популярности");
        WbSteps.textEquals(SearchingResultsElements.brand.getText(), "Apple");

        MainPageElements.clearSearchLine.shouldBe(interactable).click();
        WbSteps.textEquals(MainPageElements.searchLine.getText(), "");
    }

    @DisplayName("Тест-кейс 2: Смена города")
    @Test
    public void changeTheCity() {

        MainPageElements.cityChange.shouldBe(enabled).click();
        CityChangeElements.searchLine.shouldBe(interactable).click();
        CityChangeElements.searchLine.shouldBe(interactable).sendKeys("Санкт-Петербург");
        CityChangeElements.searchButton.shouldBe(interactable).click();
        CityChangeElements.pickAddress.shouldHave(text("Санкт-Петербург")).click();

        String addressConfirm = CityChangeElements.addressConfirm.shouldBe(visible).getText();

        WbSteps.textEquals(CityChangeElements.pickAddress.getText(), addressConfirm);

        CityChangeElements.pick.shouldBe(enabled).click();

        WbSteps.textEquals(MainPageElements.cityChange.getText(), addressConfirm);
    }

    @DisplayName("Тест-кейс 3: Добавление товара в корзину")
    @Test
    public void addToCart() {

        MainPageElements.filters.shouldBe(enabled).click();
        FiltersElements.householdAppliances.shouldBe(visible).hover();
        FiltersElements.homeAppliances.shouldBe(visible).click();
        FiltersElements.vacuumSteamCleaners.shouldBe(visible).click();
        FiltersElements.vacuumCleaners.shouldBe(visible).click();

        WbSteps.textEquals(SearchingResultsElements.title.getText(), "Пылесосы и пароочистители");
        WbSteps.textEquals(SearchingResultsElements.pagePath.getText(), "Главная\n" +
                "Бытовая техника\n" +
                "Техника для дома\n" +
                "Пылесосы и пароочистители");
        SearchingResultsElements.firstProduct.shouldBe(visible).hover();
        String price = SearchingResultsElements.firstProductPrice.getText();
        SearchingResultsElements.firstProductAddToCart.shouldBe(interactable).click();
        WbSteps.textEquals(MainPageElements.cart.getText(), "1");
        MainPageElements.cart.shouldBe(visible).click();
        String productName = SearchingResultsElements.firstProductName.getText();
        WbSteps.textEquals(CartElements.name.getText(), productName);

        CartElements.price.shouldHave(text(price));
        WbSteps.textEquals(CartElements.totalPrice.getText(), CartElements.price.getText());
        CartElements.orderButton.shouldBe(interactable);
    }

    @DisplayName("Тест-кейс 4: Работа с фильтрами")
    @Test
    public void settingFilters() {

        MainPageElements.filters.shouldBe(visible).click();
        FiltersElements.electronics.shouldBe(visible).hover();
        FiltersElements.laptopsAndPc.shouldBe(visible).click();
        FiltersElements.laptops.shouldBe(visible).click();

        WbSteps.textEquals(SearchingResultsElements.title.getText(), "Ноутбуки и ультрабуки");

        SearchingResultsElements.dropDownFilterButton.shouldBe(visible).click();

        SearchingResultsElements.startPrice.shouldBe(interactable).clear();
        SearchingResultsElements.startPrice.shouldBe(interactable).sendKeys("100000");
        SearchingResultsElements.endPrice.shouldBe(interactable).clear();
        SearchingResultsElements.endPrice.shouldBe(interactable).sendKeys("149000");
        SearchingResultsElements.upTo3Days.shouldBe(interactable).click();
        SearchingResultsElements.apple.shouldBe(interactable).click();
        SearchingResultsElements.size.shouldBe(visible).click();
        SearchingResultsElements.showAll.shouldBe(interactable).click();

        WbSteps.textEquals(SearchingResultsElements.choiseList.shouldBe(visible).getText(),
                "до 3 дней\n" +
                        "Apple\n" +
                        "от 100 000 до 149 000\n" +
                        "13.6\"\n" +
                        "Сбросить все");
        SearchingResultsElements.dropAll.shouldBe(enabled);

        WbSteps.textEquals(SearchingResultsElements.totalItems.getText(), String.valueOf(SearchingResultsElements.checkSize.size()));
    }
}