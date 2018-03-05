package com.velvol.hr.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <dl>
 * <dt>ProjectName : infoyb-data-platform </dt>
 * <dt>PakageName : com.infoyb.common.utils.upload </dt>
 * <dt>ClassName: UploadImage </dt>
 * <dd>CreateDate: 2017-08-29 13:58 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:      上传图片      </dd>
 * </dl>
 *
 * @author wangjun
 */
public class UploadFileUtils {

    private static final Logger logger = Logger.getLogger(UploadFileUtils.class);

    // 存放下载文件的目录
    private static final String TEMPDOWNLOAD = "tempDownload";
    // 存放下载文件的路径
    private static String TEMPDOWNLOADPATH;



    /**
     * 上传图片
     *
     * @param request      请求
     * @param path_deposit 存放位置(路径)
     * @param file         文件
     * @param isRandomName 是否随机名称
     * @return 完整文件路径
     */
    public static String uploadImage(HttpServletRequest request, String path_deposit, File file, boolean isRandomName, String fileFileName) {
        //上传
        try {
//            String[] typeImg = {"jpg", "png","gif","jpeg","txt","doc","dos","xls","docx","xlsx","zip","rar","ppt","pptx","exe","bmp"};
//
            if (file != null) {
                //String origName = fileFileName;// 文件原名称
                System.out.println("上传的文件原名称:" + fileFileName);
                // 判断文件类型
                String type = fileFileName.indexOf(".") != -1 ? fileFileName.substring(fileFileName.lastIndexOf(".") + 1, fileFileName.length()) : null;
                if (type != null) {
                    boolean booIsType = true;
//                    for (int i = 0; i < typeImg.length; i++) {
//                        if (typeImg[i].equals(type.toLowerCase())) {
//                            booIsType = true;
//                        }
//                    }
                    //类型正确
                    if (booIsType) {
                        //存放图片文件的路径
                        String path = request.getSession().getServletContext().getRealPath(path_deposit);
                        //组合名称
                        String fileSrc = "";
                        //是否随机名称
                        if (isRandomName) {
                            fileFileName = DateUtil.formatDate(new Date(), "yyyy-MM-dd") + UUID.randomUUID().toString() + fileFileName.substring(fileFileName.lastIndexOf("."));
                        }
                        //判断是否存在目录
                        File targetFile = new File(path, fileFileName);
//                        if (!targetFile.exists()) {
//                            targetFile.mkdirs();//创建目录
//                        }
                        //上传
                        FileUtils.copyFile(file, targetFile);
                        //file.(targetFile);
                        //完整路径
                        //fileSrc=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+path_deposit+origName;
                        fileSrc = request.getContextPath() + path_deposit + fileFileName;
                        System.out.println("图片上传成功:" + fileSrc);
                        return fileSrc;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 上传附件
     *
     * @param request      请求
     * @param path_deposit 存放位置(路径)
     * @param file         文件
     * @param isRandomName 是否随机名称
     * @return 完整文件路径
     */
    public static String uploadFile(HttpServletRequest request, String path_deposit, MultipartFile file, boolean isRandomName) {
        //上传
        try {
            if (file != null) {
                String origName = file.getOriginalFilename();// 文件原名称
                System.out.println("上传的文件原名称:" + origName);
                // 判断文件类型
                String type = origName.indexOf(".") != -1 ? origName.substring(origName.lastIndexOf(".") + 1, origName.length()) : null;
                if (type != null) {
                    //存放文件的路径
                    String path = request.getSession().getServletContext().getRealPath(path_deposit);
                    //组合名称
                    String fileSrc = "";
                    //是否随机名称
                    if (isRandomName) {
                        origName = DateUtil.formatDate(new Date(), "yyyyMMddHHmmss") +"_"+ origName;
                    }
                    //判断是否存在目录
                    File targetFile = new File(path, origName);
                    if (!targetFile.exists()) {
                        targetFile.mkdirs();//创建目录
                    }
                    //上传
                    file.transferTo(targetFile);
                    //存放路径
                    fileSrc = request.getContextPath() + path_deposit + origName;
                    System.out.println("附件上传成功:" + fileSrc);
                    return fileSrc;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 文件批量下载
     *
     * @param fileURL 文件的存储路径
     *                map中存储
     *                key:fastdfs 中路径
     *                value:文件原名
     * @param userId 用户id
     * @param response
     * @return 返回压缩后的ZIP包名
     * @throws Exception
     * @Author beamzhang
     */
//    public static String batchDownloadFile(Map<String, String> fileURL, Long userId, HttpServletResponse response, HttpServletRequest request) throws Exception {
//        String dirPath = "";
//        boolean result = false;
//        String zipName = null;
//        if (null != fileURL && fileURL.size() > 0){
//            //建立连接
//            TrackerClient tracker = new TrackerClient();
//            TrackerServer trackerServer = tracker.getConnection();
//            StorageServer storageServer = null;
//            StorageClient1 client = new StorageClient1(trackerServer, storageServer);
//            dirPath = createDir(userId);
//            for (Map.Entry<String, String> entry : fileURL.entrySet()) {
//                String filePath = entry.getKey();
//                String groupName = filePath.substring(0, filePath.indexOf("/"));
//                String remoteFile = filePath.substring(filePath.indexOf("/")+1);
//                byte[] bytes = client.download_file(groupName, remoteFile);
//                if (null != dirPath && dirPath.length() > 0){
//                    String fileName = dirPath + entry.getValue();
//                    FileOutputStream out = new FileOutputStream(fileName);
//                    out.write(bytes);
//                    out.flush();
//                    out.close();
//                }
//            }
//            String tempName = createZip(dirPath.substring(0,dirPath.lastIndexOf(File.separator)), TEMPDOWNLOADPATH); // System.getProperty("user.dir")
//            result = webClientDownload(response, request, tempName);
//
//            if (result){
//                // 删除临时文件
//                File delFile = new File(tempName);
//                if (delFile.exists() && delFile.isFile()) {
//                    delFile.delete();
//                }
//
//                zipName = tempName.substring(tempName.lastIndexOf(File.separator)+1);
//            }
//        }
//        return zipName;
//    }




    /**
     *
     * 单个文件下载
     *
     * @param filePath 文件名称
     * @param setName 源文件名称
     * @param response
     * @throws Exception
     */
//    public static boolean downloadFile(String filePath, String setName , HttpServletResponse response, HttpServletRequest request) throws Exception{
//        boolean result = false;
//        if (StringUtils.isNotEmpty(filePath)){
//            TrackerClient tracker = new TrackerClient();
//            TrackerServer trackerServer = tracker.getConnection();
//            StorageServer storageServer = null;
//            String groupName = filePath.substring(0, filePath.indexOf("/"));
//            String remoteFile = filePath.substring(filePath.indexOf("/")+1);
//
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//            byte[] b = storageClient.download_file(groupName, remoteFile);
//
//            String filePathUrl = TEMPDOWNLOADPATH + File.separator + setName; // System.getProperty("user.dir")
//            FileOutputStream out = new FileOutputStream(filePathUrl);
//            out.write(b);
//            out.flush();
//            out.close();
//            result = webClientDownload(response, request, filePathUrl);
//
//            if (result) {
//                deleteFile(setName);
//            }
//        }
//        return result;
//
//    }




    /**
     * 创建目录
     *
     * @author Minty
     * @return 目录名称
     * @Author beamzhang
     */
    public static String createDir(Long userId) {
        Long millis = System.currentTimeMillis();
        String date = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(millis);

        String dirName = TEMPDOWNLOADPATH + File.separator + date + userId; // System.getProperty("user.dir")
        File dir = new File(dirName);
        if (dir.exists()) {
            logger.error("创建目录" + dirName + "失败，目标目录已经存在");
            createDir(userId);
        }

        if (!dirName.endsWith(File.separator)) {
            dirName = dirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            logger.info("创建目录" + dirName + "成功！");
            return dirName;
        } else {
            logger.error("创建目录" + dirName + "失败！");
            createDir(userId);
        }
        return null;
    }


    /**
     * 创建ZIP文件
     * @param sourcePath 文件或文件夹路径
     * @param zipPath 生成的zip文件存在路径（包括文件名）
     * @Author beamzhang
     */
    public static String createZip(String sourcePath, String zipPath) {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        File file = null;
        try {
            file = new File(sourcePath);
            fos = new FileOutputStream(zipPath + File.separator + file.getName()+".zip");
            zos = new ZipOutputStream(fos);
            writeZip(file, "", zos);
        } catch (FileNotFoundException e) {
            logger.error("创建ZIP文件失败",e);
        } finally {
            try {
                if (zos != null) {
                    zos.close(); //关闭流
                    deleteDir(file); //删除目录
                    return zipPath + File.separator + file.getName()+".zip";
                }
            } catch (IOException e) {
                logger.error("创建ZIP文件失败",e);
            }

        }
        return zipPath + File.separator + file.getName()+".zip";
    }

    private static void writeZip(File file, String parentPath, ZipOutputStream zos) {
        if(file.exists()){
            if(file.isDirectory()){//处理文件夹
                parentPath+=file.getName()+File.separator;
                File [] files=file.listFiles();
                for(File f:files){
                    writeZip(f, parentPath, zos);
                }
            }else{
                FileInputStream fis=null;
                try {
                    fis=new FileInputStream(file);
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte [] content=new byte[1024];
                    int len;
                    while((len=fis.read(content))!=-1){
                        zos.write(content,0,len);
                        zos.flush();
                    }

                } catch (FileNotFoundException e) {
                    logger.error("创建ZIP文件失败",e);
                } catch (IOException e) {
                    logger.error("创建ZIP文件失败",e);
                }finally{
                    try {
                        if(fis!=null){
                            fis.close();
                        }
                    }catch(IOException e){
                        logger.error("创建ZIP文件失败",e);
                    }
                }
            }
        }
    }



    /**
     *
     * 删除目录使用
     *
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     * @Author beamzhang
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }


    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     * @Author beamzhang
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(TEMPDOWNLOADPATH + File.separator + sPath); // System.getProperty("user.dir")
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }


    /**
     * web 端下载文件
     *
     * @param response HttpServletResponse
     * @param filePath 文件路径
     * @return true 成功 false 失败
     * @throws IOException
     * @Author beamzhang
     */
    public static boolean webClientDownload(HttpServletResponse response, HttpServletRequest request, String filePath) throws IOException {
        File file = new File(filePath);
        if(!file.exists()){
            String errorMessage = "对不起,该文件不存在";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
        }
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType == null){
            mimeType = "application/octet-stream";
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType(mimeType);
        String fileName = null;
        if (isMSBrowser(request)){
            fileName = URLEncoder.encode(file.getName(), "UTF-8");
        }else {
            fileName = new String(file.getName().getBytes("utf-8"),"ISO8859-1");
        }

        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName +"\"");
        response.setContentLength((int)file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        int result = FileCopyUtils.copy(inputStream, response.getOutputStream());
        if (result > 0 ){
            return true;
        }
        return false;
    }



    //方法功能描述:       判断是否是IE浏览器
    public static boolean isMSBrowser(HttpServletRequest request) {
        String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};
        String userAgent = request.getHeader("User-Agent");
        for (String signal : IEBrowserSignals) {
            if (userAgent.contains(signal)){
                return true;
            }
        }
        return false;
    }
}
