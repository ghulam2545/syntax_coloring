package com.ghulam;

import java.util.HashSet;
import java.util.Set;

public class Keyword {
    public static final Set<String> keywords = new HashSet<>();
    static {
        keywords.add("auto");
        keywords.add("bool");
        keywords.add("break");
        keywords.add("case");
        keywords.add("catch");
        keywords.add("char");
        keywords.add("class");
        keywords.add("const");
        keywords.add("constexpr");
        keywords.add("continue");
        keywords.add("delete");
        keywords.add("do");
        keywords.add("double");
        keywords.add("else");
        keywords.add("enum");
        keywords.add("false");
        keywords.add("float");
        keywords.add("for");
        keywords.add("friend");
        keywords.add("goto");
        keywords.add("if");
        keywords.add("int");
        keywords.add("long");
        keywords.add("namespace");
        keywords.add("new");
        keywords.add("operator");
        keywords.add("private");
        keywords.add("protected");
        keywords.add("public");
        keywords.add("return");
        keywords.add("static");
        keywords.add("struct");
        keywords.add("switch");
        keywords.add("template");
        keywords.add("this");
        keywords.add("true");
        keywords.add("try");
        keywords.add("using");
        keywords.add("void");
    }

    public static boolean get(String key) {
        return keywords.contains(key);
    }
}
