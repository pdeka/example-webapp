package example.documentation;

import ch.lambdaj.Lambda;
import com.google.common.collect.Lists;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class ReportGenerator {

    private static final String TRELLO_BOARD = "https://trello.com/c/44qwl11j/1-";
    private static final String REPORT_TEMPLATE_SRC = String.format("%s/src/test/resources/templates", System.getProperty("user.dir"));
    private static final String REPORT_DESTINATION = String.format("%s/build/reports/tests", System.getProperty("user.dir"));

    public static void main(String args[]) throws IOException, ClassNotFoundException, TemplateException {
        List<TestDetail> testDetails = Lists.newArrayList();
        for (Class testClass : Lambda.filter(new TestClassMatcher(), new TestPackage("example").getClasses())) {
            for (Method method : testClass.getMethods()) {
                AppliesToStories appliesToStories = method.getAnnotation(AppliesToStories.class);
                if (appliesToStories != null) {
                    testDetails.add(new TestDetail(testClass.getSimpleName(), method.getName(), appliesToStories));
                }
            }
        }

        new StoryReport(REPORT_TEMPLATE_SRC, REPORT_DESTINATION, TRELLO_BOARD).generate(testDetails);
    }
}