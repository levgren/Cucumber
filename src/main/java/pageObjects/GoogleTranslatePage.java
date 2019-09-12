package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.Assert;

public class GoogleTranslatePage extends AbstractClass{

    private String givenUrl = "https://translate.google.com/?hl=ru";

    private By selectTranslateLangFrom = By.cssSelector(".sl-wrap [aria-label]");
    private By selectTranslateLangFromSearchInput = By.cssSelector("#sl_list-search-box");
    private By selectTranslateLangTo = By.cssSelector(".tl-wrap [aria-label]");
    private By selectTranslateLangToSearchInput = By.cssSelector("#tl_list-search-box");
    private By selectTranslateLangFromInput = By.cssSelector("#source");
    private By translatedWord = By.xpath("//span[@class='tlid-translation translation']//span");
    private By definitionSection = By.xpath("//div[@class='gt-cd gt-cd-mmd']");

    public void goTo() {
        driver.get(givenUrl);
        Allure.addAttachment("Navigating to Google search page", "given url: " + givenUrl + " is opened");
    }
    public void goTol() {
        driver.get(givenUrl);
        Allure.addAttachment("Navigating to Google search page", "given url: " + givenUrl + " is opened");
    }

    public void selectLanguage(String langFrom, String langTo){
        driver.findElement(selectTranslateLangFrom).click();
        driver.findElement(selectTranslateLangFromSearchInput).sendKeys(langFrom);
        driver.findElement(selectTranslateLangFromSearchInput).sendKeys(Keys.ENTER);
        driver.findElement(selectTranslateLangTo).click();
        driver.findElement(selectTranslateLangToSearchInput).sendKeys(langTo);
        driver.findElement(selectTranslateLangToSearchInput).sendKeys(Keys.ENTER);
    }

    public void translateTheWord(String word){
        driver.findElement(selectTranslateLangFromInput).sendKeys(word);
    }

    public void verifyTranslation(String transWord){
        Assert.assertTrue("Translated word meets to the requirements",
                driver.findElement(translatedWord).getText().equalsIgnoreCase(transWord));
    }

    public void checkNumberOfLetters(int numOfChars){
        int lengthOfTHeWord = driver.findElement(translatedWord).getText().length();
        Assert.assertEquals("Translated word contains " + numOfChars + " chars", lengthOfTHeWord, numOfChars);
    }

    public void checkDefinitionSection(String definition){
        Assert.assertTrue("definition section appears",
                driver.findElement(definitionSection).getText().contains(definition));
    }

}
