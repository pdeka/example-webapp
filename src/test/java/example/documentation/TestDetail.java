package example.documentation;

import java.util.List;

public class TestDetail {
    private final String testName;
    private final String testMethodName;
    private final List<String> stories;

    TestDetail(String testName, String testMethodName, AppliesToStories appliesToStories) {
        this.testName = testName;
        this.testMethodName = testMethodName;
        this.stories = new AppliesToStoriesCollection(appliesToStories).collect();
    }

    public String getTestName() {
        return testName;
    }

    public String getTestMethodName() {
        return testMethodName;
    }

    public List<String> getStories() {
        return stories;
    }
}
