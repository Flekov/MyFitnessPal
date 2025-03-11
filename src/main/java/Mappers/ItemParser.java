package Mappers;

import Items.Item;

public interface ItemParser<T extends Item> {
    public T ParseItem(String line);
    public String FormatItem(T item);
}
