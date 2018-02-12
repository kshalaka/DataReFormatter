package com.dfs.ace.impl;

import com.dfs.ace.common.preview.PreviewData;
import com.dfs.ace.domain.Column;
import com.dfs.ace.domain.MetaData;
import com.dfs.ace.domain.Result;
import com.dfs.ace.domain.ResultData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReFormatterImplTest {
    private ReFormatterImpl reFormatter = new ReFormatterImpl();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFormat() throws Exception {

        List<Column> columns = new ArrayList<>();
        Column column1 = new Column("id1","1","name1","desc1",true);
        columns.add(column1);

        column1 = new Column("id2","2","name2","desc2",false);
        columns.add(column1);

        column1 = new Column("id3","3","name3","desc3",true);
        columns.add(column1);

        column1 = new Column("id4","4","name4","desc4",true);
        columns.add(column1);

        List<Result> results = new ArrayList<>();
        MetaData metadata = new MetaData(columns);
        String[] myStrings = { "value1","value2","value3"};
        List<String> values = Arrays.asList(myStrings);
        Result result = new Result(values);
        results.add(result);

        String[] myStrings1 = {"value4","value5","value6"};
        values = Arrays.asList(myStrings1);
        result = new Result(values);
        results.add(result);

        String[] myStrings2 = {"value7","value8","value9"};
        values = Arrays.asList(myStrings2);
        result = new Result(values);
        results.add(result);

        ResultData resultData = new ResultData(results);

        ObjectMapper mapper = new ObjectMapper();
        String jsonMetaData = mapper.writeValueAsString(metadata);

        String jsonResultData = mapper.writeValueAsString(resultData);

        PreviewData obj = reFormatter.format(jsonMetaData, jsonResultData);

        System.out.print(obj.toString());

        assertNotNull(obj);

        assertEquals(3,obj.getHeaders().size());

        assertEquals(3,obj.getRecords().size());

    }

}