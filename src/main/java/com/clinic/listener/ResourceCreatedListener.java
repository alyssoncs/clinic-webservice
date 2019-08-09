package com.clinic.listener;

import com.clinic.event.ResourceCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class ResourceCreatedListener implements ApplicationListener<ResourceCreatedEvent> {
	@Override
	public void onApplicationEvent(ResourceCreatedEvent createdResource) {
		HttpServletResponse response = createdResource.getHttpServletResponse();
		Long id = createdResource.getId();

		addHeaderLocation(response, id);
	}

	private void addHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(id).toUri();

		response.setHeader("Location", uri.toASCIIString());
	}
}
