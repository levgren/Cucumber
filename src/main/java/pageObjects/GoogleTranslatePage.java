package pageObjects;

import cucumber.api.java.bs.A;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.Assert;
import utils.ConfigProperties;

public class GoogleTranslatePage extends AbstractClass{

    private String givenUrl = ConfigProperties.getTestProperty("givenUrl");

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

    public void selectLanguage(String langFrom, String langTo){
        driver.findElement(selectTranslateLangFrom).click();
        Allure.addAttachment("clicking languages dropdown", "dropdown button is clicked");
        driver.findElement(selectTranslateLangFromSearchInput).sendKeys(langFrom);
        Allure.addAttachment("typing language", langFrom + " language was entered");
        driver.findElement(selectTranslateLangFromSearchInput).sendKeys(Keys.ENTER);
        Allure.addAttachment("submitting language", langFrom + " is submitted");
        driver.findElement(selectTranslateLangTo).click();
        Allure.addAttachment("clicking languages dropdown", "dropdown button is clicked");
        driver.findElement(selectTranslateLangToSearchInput).sendKeys(langTo);
        Allure.addAttachment("typing language", langTo + " language was entered");
        driver.findElement(selectTranslateLangToSearchInput).sendKeys(Keys.ENTER);
        Allure.addAttachment("submitting language", langTo + " is submitted");
    }

    public void translateTheWord(String word){
        driver.findElement(selectTranslateLangFromInput).sendKeys(word);
        Allure.addAttachment("Typing word in the left translate input", "word " + word + " was entered");
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
