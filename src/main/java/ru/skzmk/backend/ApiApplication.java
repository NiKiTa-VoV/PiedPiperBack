package ru.skzmk.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.skzmk.backend.security.AppProperties;


@SpringBootApplication()
@EnableConfigurationProperties(AppProperties.class)
public class ApiApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApiApplication.class, args);

//        I18n.init();

//        context.getBean(ScheduleDefaultParseService.class).loadFiles();
//        context.getBean(ScheduleReplacementParseService.class).loadFiles();

//        context.getBean(TestData.class).init();


//        URL resource = Thread.currentThread().getContextClassLoader().getResource("myresource.xml");
//        File file = new File(resource.getFile());
//                context.getBean(ScheduleDefaultParseService.class).fileProcessing(new File("C:/Nikita/Servers/Schedule/Backend/default_lessons_ins.xlsx"));
//        context.getBean(ScheduleDefaultParseService.class).fileProcessing(new File("C:/Users/NikitaVoV/Downloads/Raspisanie_INB_ISP_INS.xlsx"));
//        context.getBean(SheetScheduleInitializationService.class).fileProcessing(file);
    }
}
