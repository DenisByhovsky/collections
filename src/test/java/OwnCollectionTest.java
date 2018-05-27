import com.byhovsky.collections.OwnCollectionImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OwnCollectionTest {

    OwnCollectionImpl<Integer> ownCollection;

    @Before
    public void fillData() {
        ownCollection = new OwnCollectionImpl(3);
        ownCollection.add((Integer) 10);
        ownCollection.add((Integer) 3);
        ownCollection.add((Integer) 17);
    }

    @Test
    public void sizeTest() {
        int expected = 3;
        Assert.assertEquals(expected, ownCollection.size());
    }


    @Test
    public void findAverageTest() {
        Assert.assertEquals(10, ownCollection.findAverage());
    }

    @Test
    public void findMaxTest() {
        Assert.assertEquals(17, (int) ownCollection.findMaxElement());
    }

    @Test
    public void findMinTest() {
        Assert.assertEquals(3, (int) ownCollection.findmMinElement());
    }

    @Test
    public void deleteItemTest() {
        Assert.assertTrue(ownCollection.delete(0));
    }
}
