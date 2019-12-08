package com.my.algorithm;

import java.util.Collections;
import java.util.List;
/**
 * 1、对所有方案进行按照频次时长排序
 * 2、将180分成4段 每段45秒
 * 3、每次排列都是在自己负责的桶里面进行排列
 * 4、如果失败了，则到下一个桶尝试排列，以此类推
 *
 * 每个桶的排列思路：
 * 1、upCurrent和DownCurrent都总是指向当前有位置的下标。
 * 2、AB屏直接从upCurret和DownCurrent之间较大的开始排
 * 3、A屏或者B屏则需要从当前位置开始排，如果没有排到则从AB屏的位置开始排
 *
 *
 * */

public class NewSort {
    Bucket[] buckets = new Bucket[4];

    public boolean sort(List<Entity> entities) {

        sortEntity(entities);
        //初始化
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            int id = entity.getId();
            int hz = entity.getHz();
            int time = entity.getTime();
            String screen = entity.getScreen();
            if (screen.equals("001")) {
                for (int j = 0; j < hz; j++) {
                    boolean flag = buckets[j].sortAB(time, id);
                    if (!flag) {
                       boolean f =  retryAB(j,time,id);
                       if(!f){
                           return false;
                       }
                    }
                }

            } else if (screen.equals("002")) {
                for (int j = 0; j < hz; j++) {
                    boolean flag = buckets[j].sortA(time, id);
                    if (!flag) {
                        boolean f =  retryA(j,time,id);
                        if(!f){
                            return false;
                        }
                    }
                }
            } else if (screen.equals("003")) {
                for (int j = 0; j < hz; j++) {
                    boolean flag = buckets[j].sortB(time, id);
                    if (!flag) {
                        boolean f =  retryB(j,time,id);
                        if(!f){
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }

    public boolean retryAB(int curr, int time, int id) {
        try {
            boolean b = buckets[curr+1].sortAB(time, id);
            if(!b){
                retryAB(curr+1,time,id);
            }
        } catch (Exception e) {
            return false;
        }
        return true;

    }
    public boolean retryA(int curr, int time, int id) {
        try {
            boolean b = buckets[curr+1].sortA(time, id);
            if(!b){
                retryA(curr+1,time,id);
            }
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public boolean retryB(int curr, int time, int id) {
        try {
            boolean b = buckets[curr+1].sortB(time, id);
            if(!b){
                retryB(curr+1,time,id);
            }
        } catch (Exception e) {
            return false;
        }
        return true;

    }



    private static class Bucket {
        private int[] a;
        private int[] b;

        private int upCurrent;
        private int downCurrent;

        public boolean sortAB(int time, int id) {
            int current = upCurrent > downCurrent ? upCurrent : downCurrent;
            int times = time / 5;
            for (int i = 0; i < times; i++) {
                try {
                    if (a[current + i] == 0 && b[current + i] == 0) ;
                } catch (Exception e) {
                    return false;
                }
            }
            for (int i = 0; i < times; i++) {
                a[current + i] = id;
                b[current + i] = id;
            }
            if (upCurrent > downCurrent) {
                upCurrent = current + times;
            } else {
                downCurrent = current + times;
            }


            return true;
        }

        public boolean sortA(int time, int id) {
            int times = time / 5;
            int current = upCurrent;
            try {
                for (int i = 0; i < times; i++) {
                    if (a[current + i] != 0) {
                        return false;
                    }
                }
                while (times > 0) {
                    a[current++] = id;
                    times--;
                }
                while (current++ == 0) {
                    upCurrent = current;
                }
                return true;
            } catch (Exception e) {
                return false;
            }

        }

        public boolean sortB(int time, int id) {
            int times = time / 5;
            int current = downCurrent;
            try {
                for (int i = 0; i < times; i++) {
                    if (b[current + i] != 0) {
                        return false;
                    }
                }
                while (times > 0) {
                    b[current++] = id;
                    times--;
                }
                while (current++ == 0) {
                    downCurrent = current;
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }


        public int[] getA() {
            return a;
        }

        public int[] getB() {
            return b;
        }
    }

    private void sortEntity(List<Entity> linked) {
        Collections.sort(linked, (o1, o2) -> {
            int f = o2.getHz() - o1.getHz();
            if (f != 0) {
                return f;
            }
            return o2.getTime() - o1.getTime();
        });
    }
}
