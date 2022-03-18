package main;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;

enum WeekDay{
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}

public class Schedule implements Serializable{
	private WeekDay weekDay;
	private LocalTime startTime;
	private LocalTime finishTime;
	public enum WeekDay{
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}
	
	public WeekDay getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}
	
	public Schedule() {}
	public Schedule(WeekDay weekDay,LocalTime start,LocalTime finish) {
		this.weekDay=weekDay;
		this.startTime=start;
		this.finishTime=finish;
	}
	
}
