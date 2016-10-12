package com.chubb.rest.adapter.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by vsafronovici on 10/12/2016.
 */
public final class FileUtil {

    public static String readFileToString(String resourcePath) throws IOException {
        URL url = FileUtil.class.getResource(resourcePath);
        File file = new File(url.getFile());
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

}
