package moblie.tiy.androidappchat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jaylon Breckenridge on 5/11/2016.
 */
public class ChatClientTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendMessage() throws Exception {

        ChatClient mySuperClient = new ChatClient();
        String message = "Hey";
        String exceptedResponse = message;
        String serverResponse = mySuperClient.sendMessage(message);

        assertEquals(exceptedResponse,serverResponse);
    }

    @Test
    public void testReturnMessage() throws Exception {

    }
}