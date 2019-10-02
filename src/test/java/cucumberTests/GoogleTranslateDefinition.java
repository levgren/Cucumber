package cucumberTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AbstractClass;
import pageObjects.GoogleTranslatePage;

public class GoogleTranslateDefinition extends Hooks {

    private GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage();

    @Given("the user is on the google translate page")
    public void the_user_is_on_the_google_translate_page() {
        googleTranslatePage.goTo();
    }

    @Given("selected languages from {string} to {string}")
    public void selected_languages_from_to(String langFrom, String langTo) {
        googleTranslatePage.selectLanguage(langFrom, langTo);
    }

    @When("the user looks up the translation of the word {string}")
    public void the_user_looks_up_the_translation_of_the_word(String string) {
        googleTranslatePage.translateTheWord(string);
    }

    @Then("they should see the translation {string}")
    public void they_should_see_the_translation(String translatedWord) {
        googleTranslatePage.verifyTranslation(translatedWord);
    }

    @Then("number of characters must be {int}.")
    public void number_of_characters_must_be(int numb) {
        googleTranslatePage.checkNumberOfLetters(numb);
    }

    @Then("they should see the definition {string}")
    public void they_should_see_the_definition(String definition){ googleTranslatePage.checkDefinitionSection(definition);
    new AbstractClass().closeDriver();
    }
}
