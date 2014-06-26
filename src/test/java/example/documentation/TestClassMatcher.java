package example.documentation;

import ch.lambdaj.function.matcher.Predicate;

class TestClassMatcher extends Predicate<Class> {
    public boolean apply(Class item) {
        return item.getSimpleName().endsWith("Tests");
    }
}
