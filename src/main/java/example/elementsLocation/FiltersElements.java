package example.elementsLocation;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FiltersElements {

    public static SelenideElement householdAppliances = $x("//a[contains(text(), 'Бытовая техника')]");
    public static SelenideElement homeAppliances = $x("//span[contains(text(), 'Техника для дома')]");
    public static SelenideElement vacuumSteamCleaners = $x("//span[contains(text(), 'Пылесосы и пароочистители')]");
    public static SelenideElement vacuumCleaners = $x("//a[@href=\"https://www.wildberries.ru/catalog/elektronika/tehnika-dlya-doma/pylesosy-i-parootchistiteli\"]");
    public static SelenideElement  electronics = $x("//a[contains(text(), 'Электроника')]");
    public static SelenideElement laptopsAndPc = $x("//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static SelenideElement laptops = $x("//a[@class=\"menu-burger__link j-menu-drop-link\"][@href= 'https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki']");
}
