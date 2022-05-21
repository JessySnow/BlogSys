package com.jessysnow.boot.utils;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.springframework.stereotype.Component;

/**
 * 对博客正文进行解析
 * 将博客正文的 MarkDown 转换为 HTML
 */
public class FlexMarkUtil {
    private static MutableDataSet options;
    private static Parser parser;
    private static HtmlRenderer renderer;

    static {
        options = new MutableDataSet();
        parser = Parser.builder(options).build();
        renderer = HtmlRenderer.builder(options).build();
    }

    public static String parseMarkDown(String content){
        Node markdown = parser.parse(content);
        return renderer.render(markdown);
    }
}
