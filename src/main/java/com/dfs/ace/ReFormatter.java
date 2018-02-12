package com.dfs.ace;

import com.dfs.ace.common.preview.PreviewData;

public interface ReFormatter {

    public PreviewData format(String metaData, String data) throws Exception;

}
