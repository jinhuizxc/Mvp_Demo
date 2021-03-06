package com.example.jh.mvp_demo.network.download;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.example.jh.baselibrary.utils.AppUtil;
import com.example.jh.mvp_demo.network.callback.DownLoadCallBack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class DownLoadManager {

    private DownLoadCallBack callBack;

    public static final String TAG = "[DownLoadManager]";

    private static String APK_CONTENTTYPE = "application/vnd.android.package-archive";

    private static String PNG_CONTENTTYPE = "image/png";

    private static String JPG_CONTENTTYPE = "image/jpg";

    private static String JPEG_CONTENTTYPE = "image/jpeg";
    private static String VIDEO_CONTENTTYPE = "video/mp4";

    private static String fileSuffix = "";

    private Handler handler;

    public static boolean isDownLoading = false;

    public static boolean isCancel = false;

    private Context mContext;

    public DownLoadManager(Context context, DownLoadCallBack callBack) {
        this.mContext = context;
        this.callBack = callBack;
        handler = new Handler(Looper.getMainLooper());
    }

    private static volatile DownLoadManager sInstance;

    /**
     * DownLoadManager getInstance
     */
    public static DownLoadManager getInstance(DownLoadCallBack callBack, Context context) {
        if (sInstance == null) {
            synchronized (DownLoadManager.class) {
                if (sInstance == null) {
                    sInstance = new DownLoadManager(context, callBack);
                }
            }
        }
        return sInstance;
    }

    public boolean writeResponseBodyToDisk(String path, String name, ResponseBody body) {

        Log.d(TAG, "======contentType:===" + body.contentType().toString());

        if (!TextUtils.isEmpty(name)) {
            String type = "";
            if (!name.contains(".")) {
                type = body.contentType().toString();
                if (type.equals(APK_CONTENTTYPE)) {
                    fileSuffix = ".apk";
                } else if (type.equals(PNG_CONTENTTYPE)) {
                    fileSuffix = ".png";
                } else if (type.equals(JPG_CONTENTTYPE)) {
                    fileSuffix = ".jpg";
                } else if (type.equals(JPEG_CONTENTTYPE)) {
                    fileSuffix = ".jpeg";
                } else {
                    fileSuffix = "."+body.contentType().subtype();
                }

                name = name + fileSuffix;
            }
        } else {
            name = System.currentTimeMillis() + fileSuffix;
        }

        if (path == null) {
            path = mContext.getExternalFilesDir(null) + File.separator + "download";
        }

        Log.d(TAG, "========path:=========" + path);
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(path + File.separator + name);

            Log.d(TAG, "========futureStudioIconFile:=path========" + futureStudioIconFile.getAbsolutePath());

            if (!new File(path).exists()) {
                new File(path).mkdirs();
            }

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                final long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                Log.d(TAG, "======file length: =======" + fileSize);

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1 || isCancel) {
                        break;
                    }

                    isDownLoading = true;
                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    Log.d(TAG, "======file download:===== " + fileSizeDownloaded + " of " + fileSize);
                    if (callBack != null) {
                        if (callBack != null) {
                            final long finalFileSizeDownloaded = fileSizeDownloaded;
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    callBack.onProgress(finalFileSizeDownloaded, fileSize);
                                }
                            }, 200);
                        }
                    }
                }

                outputStream.flush();
                Log.d(TAG, "=======file downloaded:======= " + fileSizeDownloaded + " of " + fileSize);

                isDownLoading = false;

                if (callBack != null) {
                    final String finalName = name;
                    final String finalPath = path;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            callBack.onSuccess(finalPath, finalName, fileSize);

                        }
                    });
                    Log.d(TAG, "======file downloaded:====== " + fileSizeDownloaded + " of " + fileSize);
                    Log.d(TAG, "========file downloaded: is sucess=========");
                }

                return true;
            } catch (IOException e) {
                finalonError(e);
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            finalonError(e);
            return false;
        }
    }

    private void finalonError(final Exception e) {

        if (callBack == null) {
            return;
        }

        if (AppUtil.checkMain()) {
            callBack.onError(new Throwable(e));
        } else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.onError(new Throwable());
                }
            });
        }
    }
}

