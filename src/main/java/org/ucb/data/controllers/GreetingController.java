package org.ucb.data.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.ucb.data.model.Greeting;


//@RestController
public class GreetingController {
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();	
    
   /*@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    */

}
