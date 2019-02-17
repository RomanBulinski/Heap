import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMiniHeap {

    @Test
    public void testCanAdd(){
        MinIntHeap minIntHeap = new MinIntHeap(4);
        minIntHeap.add(10);
        minIntHeap.add(15);
        assertEquals("10 15 0 0 ",minIntHeap.toString() );
    }

    @Test
    public void testCanAdd2(){
        MinIntHeap minIntHeap = new MinIntHeap(7);
        minIntHeap.add(10);
        minIntHeap.add(15);
        minIntHeap.add(1);
        assertEquals("1 15 10 0 0 0 0 ",minIntHeap.toString() );
    }

    @Test
    public void testCanPeek(){
        MinIntHeap minIntHeap = new MinIntHeap(20);
        minIntHeap.add(10);
        minIntHeap.add(3);
        minIntHeap.add(20);
        minIntHeap.add(44);
        minIntHeap.add(1);
        assertEquals(1,minIntHeap.peek() );
    }

    @Test
    public void testCanPoll(){
        MinIntHeap minIntHeap = new MinIntHeap(10);
        minIntHeap.add(10);
        minIntHeap.add(3);
        minIntHeap.add(44);
        minIntHeap.add(1);
        assertEquals(1,minIntHeap.poll() );
    }


}
