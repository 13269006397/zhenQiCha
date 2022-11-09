package com.xinqiu.api.Test;

import com.xinqiu.api.entity.User;

import java.util.*;

/**
 * 两个集合对比取一致的交集
 */
public class listTest {

    public static void main(String[] args) {
        List<User> list1 = createdData(0, 1000000);
        System.out.println("list1长度为："+list1.size());
        List<User> list2 = createdData(0, 900000);
        System.out.println("list2长度为："+list2.size());
        long startTime = System.currentTimeMillis();
        //  LinkedList + 迭代器 取交集
        List<User> strings = receiveCollectionList(list1, list2);
        long endTime = System.currentTimeMillis();
        System.err.println("取交集消耗时间："+(endTime-startTime)+"毫秒,"+"一致的有："+strings.size());

        List<User> list3 = createdData(0, 1000000);
        System.out.println("list3长度为："+list3.size());
        List<User> list4 = createdData(0, 1000000);
        System.out.println("list4长度为："+list4.size());
        //  LinkedList + 迭代器 取交集
        long startTime1 = System.currentTimeMillis();
        List<User> string2 = receiveDefectList(list3, list4);
        long endTime2 = System.currentTimeMillis();
        System.err.println("取差集消耗时间："+(endTime2-startTime1)+"毫秒,"+"list1有list2没有的数量为："+string2.size());
    }

    /**
     * @方法描述：获取两个ArrayList的交集
     * @param firstArrayList 第一个 ArrayList 集合
     * @param secondArrayList 第二个 ArrayList 集合
     * @return
     */
    public static List<User> receiveCollectionList(List<User> firstArrayList,
                                                     List<User> secondArrayList) {
        if (firstArrayList == null || firstArrayList.size() == 0
                || secondArrayList == null || secondArrayList.size() == 0)
            return  null;
        /** 大集合用 LinkedList **/
        LinkedList<User> result = new LinkedList<User>(firstArrayList);
        /** 小集合用 HashSet **/
        HashSet<User> othHash = new HashSet<User>(secondArrayList);
        /** 采用Iterator迭代器进行数据的操作 **/
        Iterator<User> iter = result.iterator();
        while(iter.hasNext()) {
            if(!othHash.contains(iter.next())) {
                iter.remove();
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * @方法描述：获取两个ArrayList的差集
     * @param firstArrayList 第一个ArrayList
     * @param secondArrayList 第二个ArrayList
     * @return resultList 差集ArrayList
     */
    public static List<User> receiveDefectList(List<User> firstArrayList, List<User> secondArrayList) {
        List<User> resultList = new ArrayList<User>();
        LinkedList<User> result = new LinkedList<User>(firstArrayList);// 大集合用linkedlist
        HashSet<User> othHash = new HashSet<User>(secondArrayList);// 小集合用hashset
        Iterator<User> iter = result.iterator();// 采用Iterator迭代器进行数据的操作
        while(iter.hasNext()){
            if(othHash.contains(iter.next())){
                iter.remove();
            }
        }
        resultList = new ArrayList<User>(result);
        firstArrayList.clear();
        resultList.forEach(o-> firstArrayList.add(o));
        return resultList;
    }

    public static List<User> createdData(int start, int end){
        ArrayList<User> users = new ArrayList<>();
        for (int i = start; i < end; i++) {
            User user = new User();
            user.setId("id"+i);
            user.setUserName("用户名"+i);
            user.setPassword("密码"+i);
            user.setNickName("昵称"+i);
            user.setPhone("手机号"+i);
            users.add(user);
        }
        return users;
    }


}
