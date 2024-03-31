import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void testSingleArgument() { 
    assertFalse(c.compute(1)); 
  }

  @Test
  public void testEvenNumberOfArguments() { 
    assertFalse(c.compute(1,2)); 
  }

  @Rule
  public ExpectedException thrown= ExpectedException.none();

  @Test
  public void testZeroAsArgument() {
    thrown.expect(RuntimeException.class); 
    c.compute(0,1,2); 
  }

  @Test
  public void testZeroSum() {
    assertTrue(c.compute(-3,1,2)); 
  }

  @Test
  public void testSumRelativelyPrime() {
    assertFalse(c.compute(2,4,7)); 
  }

}