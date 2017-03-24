package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 18.03.2017.
 */
public class ComboBox extends BaseElement {
    /**
     * @param locator
     * @param name
     */

    public ComboBox(final By locator, final String name) {
        super(locator, name);
    }

    public ComboBox(String string, String name) {
        super(string, name);
    }


    public ComboBox(By locator) {
        super(locator);
    }

    public void selectItem(String value){
        WebElement element = this.getElement();
        element.findElement(By.xpath(".//option[@value = '"+value+"']")).click();
        info(getLoc("loc.select"));
    }

    protected String getElementType() {
        return getLoc("loc.combobox");
    }
}
