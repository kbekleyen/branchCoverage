import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testOccurrences_Empty() {
    MessageQueue mq = mock(MessageQueue.class);
    Mockito.when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    assertEquals(c.countNumberOfOccurrences(""),-1);
  }

  @Test
  public void testOccurrences_NoOccurrence() {
    MessageQueue mq = mock(MessageQueue.class);
    Mockito.when(mq.size()).thenReturn(3);
    Mockito.when(mq.contains("test1")).thenReturn(false);
    c = new Compute(mq);
    assertEquals(c.countNumberOfOccurrences("test1"),0);
  }

  @Test
  public void testOccurrences() {
    MessageQueue mq = mock(MessageQueue.class);
    Mockito.when(mq.size()).thenReturn(3);
    Mockito.when(mq.contains("test1")).thenReturn(true);
    Mockito.when(mq.getAt(0)).thenReturn("test0");
    Mockito.when(mq.getAt(1)).thenReturn("test1");
    Mockito.when(mq.getAt(2)).thenReturn("test2");
    c = new Compute(mq);
    assertEquals(c.countNumberOfOccurrences("test1"),1);
  }

  
}