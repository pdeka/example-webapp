package example.documentation;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.lang.String.format;

class StoryReport {

    private final Template sourceTemplate;
    private final String destinationDir;
    private final String trelloBoard;

    StoryReport(String templateDir, String destinationDir, String trelloBoard) throws IOException {
        this.destinationDir = destinationDir;
        this.trelloBoard = trelloBoard;
        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File(templateDir));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.ENGLISH);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        sourceTemplate = configuration.getTemplate("story-report.ftl");
    }

    void generate(List<TestDetail> testDetails) throws IOException, TemplateException {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("testDetails", testDetails);
        input.put("trelloBoard", trelloBoard);

        writeReport(input);
    }

    private void writeReport(Map<String, Object> input) throws IOException, TemplateException {
        Writer fileWriter = new FileWriter(new File(format("%s/%s", destinationDir, "story-report.html")));
        try {
            sourceTemplate.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }
    }
}