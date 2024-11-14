package edu.umn.d.cs2511.MLData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class MLDatasetTest {
    MLDataset dataset = new MLDataset("MLDataset.csv");
    MLDataset subset = new MLDataset("subset.csv");
    List<List<Data>> list1 = new ArrayList<List<Data>>();
    List<Data> headers = new ArrayList<Data>();
    List<Data> row1 = new ArrayList<Data>();
    List<Data> row2 = new ArrayList<Data>();
    List<Data> row3 = new ArrayList<Data>();
    List<Data> row4 = new ArrayList<Data>();
    List<Data> row5 = new ArrayList<Data>();
    String s1;


    @BeforeEach
    void setUp() {

        headers.add(new StringData("fa"));
        headers.add(new StringData("fb"));
        headers.add(new StringData("fc"));
        headers.add(new StringData("fd"));

        row1.add(new BooleanData("TRUE"));
        row1.add(new IntData(1));
        row1.add(new DoubleData(2.3));
        row1.add(new StringData("yes"));

        row2.add(new BooleanData("FALSE"));
        row2.add(new IntData(2));
        row2.add(new DoubleData(3.4));
        row2.add(new StringData("TRUE"));

        row3.add(new BooleanData("TRUE"));
        row3.add(new IntData(4));
        row3.add(new DoubleData(1.67));
        row3.add(new StringData("5"));

        row4.add(new BooleanData("FALSE"));
        row4.add(new IntData(6));
        row4.add(new DoubleData(2.1));
        row4.add(new StringData("3.2"));

        row5.add(new BooleanData("TRUE"));
        row5.add(new IntData(2));
        row5.add(new DoubleData(2.1));
        row5.add(new StringData("3.2"));

        list1.add(headers);
        list1.add(row1);
        list1.add(row2);
        list1.add(row3);
        list1.add(row4);
        list1.add(row5);

        s1 = "COMPLETE";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void MLDatasetReader() {
        assertEquals(list1.size(), dataset.MLDatasetReader().size());
        assertEquals(list1.get(0).size(), dataset.MLDatasetReader().get(0).size());
        assertEquals(list1.get(0).get(0).getStringValue(), dataset.MLDatasetReader().get(0).get(0).getStringValue());
        assertEquals(list1.get(2).get(1).getStringValue(), dataset.MLDatasetReader().get(2).get(1).getStringValue());
        assertEquals(list1.get(3).get(2).getStringValue(), dataset.MLDatasetReader().get(3).get(2).getStringValue());
    }

    @Test
    void showFile() {
        assertEquals(s1, dataset.showFile(dataset.MLDatasetReader()));
    }

    @Test
    void filterData() {
    }

    @Test
    void pickFeatures() {
    }

    @Test
    void calculate() {
    }
}