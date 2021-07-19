package com.mooveit.cars;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mooveit.cars.tasks.FordIngesterTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarsApplicationTests {

  @Autowired
  private FordIngesterTask parser;

  // not complete
  @Test
  public void contextLoads() throws IOException {
	  parser.ingestFile();
	  assertTrue(true);
  }

}
