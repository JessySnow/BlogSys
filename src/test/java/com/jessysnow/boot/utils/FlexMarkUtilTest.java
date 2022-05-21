package com.jessysnow.boot.utils;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.junit.Test;

import java.awt.desktop.SystemSleepEvent;

public class FlexMarkUtilTest {
    String markDown = "## 一级标题（1 绪论）\n" +
            "\n" +
            "### 二级标题（1.1 背景介绍）\n" +
            "\n" +
            "#### 三级标题（1.1.1 国内现状介绍）\n" +
            "\n" +
            "再细分的内容采用 **(1)细分内容代替** \n" +
            "\n" +
            "![图片](http2s://img-blog.csdnimg.cn/20190811133756709.png)";
    @Test
    public void testOnParseMarkDown(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String html = FlexMarkUtil.parseMarkDown(markDown);
                System.out.println(html);
            }
        };

        for(int i = 0; i < 10; ++ i){
            Thread thread = new Thread(runnable);
            thread.run();
        }
    }
}
