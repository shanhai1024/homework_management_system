package com.example.utils;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;
/**
 * @author null
 * 将多个文件打包为zip文件
 */
public class FilePackagingZIP {

    public static void main(String[] args) {
        List<String> urls = new ArrayList<>();
        urls.add("https://example.com/file1.txt");
        urls.add("https://example.com/file2.txt");

        File zipFile = downloadAndCreateZip(urls);
        System.out.println("ZIP文件创建成功: " + zipFile.getAbsolutePath());
        // 现在您可以返回zipFile给用户供下载
    }

    public static File downloadAndCreateZip(List<String> urls) {
        String tempDir = "temp_zip";
        String zipFilePath = "downloaded_files.zip";

        try {
            // 创建临时目录
            Files.createDirectories(Paths.get(tempDir));

            // 下载文件并保存到临时目录
            for (String url : urls) {
                String fileName = url.substring(url.lastIndexOf("/") + 1);
                Path filePath = Paths.get(tempDir, fileName);
                URL fileUrl = new URL(url);
                try (InputStream in = fileUrl.openStream()) {
                    Files.copy(in, filePath, StandardCopyOption.REPLACE_EXISTING);
                }
            }

            // 创建ZIP文件并添加文件
            try (FileOutputStream fos = new FileOutputStream(zipFilePath);
                 BufferedOutputStream bos = new BufferedOutputStream(fos);
                 ZipOutputStream zos = new ZipOutputStream(bos)) {

                File tempDirFile = new File(tempDir);
                for (File file : tempDirFile.listFiles()) {
                    addToZipFile(file, zos);
                }
            }

            // 删除临时目录
            FileUtils.deleteDirectory(new File(tempDir));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new File(zipFilePath);
    }

    private static void addToZipFile(File file, ZipOutputStream zos) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
        }
    }


}
