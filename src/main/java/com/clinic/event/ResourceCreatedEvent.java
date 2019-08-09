package com.clinic.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Data
public class ResourceCreatedEvent extends ApplicationEvent {

	private HttpServletResponse httpServletResponse;
	private Long id;

	public ResourceCreatedEvent(Object source, HttpServletResponse httpServletResponse, Long id) {
		super(source);
		this.httpServletResponse = httpServletResponse;
		this.id = id;
	}

}
