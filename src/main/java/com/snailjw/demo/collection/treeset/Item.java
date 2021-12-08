package com.snailjw.demo.collection.treeset;

import java.util.Objects;

/**
 * @author : snail
 * @date : 2021-12-07 16:39
 **/
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return partNumber == item.partNumber && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }


    @Override
    public int compareTo(Item o) {
        int compare = Integer.compare(o.partNumber, this.partNumber);
        return compare != 0 ? compare : description.compareTo(o.description);
    }
}
