/*
package com.my.algorithm;

import java.util.*;
import java.util.stream.Collectors;

*/
/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/13 16:46
 *//*

public class Sort {


    public boolean sort(List<Entity> entities) {
        int[] place = new int[180 / 5];
        for (int i = 0; i < place.length; i++) {
            place[i] = -1;
        }


        if (entities != null && entities.size() > 1) {
            long times = entities.stream().map(e -> e.getTime()).collect(Collectors.counting());
            int s = (int) ((180 - times) / 5);
            for (int i = 0; i < s; i++) {
                entities.add(new Entity(null, "999", 5, 1));
            }
            List<Entity> results = new ArrayList<>(36);

            Map<Integer, Integer> already = new HashMap<>(entities.size());
            Entity f = entities.get(0);

            int time = f.getTime() / 5;
            int id = f.getId();
            int t = 0;
            for (; t < time; t++) {
                place[t] = id;
            }
            already.put(id, t - 1);


            results.add(f);
            Entity[] arrray = entities.toArray(new Entity[entities.size()]);
            arrray[0] = null;
            for (int i = 1; i < entities.size(); i++) {
                Entity entity = entities.get(i);
                int eid = entity.getId();
                Integer p = already.get(eid);
                if (p != null) {
                    int pp = p + 30 / 5;
                    int ppid = place[pp];
                    if (ppid == -1) {

                    }
                }
            }
        } else return true;

        return true;
    }

    public int[] sort2(List<Entity> entities) {
        int[] place = new int[180 / 5];
        for (int i = 0; i < place.length; i++) {
            place[i] = -1;
        }
        for (int i = 0; i < entities.size(); i++) {
            Entity entity = entities.get(i);
            int times = entity.getTime() / 5;
            int id = entity.getId();

            int k = i;
            k = getPlace(place, times, id, k);
            int hz = entity.getHz();
            if (hz > 1) {


                int[] a = interval(entities, times, id, k, place);
                if (a.length == 0) return a;
                place = a;
            }
        }
        return place;
    }

    public boolean sort3(List<Entity> entities) {
        if (entities != null && entities.size() > 1) {
            int[] a = sort2(entities);
            if (a.length == 0) return false;
            Optional<Entity> optional = entities.stream().filter(Entity::isIndustrySuccession).findAny();
            if (optional.isPresent()) {
                for(int i=0;i<a.length;){
                    int id = a[i];
                    while (a[++i]!=id) break;
                    while (a[i++]==-1) break;
                    int tid = a[i];
                    if(a[i-1]==-1&&a[i+1]==-1) continue;

                }

            } else return true;
        }
    }

    private int[] interval(List<Entity> entities, int times, int id, int k, int[] place) {

        for (int i = 6; i > 0; i--) {
            int start = k + i;
            int[] copy = Arrays.copyOf(place, place.length);
            for (int h = 1; h < entities.size(); h++) {
                //先尝试间隔30s

                start = getPlace(copy, times, id, start);
                if (start + times > 36) {
                    break;
                }
                return copy;
            }
        }

        return new int[0];


    }

    private int getPlace(int[] place, int times, int id, int k) {
        while (place[k++] != -1) break;
        for (int t = 0; t < times; t++) {
            place[k] = id;
            k++;
        }
        return k;
    }
}
*/
