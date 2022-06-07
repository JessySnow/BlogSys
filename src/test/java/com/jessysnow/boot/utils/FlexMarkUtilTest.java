package com.jessysnow.boot.utils;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.junit.Test;

import java.awt.desktop.SystemSleepEvent;

public class FlexMarkUtilTest {
    String markDown = "";

    @Test
    public void testOnParseMarkDown(){
        String html = FlexMarkUtil.parseMarkDown(markDown);
        System.out.println(html);
    }
}
