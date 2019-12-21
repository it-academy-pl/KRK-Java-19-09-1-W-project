package pl.itacademy.schedule.generator;

import pl.itacademy.schedule.parameters.EnteredParameters;

public interface IScheduleGenerator {
    Schedule generateSchedule(EnteredParameters enteredParameters);
}
