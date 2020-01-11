package pl.itacademy.schedule;

import org.apache.commons.cli.ParseException;
import pl.itacademy.schedule.excel.WorkbookCreator;
import pl.itacademy.schedule.generator.Schedule;
import pl.itacademy.schedule.generator.ScheduleGenerator;
import pl.itacademy.schedule.holidays.HolidayChecker;
import pl.itacademy.schedule.holidays.HolidaysCheckerFactory;
import pl.itacademy.schedule.parameters.EnteredParameters;
import pl.itacademy.schedule.parameters.ParametersReader;
import pl.itacademy.schedule.util.PropertiesReader;

public class ScheduleGeneratorApp {
    public static void main(String[] args) throws ParseException {
        PropertiesReader propertiesReader = PropertiesReader.getInstance();
        ParametersReader parametersReader = new ParametersReader();
        EnteredParameters enteredParameters = parametersReader.readParameters(args);
        HolidaysCheckerFactory holidaysCheckerFactory = new HolidaysCheckerFactory();
        HolidayChecker holidayChecker = holidaysCheckerFactory.createHolidaysChecker(propertiesReader.readProperty("holidayChecker.type"));
        ScheduleGenerator scheduleGenerator = new ScheduleGenerator(holidayChecker);
        Schedule schedule = scheduleGenerator.generateSchedule(enteredParameters);
        WorkbookCreator workbookCreator = new WorkbookCreator();
        workbookCreator.createWorkbook(schedule);
        //......
    }
}
