package cn.edu.dll.filter.file_filter;

import java.io.File;
import java.io.FileFilter;

public class DirectoryFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        return false;
    }
}
