package org.class_11_01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String expressionText = "122 - 1 * (11 * 2)";
        List<Lexeme> lexemes = lexAnalyze(expressionText);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        System.out.println(expr(lexemeBuffer));
    }

    // 1. Зададим тип лексем
    public enum LexemeType {
        LEFT_BRACKET,
        RIGHT_BRACKET,
        OP_PLUS,
        OP_MINUS,
        OP_MULT,
        OP_DIV,
        NUMBER,
        END;
    }

    // 2.  класс для предоставления отдельной лексемы
    public static class Lexeme {
        LexemeType type; // тип лексемы
        String value; // чем наша лексема является в тексте

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    //    3. Вспомогательный класс для хранения инфы прохода по массиву
    public static class LexemeBuffer {
        private int pos;
        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }

    // 3. Функция лексического анализа (принмает строку с выражением и возвращает массив лексем)
    public static List<Lexeme> lexAnalyze(String expText) {
        // для хранения лексем
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        // указатель движения по стринге
        int pos = 0;

//        пока мы не дошли до конца нашего текса
//        мы будем иди по строке и генерировать лексемы
        while (pos < expText.length()) {
            //берем символ из текста и добавляем в массив
            char c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    // двигаемся дальше
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    // двигаемся дальше
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    // двигаемся дальше
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                    // двигаемся дальше
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.OP_MULT, c));
                    // двигаемся дальше
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                    // двигаемся дальше
                    pos++;
                    continue;
                default:
                    // проверяем на цифры
                    if (c <= '9' && c >= '0') {
                        // создать стрингбилдер в который мы будет добавлять наши символы
                        StringBuilder sb = new StringBuilder();
                        //смысл цикла в том что мы вписываем все цифры
                        //и добавляем их в массив лексем
                        //до тех пор, пока не встретиться что то другое
                        //и склеиваем их в одно число, после этого
                        //число добавляем в массив лексем
                        do {
                            sb.append(c);
                            pos++;
                            // если достигли конца строки то break
                            if (pos >= expText.length()) {
                                break;
                            }
                            //достаем след символ из строки
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                    } else {
                        //а если не число
                        //если символ не пробел
                        if(c != ' ') {
                            //то в нашем выражении ошибка
                            throw new RuntimeException("Unexpected character:" + c);
                        }
                        //a если пробел
                        pos++;
                    }
            }
        }
        //в самом конце надо добавить лексему END
        //и вернуть массив лексем
        lexemes.add(new Lexeme(LexemeType.END, ""));
        return lexemes;
    }


    //синтакс анализатор
    public static int expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        //сделать проверку на пустое выражение
        //если первая лексема это конец строки то вернем 0
        if (lexeme.type == LexemeType.END) {
            return 0;
        } else {
            //иначе вернемся назад и запустим вычисления + и -
            //будем смотреть на выражение внутри начиная с + и -
            lexemes.back();
            return plusMinus(lexemes);
        }
    }

    public static int factor(LexemeBuffer lexemes) {
        //прочитать лексему
        Lexeme lexeme = lexemes.next();
        //смотрим ее тип
        switch (lexeme.type) {
            case NUMBER: //если лексема само число
                return Integer.parseInt(lexeme.value);
            case LEFT_BRACKET:
                //если левая скобка
                //то смотрим что в скобках
                int value = expr(lexemes);
                lexeme = lexemes.next();
                //25+9-(16*5-(11+6))
                //если правой скобки нет то выражение не верно
                if(lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token:" + lexeme.value);
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token:" + lexeme.value);
        }
    }

    public static int multDiv(LexemeBuffer lexemes) {
        //значение первого числа(фактора)
        int value = factor(lexemes);
        //25+9-(16*5-(11+6))
        while (true) {
            //достаем след лексему
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MULT:
                    value  = value * factor(lexemes);
                    break;
                case OP_DIV:
                    value = value / factor(lexemes);
                    break;
                case END:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                    //если мы не умножаем и не делим то возвращаем
                    //указатель назад
                    //и возвращаем позицию первого множителя
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token:" + lexeme.value);
            }
        }
    }

    public static int plusMinus(LexemeBuffer lexemes) {
        int value = multDiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value = value + multDiv(lexemes);
                    break;
                case OP_MINUS:
                    value = value - multDiv(lexemes);
                case END:
                case RIGHT_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token:" + lexeme.value);
            }
        }
    }
}
