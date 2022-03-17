package codility.test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SolutionIterable implements Iterable<Integer> {
    private final Reader reader;

    public SolutionIterable(Reader inp){
        this.reader = inp;
    }

    public Iterator<Integer> iterator() {
        List<Integer> list = new ArrayList<>();
        int charCode;
        StringBuilder line = new StringBuilder();
        String s;
        int number;
        try {
            while (true) {
                charCode = reader.read();
                if (charCode == 10 || charCode == -1) {
                    s = line.toString();
                    s = s.trim();
                    try {
                        number = Integer.parseInt(s);
                        list.add(number);
                    } catch (NumberFormatException exception) {

                    }

                    line = new StringBuilder("");
                    if (charCode == -1) break;
                } else {
                    line.append((char) charCode);
                }

            }
            reader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return list.iterator();
    }

    public static void main(String[] args) {
        String s = "12\n-12\n13";
        Reader reader = new StringReader(s);
        SolutionIterable solutionIter = new SolutionIterable(reader);
        for (Integer i : solutionIter) {
            System.out.print(i + " ");
        }
    }
}