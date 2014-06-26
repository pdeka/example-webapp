package example.documentation;

import com.google.common.collect.Lists;

import java.util.List;

class AppliesToStoriesCollection {
    private AppliesToStories appliesToStories;

    AppliesToStoriesCollection(AppliesToStories appliesToStories) {
        this.appliesToStories = appliesToStories;
    }
    List<String> collect() {
        List<String> appliedToStoryNames = Lists.newArrayList();
        for (Story story : appliesToStories.value()) {
            appliedToStoryNames.add(story.name());
        }
        return appliedToStoryNames;
    }

}
