import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MainTests {
	Main mainObject;
	
	@Before
	public void setUp(){
		mainObject=new Main();
	}
	
	@Test
	public void adunareTest() {
		int rez=mainObject.adunare(1, 2);
		assertEquals(3, rez);
	}
	@Test
	public void scadereTest() {
		int rez=mainObject.scadere(3, 2);
		assertEquals(1, rez);
	}
	@Test
	public void inmultireTest() {
		int rez=mainObject.adunare(2, 2);
		assertEquals(4, rez);
	}

}
