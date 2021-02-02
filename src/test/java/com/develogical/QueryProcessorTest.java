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
    public void knowsMultiplication() throws Exception {
        assertThat(queryProcessor.process("what is 18 multiplied by 14"), containsString("252"));
    }

    @Test
    public void knowsLargestNumber() throws Exception {
        assertThat(queryProcessor.process("645bb870:%20which%20of%20the%20following%20numbers%20is%20the%20largest" +
                ":%20870,%20789,%2027,%2073"), containsString("870"));
    }
}
