package com.dfs.ace.impl;

import com.dfs.ace.ReFormatter;
import com.dfs.ace.common.Cell;
import com.dfs.ace.common.Header;
import com.dfs.ace.common.Record;
import com.dfs.ace.common.preview.PreviewData;
import com.dfs.ace.domain.Column;
import com.dfs.ace.domain.MetaData;
import com.dfs.ace.domain.Result;
import com.dfs.ace.domain.ResultData;
import com.dfs.ace.util.ReFormatterUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;


public class ReFormatterImpl implements ReFormatter{
    private static Logger logger = Logger.getLogger(ReFormatterImpl.class);
    private Properties properties = null;

    public ReFormatterImpl() {
        this.properties = ReFormatterUtil.loadProperties();
    }

    @Override
    public PreviewData format(String metaData, String data) throws Exception {
        logger.debug("formatting metaData & Data into PreviewData");
        PreviewData previewData = new PreviewData();
        Set<Record> records = new HashSet<>();


        ObjectMapper mapper = new ObjectMapper();
        try {
            MetaData inputMetaData = mapper.readValue(metaData, MetaData.class);

            ResultData inputResultData = mapper.readValue(data, ResultData.class);

            List<Header> headers;
            if (null != inputMetaData && inputMetaData.getColumn() != null) {
                List<Column> columns = inputMetaData.getColumn();

                headers = columns.stream().filter(column -> column.getAttribute() == true)
                        .map(column -> new Header(column.getId(), column.getColumn_id(), column.getName(), column.getDesc()))
                        .collect(Collectors.toList());
                previewData.setHeaders(new HashSet<>());
                previewData.getHeaders().addAll(headers);


                if (null != inputResultData && inputResultData.getResult() != null) {
                    for (Result result : inputResultData.getResult()) {
                        List<Cell> cells = new ArrayList<>();
                        int count = 0;
                        for (String value : result.getValues()) {
                            Cell cell = new Cell();
                            cell.setAttribute(headers.get(count).getAttributeName());
                            cell.setValue(value);
                            cells.add(cell);
                            count++;
                        }
                        Record record = new Record();
                        record.setCells(new HashSet<Cell>());
                        record.getCells().addAll(cells);
                        records.add(record);
                    }
                    previewData.setRecords(records);
                }

                /*if(null!= inputResultData ){
                    String delim = properties.getProperty(ReFormatterConstants.data_delim);
                    System.out.println("delim: "+delim);
                }*/
            }
        }catch (Exception e){
            logger.error("Exception in Converter Utility: ",e);
        }
        logger.debug("Exiting format");
        return previewData;
    }
}
