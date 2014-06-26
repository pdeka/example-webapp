package example.domain;


import example.documentation.AppliesToStories;
import example.documentation.Story;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DocumentTests {

    @Test
    @AppliesToStories(Story.GTR101)
    public void blankDocumentIsValid() throws Exception {
        assertThat(new Document().isValid(), is(true));
    }

    @Test
    @AppliesToStories(Story.GTR102)
    public void documentIsValidWhenAllPropertiesAreValid() throws Exception {
        Document doc = new Document();
        doc.set(Field.one, new Property("hello"));
        doc.set(Field.two, new Property("there"));
        assertThat(doc.isValid(), is(true));
    }

    @Test
    @AppliesToStories({Story.GTR101, Story.GTR102})
    public void documentIsNotValidWhenOneFieldIsNotValid() throws Exception {
        Document doc = new Document();
        doc.set(Field.one, new Property("hello"));
        doc.set(Field.two, new Property("there", "error"));
        assertThat(doc.isValid(), is(false));
    }
}
