package com.consumeProducer.SpringbootUsingAMQAndFile.producer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("{{my.app.source}}")
		//.log("${body}")
		//.log("Messagge produced")
		.split().tokenize("\n")
		.log("${body}")
		.to("activemq:my-activemq-queue");
	}

}
