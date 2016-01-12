package inetbanking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Log {
	@Id
	Long timestamp;
	String logMessage;
	LogType logLevel;
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getLogMessage() {
		return logMessage;
	}
	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}
	public LogType getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(LogType logLevel) {
		this.logLevel = logLevel;
	}
	
}
