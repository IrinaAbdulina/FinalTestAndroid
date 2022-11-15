package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchTest extends CoreTestCase {

    private static final String LOCATOR = "id:org.wikipedia:id/fragment_feed_header";

    public void search(String sequence, String element, String TypeSearch, String sXpath) {
        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement searchInit = mainPO.waitForElementPresent(
                LOCATOR,
                "Такой элемент поиска не найден"
        );
        searchInit.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Поиск по значению " + sequence + " не выдал результата"
        );
        searchInput.sendKeys(sequence);

        switch (TypeSearch) {
            case ("element"):
                WebElement expectedResult = mainPO.waitForElementPresent(
                        "xpath://*[./*[contains(@text, '" + element + "')]]",
                        "Для найденного элемента '" + sequence + "' не найдено подзначение '" + element + "'"
                );
                expectedResult.click();
                break;
            case ("xpath"):
                WebElement expectedResult_xpath = mainPO.waitForElementPresent(
                        "xpath:" + sXpath + "",
                        "элемент не найден"
                );
                expectedResult_xpath.click();
                break;
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSearch() {
        search("Java", "Island", "element", "");
    }
    @Test
    public void testSearch2() {
        search("Basketball", "baskets", "element", "");
    }
    @Test
    public void testSearch3() {
        search( "Sun", "Solar", "element", "");
    }
    @Test
    public void testSearch4() {
        search( "Vulcano", "Sicily", "element", "");
    }
    @Test
    public void testSearch5() {
        search("Computer", "General", "element", "");
    }
    @Test
    public void testSearch6() {
        search("Flash drive", "memory", "element", "");
    }
    @Test
    public void testSearch7() {
        search( "Lighthause", "navigation", "element", "");
    }
    @Test
    public void testSearch8() {
        search( "Everest", "Mount Everest", "element", "");
    }
    @Test
    public void testSearch9() {
        search( "Smartphone", "mobile telephone", "element", "");
    }
    @Test
    public void testSearch10() {
        search("Pushkin A", "Alexander Pushkin", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout");
    }
    @Test
    public void testSearch11() {
        search("Capital Russia", "Moscow", "element", "");
    }
    @Test
    public void testSearch12() { search("Capital Russia", "Astana", "element", ""); }
    @Test
    public void testSearch13() {
        search("Capitall Kazakhstan", "Moscow", "element", "");
    }
    @Test
    public void testSearch14() {
        search("Pushkin A", "Alexander Pushkin", "xpath", "/TESThierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout");
    }

}