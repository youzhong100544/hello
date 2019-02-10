package com.hello;

import java.io.File;

public class FileOperation {

    public static void main(String args[]) {
        // folder
        // directory

        String path = "D:\\学习\\机器学习\\04.机器学习\\机器学习其他资料\\龙星计划_机器学";
        // String path = "D:\\学习\\机器学习\\04.机器学习\\机器学习其他资料\\龙星计划_机器学\\Lecture01（更多视频资料关注微信公众号【菜鸟要飞】）.mp4";


        showPathFile(path);

        //fileRename(path, "Lecture01（更多视频资料关注微信公众号【菜鸟要飞】）.mp4", "Lecture01.mp4");


        deleteFileNameField(path,"（更多视频资料关注微信公众号【菜鸟要飞】）");

    }

    /**
     * 显示当前目录下的文件（包括所有的子文件）
     *
     * @param path
     *          目录路径
     */
    public static void showPathFile(String path) {

        int currentPathDepth = 0;

        int fileNum = 0;
        int folderNum = 0;

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("文件目录不存在!");
        }

        System.out.println("当前目录：" + path + "\t");
        System.out.println("当前目录深度：" + currentPathDepth);

        System.out.println("");

        File[] fileArray = file.listFiles();

        // System.out.println("文件夹:" + fileArray[i].getParentFile()); // D:\a\b
        // System.out.println("文件夹:" + fileArray[i].getAbsolutePath()); // D:\a\b\a.txt
        // System.out.println("文件夹:" + fileArray[i].getName()); // a.txt
        for (int i = 0; i < fileArray.length; i++) {

            int currentFolderDepth = currentPathDepth;

            if (fileArray[i].isDirectory()) {
                if (i != (fileArray.length - 1)){
                    System.out.println("├─ " + fileArray[i].getName());
                } else {
                    System.out.println("└─ " + fileArray[i].getName());
                }

                showChildPathFile(fileArray[i].getAbsolutePath(), currentFolderDepth );

                folderNum++;
            } else {

                if (i != (fileArray.length - 1)){
                    System.out.println("├─ " + fileArray[i].getName());
                } else {
                    System.out.println("└─ " + fileArray[i].getName());
                }

                fileNum++;
            }
        }


        System.out.println("");

        System.out.println("文件共有:" + fileNum);
        System.out.println("文件夹共有:" + folderNum);
    }

    public static void showChildPathFile(String path, int currentFolderDepth) {

        currentFolderDepth++;

        int fileNum = 0;
        int folderNum = 0;

        File file = new File(path);

        System.out.println(getPrefix(currentFolderDepth) + "当前目录：" + path + "\t");
        System.out.println(getPrefix(currentFolderDepth) + "当前目录深度：" + currentFolderDepth);

        //System.out.println("");


        File[] fileArray = file.listFiles();

        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].isDirectory()) {
                if (i != (fileArray.length - 1)){
                    System.out.println(getPrefix(currentFolderDepth) + "├─ " + fileArray[i].getName());
                } else {
                    System.out.println(getPrefix(currentFolderDepth) + "└─ " + fileArray[i].getName());
                }
                showChildPathFile(fileArray[i].getAbsolutePath(), currentFolderDepth);
                folderNum++;
            } else {
                if (i != (fileArray.length - 1)){
                    System.out.println(getPrefix(currentFolderDepth) + "├─ " + fileArray[i].getName());
                } else {
                    System.out.println(getPrefix(currentFolderDepth) + "└─ " + fileArray[i].getName());
                }

                fileNum++;
            }
        }

        System.out.println("");

        System.out.println(getPrefix(currentFolderDepth) + "文件共有:" + fileNum);
        System.out.println(getPrefix(currentFolderDepth) + "文件夹共有:" + folderNum);

        System.out.println("");

    }


    public static String getPrefix(int currentFolderDepth) {
        String prefix = "";
        if (currentFolderDepth >0) {
            for (int i = 0; i < currentFolderDepth; i++) {
                prefix += "\t";
            }
        }
        return prefix;
    }


    public static void fileRename(String path, String oldFileName, String newFileName) {

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("文件目录不存在!");
        }

        if (oldFileName.equals(newFileName)){//新的文件名和以前文件名不同时,才有必要进行重命名
            System.out.println("新文件名和旧文件名相同...");
        }

        File oldFile = new File(path + "\\" + oldFileName);
        File newFile = new File(path + "\\" + newFileName);
        if (!oldFile.exists()) {
            System.out.println(oldFileName+"旧文件不存在！");
            return;
        }
        if (newFile.exists()) {//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
            System.out.println(newFileName+"新文件已经存在！");
        }

        oldFile.renameTo(newFile);

        System.out.println("文件重命名成功！");
    }


    public static void deleteFileNameField(String path, String fileNameFieldDelete) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("文件目录不存在!");
        }


        File[] fileArray = file.listFiles();

        for (int i = 0; i < fileArray.length; i++) {

            //System.out.println("文件夹:" + fileArray[i].getAbsolutePath()); // D:\a\b\a.txt
            String oldFileName = fileArray[i].getName();
            String newFileName = null;
            if (oldFileName.contains(fileNameFieldDelete)) {
                newFileName = oldFileName.replace(fileNameFieldDelete, "");
            }

            if (newFileName != null) {
                fileRename(path, oldFileName, newFileName);
            }

        }
    }

}
