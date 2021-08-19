package com.consumeProducer.SpringbootUsingAMQAndFile.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		  from("activemq:my-activemq-queue")
		  .log("${body}")
		  .choice()
		  .when(body().contains("1"))
		  .to("{{my.app.destination}}?fileName=test1.txt")
		  .when(body().contains("2"))
		  .to("{{my.app.destination}}?fileName=test2.txt")
		  .when(body().contains("3"))
		  .to("{{my.app.destination}}?fileName=test3.txt")
		  .when(body().contains("4"))
		  .to("{{my.app.destination}}?fileName=test4.txt")
		  .otherwise()
		  .to("{{my.app.destination}}?fileName=test5.txt");
	}

}