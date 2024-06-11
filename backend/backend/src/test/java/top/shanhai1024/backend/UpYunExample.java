//package top.shanhai1024.backend;
//
//import com.UpYun;
//import com.upyun.UpException;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class UpYunExample {
//    public static void main(String[] args) {
//        // UpYun 配置
//        String serviceName = "graduationdesign";
//        String userName = "graduationdesign";
//        String password = "31g9pcxG2681ToeQYvYxe7sVfFDijdFe";
//        String directoryPath = "/bysjImg"; // 目标目录路径
//        UpYun upYun = new UpYun(serviceName, userName, password);
//        Map<String, String> parameters = new HashMap<>();
//
//
//        try {
//            // 获取目录下的所有文件
//            List<UpYun.FolderItem> allItems = getAllFilesInDirectory(upYun, directoryPath);
//            for (UpYun.FolderItem item : allItems) {
//                System.out.println("文件名: " + item.name);
//            }
//        } catch (IOException | UpException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 递归获取目录下的所有文件
//    private static List<UpYun.FolderItem> getAllFilesInDirectory(UpYun upYun, String directoryPath) throws IOException, UpException {
//        Map<String, String> parameters = new HashMap<>();
//        List<UpYun.FolderItem> result = new ArrayList<>();
//        List<UpYun.FolderItem> items = upYun.readDir(directoryPath,parameters);
//
//        for (UpYun.FolderItem item : items) {
//            if (item.type.equals("N")) {
//                // 如果是文件，添加到结果列表
//                result.add(item);
//            } else if (item.type.equals("F")) {
//                // 如果是目录，递归获取该目录下的文件
//                List<UpYun.FolderItem> subItems = getAllFilesInDirectory(upYun, directoryPath + "/" + item.name);
//                result.addAll(subItems);
//            }
//        }
//
//        return result;
//    }
//}