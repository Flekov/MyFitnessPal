package Services;

import Items.Item;
import Repositories.ReaderWriter;

import java.io.IOException;

public abstract class Service<T extends Item> {
    protected ReaderWriter<T> readerWriter;
    public boolean Close() throws IOException {
        return readerWriter.Close();
    }
}
