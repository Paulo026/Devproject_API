package org.serratec.trabalho.api.esquadrao6.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;


public class ApiError {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
	private String message;
	private String debugMessage;
	private LocalDateTime timestamp;
	
	private ApiError() {
		timestamp = LocalDateTime.now();
	}
	
	ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	}
	
	ApiError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	 }
	
	 ApiError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	 }
	 
	 public HttpStatus getStatus() {
			return status;
		}

		public void setStatus(HttpStatus status) {
			this.status = status;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDebugMessage() {
			return debugMessage;
		}

		public void setDebugMessage(String debugMessage) {
			this.debugMessage = debugMessage;
		}

}
