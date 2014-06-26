package example.domain.web.webdriver;

import example.documentation.AppliesToStories;
import example.documentation.Story;
import org.junit.Test;

public class DomainWorkflowTests {

    @Test
    @AppliesToStories({Story.GTR101, Story.GTR102})
    public void shouldStoreFormDetailsCorrectly() {
        Browser browser = Application.open("/example");

        browser.shows(IndexPage.class).createNewForm();
        browser.shows(FormPage.class).submitForm("homer", "option1", "10/03/2010");

        SuccessPage successPage = browser.shows(SuccessPage.class);
        successPage.showsValues("homer", "option1", "10/03/2010");

        String formId = successPage.getFormId();
        successPage.navigateToIndexPage();

        browser.shows(IndexPage.class).navigateToForm(formId);
        browser.shows(FormPage.class).showsValues("homer", "option1", "10/03/2010");
    }

    @Test
    @AppliesToStories(Story.GTR103)
    public void shouldRedisplayFormWithErrorMessages() {
        Browser browser = Application.open("/example");
        browser.shows(IndexPage.class).createNewForm();
        browser.shows(FormPage.class).submitForm("homer", "error", "10/03/2010");
        browser.shows(FormPage.class).showsErrorForFieldTwo("Oops - <error> was provided");
    }
}
