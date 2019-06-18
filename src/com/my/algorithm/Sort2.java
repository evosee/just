package com.my.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/13 16:46
 */
public class Sort2 {

    public static void main(String[] args) {
      //  Entity entity3 = new Entity(20, "a", 20, 4);
        Entity entity = new Entity(15, "a", 15, 4);
        Entity entity2 = new Entity(5, "a", 5, 4);
        Entity entity4 = new Entity(4, "b", 5, 4);
        Entity entity7 = new Entity(7, "d", 5, 2);
        Entity entity6 = new Entity(6, "c", 5, 3);
        Entity entity8 = new Entity(8, "a", 5, 1);

        entity.setIndustrySuccession(true);
        entity2.setIndustrySuccession(true);
        List<Entity> entities = new ArrayList<>();
      //  entities.add(entity3);
        entities.add(entity);
        entities.add(entity2);
        entities.add(entity4);
        entities.add(entity6);
        entities.add(entity7);
        entities.add(entity8);


        System.out.println(Arrays.toString(new Sort2().sort2(entities)));
    }

    public int[] sort2(List<Entity> entities) {
        if (entities != null && entities.size() > 1) {
            int p = entities.stream().map(e -> e.getTime() * e.getHz()).collect(Collectors.summingInt(Integer::intValue));
            int times = entities.stream().map(e -> e.getHz()).collect(Collectors.summingInt(Integer::intValue));
            int x = ((180 - p) / 5);
            List<Entity> resutls = new ArrayList<>(x + times);
            //初始化
            for (int i = 0; i < x + times; i++) {
                resutls.add(null);
            }

            resutls = setResults(entities, resutls);


            return getResults(resutls);


        }
        return new int[36];
    }


    public int[] getResults(List<Entity> entities) {
        int[] x = new int[36];
        int j = 0;
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            if (entity != null) {
                int id = entity.getId();
                int times = entity.getTime() / 5;
                int p = 0;
                for (int min = 0; min < times; min++) {
                    p = j + min;
                    x[p] = id;
                }
                j = p + 1;
            } else {
                x[j] = -1;
                j++;
            }
        }
        return x;

    }

    private List<Entity> setResults(List<Entity> entities, List<Entity> resutls) {
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            int pp = setPlace(resutls, entity);
            List<Entity> lists = hzSort(resutls, entity, pp, 6);
            if(lists.size()==0) return new ArrayList<>();
            resutls = lists;
        }
        return resutls;
    }

    private List<Entity> hzSort(List<Entity> resutls, Entity entity, int pp, int max) {
        int hz = entity.getHz();
        if (hz > 1) {
            //先尝试间隔30s
            List<Entity> r = new ArrayList<>(resutls);

            boolean flag = false;
            int x = pp;
            for (; hz > 1; hz--) {
                pp = interval(pp, r, entity, max);
                if (pp == -1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                if(max>0){
                    return  hzSort(resutls, entity, x, --max);
                }
                return new ArrayList<>();
            } else {
                return r;
            }

        }
        return resutls;
    }

    private int setPlace(List<Entity> resutls, Entity entity) {
        //找空位
        int j = 0;
        int p = 0;
        while (resutls.get(j++) != null) p++;
        if (p != 0) {
            Entity left = resutls.get(p - 1);
            while (left != null && (left.isIndustrySuccession() || entity.isIndustrySuccession()) && left.getIndustry().equals(entity.getIndustry())) {
                p++;
                int pp = p;
                while (resutls.get(p++) != null) pp++;
                left = resutls.get(pp - 1);
                p = pp;
            }
        }


        resutls.set(p, entity);
        return p;
    }

    private int interval(int p, List<Entity> results, Entity entity, int max) {


        for (int i = max; i > 0; i--) {
            int pp = p+i+1;
            if (pp >= results.size() || results.get(pp) != null) continue;
            Entity left = results.get(pp-1);
            if(left != null&&(left.isIndustrySuccession()||entity.isIndustrySuccession())&&left.getIndustry().equals(entity.getIndustry()))continue;
            results.set(pp, entity);
            return pp;
        }
        return -1;
    }

}
