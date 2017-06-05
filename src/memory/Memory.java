package memory;

import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;

import java.util.Random;

/**
 * Created by David on 6/4/2017.
 */
public class Memory {
    private final VStack stack;
    private final VHeap heap;

    public Memory(final VBox stack, final VBox heap, final Path refPath) {
        this.stack = new VStack(stack, refPath);
        this.heap = new VHeap(heap);
    }

    public void addData(final String data) {
        stack.push(data, heap.alloc(Integer.toString((int) (new Random().nextFloat() * 1000000), 16).toUpperCase()));
    }
}
