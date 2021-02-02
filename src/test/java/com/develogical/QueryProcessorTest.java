package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutAsimov() throws Exception {
        assertThat(queryProcessor.process("Asimov"), containsString("science fiction"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void whatIsYourName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("HYAT"));
    }
    
    @Test
    public void plusQuery() throws Exception {
        assertThat(queryProcessor.process("what is 20 plus 200"), containsString("220"));
        assertThat(queryProcessor.process("what%20is%2020%20plus%20200"), containsString("220"));
    }
}
