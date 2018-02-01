package com.jaaaelu.gzw.clean_code.format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class F5_5 {
    //  5.5. Bob 大叔的格式规则

    //  以下代码可以看做是展示如何把代码写好的最好标准范例

    public static class CodeAnalyzer implements JavaFileAnalyzer {
        private int lineCount;
        private int maxLineWidth;
        private int widestLineNumber;
        private LineWidthHistogram lineWidthHistogram;
        private int totalChars;

        public CodeAnalyzer() {
            lineWidthHistogram = new LineWidthHistogram();
        }

        public static List<File> findJavaFiles(File parentDirectory) {
            List<File> files = new ArrayList<>();
            findJavaFiles(parentDirectory, files);
            return files;
        }

        private static void findJavaFiles(File parentDirectory, List<File> files) {
            for (File file : parentDirectory.listFiles()) {
                if (file.getName().endsWith(".java"))
                    files.add(file);
                else if (file.isDirectory())
                    findJavaFiles(file, files);
            }
        }

        public void analyzeFile(File file) throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null)
                measureLine(line);
        }

        private void measureLine(String line) {
            lineCount++;
            int lineSize = line.length();
            totalChars += lineSize;
            lineWidthHistogram.addLine(lineSize, lineCount);
            recordWidestLine(lineSize);
        }

        private void recordWidestLine(int lineSize) {
            if (lineSize > maxLineWidth) {
                maxLineWidth = lineSize;
                widestLineNumber = lineCount;
            }
        }

        public int getLineCount() {
            return lineCount;
        }

        public int getMaxLineWidth() {
            return maxLineWidth;
        }

        public int getWidestLineNumber() {
            return widestLineNumber;
        }

        public LineWidthHistogram getLineWidthHistogram() {
            return lineWidthHistogram;
        }

        public double getMeanLineWidth() {
            return (double) totalChars / lineCount;
        }

        public int getMedianLineWidth() {
            Integer[] sortedWidths = getSortedWidths();
            int cumulativeLineCount = 0;
            for (int width : sortedWidths) {
                cumulativeLineCount += lineCountForWidth(width);
                if (cumulativeLineCount > lineCount / 2) {
                    return width;
                }
            }
            throw  new Error("Cannot get here");
        }

        private int lineCountForWidth(int width) {
            return lineWidthHistogram.getLinesForWidth(width).size();
        }

        private Integer[] getSortedWidths() {
            Set<Integer> widths = lineWidthHistogram.geWidths();
            Integer[] sortedWidths = widths.toArray(new Integer[0]);
            Arrays.sort(sortedWidths);
            return sortedWidths;
        }
    }

    private static class LineWidthHistogram {

        public void addLine(int lineSize, int lineCount) {
            //  TODO 未知实现
        }

        public List<Integer> getLinesForWidth(int width) {
            //  TODO 未知实现
            return null;
        }

        public Set<Integer> geWidths() {
            //  TODO 未知实现
            return null;
        }
    }
}
