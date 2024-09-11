package debugging;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class Main {
	@Test
	public void main() {
		System.out.println("Let's check this string");
		String str1 = "Let's check this string";
		assertEquals("Let's check this string", str1);
	}

}
