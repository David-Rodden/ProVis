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
        stack.push(data, heap.alloc(Integer.toString((int) (new Random().nextFloat() * 1000000), 16).toUpperCase(), 1));
    }

    public void addFunction(final String name) {
        stack.push("ref: " + name + "_method");
    }

    public void addInteger(final String name, final int data) {
        stack.push("ref: " + name, heap.alloc(String.format("%32s", Integer.toBinaryString(data)).replace(" ", "0"), VHeap.INTEGER));
    }

    public void addCharacter(final String name, final char data) {
        stack.push("ref: " + name, heap.alloc(String.format("%8s", Integer.toBinaryString(data)).replace(" ", "0"), VHeap.CHARACTER));
    }

    public void addCharArray(final String name, final String data) {
        final StringBuilder sb = new StringBuilder();
        for (final char c : (data + '\0').toCharArray())
            sb.append(String.format("%8s", Integer.toBinaryString(c)).replace(" ", "0"));
        stack.push("ref: " + name, heap.alloc(sb.toString(), VHeap.CHARACTER * (data.length() + 1)));
    }
}
