package com.app.study.thread;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.StringUtils;

import com.ycl.common.constants.CommonConstants;
import com.ycl.common.util.DateUtil;

public class ThreadPoolTest {

    private static Map<String, String> timezone = new HashMap<String, String>();

    private static void init() {
        setTimeZone("09");
        setTimeZone("10");
        setTimeZone("11");
    }

    private static void setTimeZone(String hour) {
        int time = 0;
        for (int i = 0; i < CommonConstants.NumberConstant.FOUR
                .getValue(); i++) {
            String value = String.format("00%s", time);
            value = value.substring(
                value.length() - CommonConstants.NumberConstant.TWO.getValue());
            timezone.put(String.format("%s:%s:00", hour, value),
                StringUtils.EMPTY);
            time = time + 15;
        }
    }

    private static Date getSearchTime(Date nowTime) {
        Date searchDate = null;
        Date keyDate = null;
        long tempTime = 0;
        try {
            for (Map.Entry<String, String> entry : timezone.entrySet()) {

                keyDate = getKeyTime(nowTime, entry.getKey());
                long diff = keyDate.getTime() - nowTime.getTime();

                if (diff == 0) {
                    return keyDate;
                }
                if (diff < 0) {
                    continue;
                }

                if (tempTime == 0) {
                    tempTime = diff + 1;
                }

                if (diff < tempTime) {
                    tempTime = diff;
                    searchDate = keyDate;
                }

            }
        } catch (ParseException e) {
            return null;
        }
        return searchDate;
    }

    private static Date getKeyTime(Date nowTime,
            String key) throws ParseException {
        String keyTimeStr = String.format("%s %s", getYmd(nowTime), key);

        return DateUtil.parseDate(
            CommonConstants.CommonConstant.YYYY_MM_DD_HH_MM_SS.getValue(),
            keyTimeStr);

    }

    private static String getYmd(Date date) {
        return DateUtil.formatDate(
            CommonConstants.CommonConstant.YYYY_MM_DD.getValue(), date);
    }

    public static void testThreadSubmit() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();
        // 创建10个任务并执行  
        for (int i = 0; i < 10; i++) {
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中  
            Future<String> future = executorService
                    .submit(new TaskResult(String.valueOf(i)));
            // 将任务执行结果存储到List中  
            resultList.add(future);
        }
        executorService.shutdown();
        // 遍历任务的结果  
        for (Future<String> fs : resultList) {
            try {
                System.out.println(fs.get()); // 打印各个线程（任务）执行的结果  
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                executorService.shutdownNow();
                e.printStackTrace();
                return;
            }
        }
    }

    public static void main(String[] args) {
        //        init();
        //        try {
        //            Date d = getSearchTime(DateUtil.parseDate(
        //                CommonConstants.CommonConstant.YYYY_MM_DD_HH_MM_SS.getValue(),
        //                "2012-12-11 12:25:00"));
        //            if (d != null) {
        //                System.out.println(DateUtil.formatDate(
        //                    CommonConstants.CommonConstant.YYYY_MM_DD_HH_MM_SS
        //                            .getValue(),
        //                    d));
        //            }
        //            //          testThreadSubmit();
        //
        //        } catch (ParseException e) {
        //            // TODO Auto-generated catch block
        //            e.printStackTrace();
        //        }

    }

}
