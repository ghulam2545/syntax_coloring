package com.ghulam;

public class Lexer {
    private static String m_source;
    private static int m_len;
    private static int m_cursor;

    public static void highlight(String source) {
        m_source = source;
        m_len = source.length();
        m_cursor = 0;

        while (!eof()) {
            char curr = consume();

            switch (curr) {
                case '(':
                case ')':
                case '{':
                case '}':
                    print(Color.YELLOW + curr + Color.RESET);
                    break;

                case '#': {
                    String buffer = "";
                    buffer += curr;

                    while (is_alpha_num(next_char())) {
                        curr = consume();
                        buffer += curr;
                    }

                    print(Color.MAGENTA + buffer + Color.RESET);
                }
                    break;

                case '/': {
                    char next = next_char();
                    String buffer = "";
                    buffer += curr;
                    if (next == '/') {
                        while (next_char() != '\n') {
                            curr = consume();
                            buffer += curr;
                        }
                    } else if (next == '*') {
                        while (next_char() != '/') {
                            curr = consume();
                            buffer += curr;
                        }
                    }
                    print(Color.GRAY + buffer + Color.RESET);
                }
                    break;

                case '"': {
                    String buffer = "";
                    buffer += curr;

                    while (next_char() != '"') {
                        curr = consume();
                        buffer += curr;
                    }
                    curr = consume();
                    buffer += curr;

                    print(Color.RED + buffer + Color.RESET);
                }
                    break;

                default:
                    if (is_alpha(curr)) {
                        String buffer = "";
                        buffer += curr;

                        while (is_alpha_num(next_char())) {
                            curr = consume();
                            buffer += curr;
                        }

                        boolean is_key = Keyword.get(buffer);

                        if (is_key)
                            print(Color.GREEN + buffer + Color.RESET);
                        else {
                            if (buffer.equals("endl"))
                                print(Color.WHITE + buffer + Color.RESET);
                            else
                                print(Color.BLUE + buffer + Color.RESET);
                        }
                    }

                    else
                        System.out.print(curr);
                    break;
            }
        }
    }

    /*************************************************
     * helper
     * 
     */

    private static void print(Object val) {
        System.out.print(val);
    }

    private static boolean eof() {
        return m_cursor >= m_len;
    }

    private static char next_char() {
        if (eof())
            return '\0';

        return m_source.charAt(m_cursor);
    }

    private static char consume() {
        if (eof())
            return '\0';

        m_cursor = m_cursor + 1;
        return m_source.charAt(m_cursor - 1);
    }

    private static boolean is_digit(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    private static boolean is_alpha(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch == '_');
    }

    private static boolean is_alpha_num(char ch) {
        return is_digit(ch) || is_alpha(ch);
    }
}
