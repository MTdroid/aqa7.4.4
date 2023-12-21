package example.elementsLocation;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageElements {

    public static SelenideElement searchLine = $x("//input[@id='searchInput']");
    public static SelenideElement cityChange =$x("//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
    public static SelenideElement filters = $x("//button[@class='nav-element__burger j-menu-burger-btn j-wba-header-item']");
    public static SelenideElement cart = $x("//span[@class='navbar-pc__notify']");
    public static SelenideElement clearSearchLine = $x("//button[@class='search-catalog__btn search-catalog__btn--clear search-catalog__btn--active']");
    public static SelenideElement searchButton = $x("//button[@id='applySearchBtn']");
}
