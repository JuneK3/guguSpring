package org.zerock.sample;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.config.RootConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTests {
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;

	@Test
	public void testExist() {
		assertNotNull(restaurant);
		log.info(restaurant);
		log.info("------------------------");
		log.info(restaurant.getChef());
	}
}