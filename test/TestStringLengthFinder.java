import com.twu.biblioteca.StringLengthFinder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by brandonteng on 6/20/14.
 */
public class TestStringLengthFinder {
    
    @Test
    public void shouldReturnMaxStringLength(){
        StringLengthFinder lengthFinder = new StringLengthFinder();
        List<String> list = new ArrayList<String>(Arrays.asList("One", "Harry Potter And The Prisoner of Azkaban", "Two"));
        int maxLength = lengthFinder.findMaxStringLength(list);

        assertThat(maxLength, is(list.get(1).length()));
    }
}
