package com.hthyaq.learnadmin.common.utils.cascade;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ReflectUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class CascadeUtil {

    public static <T> List<CascadeView> get(List<T> list) {
        String columns = "id,pid,name";
        return get(list, columns);
    }

    /**
     * @param list    原始数据
     * @param columns 和id、pid、name对应的字段名称
     */
    public static <T> List<CascadeView> get(List<T> list, String columns) {
        if (CollectionUtil.isEmpty(list)) throw new RuntimeException("集合为空！");
        //顶级节点
        List<CascadeDto> rootList = Lists.newArrayList();
        //子节点
        List<CascadeDto> childList = Lists.newArrayList();
        //遍历
        for (T item : list) {
            String[] tmp = columns.split(",");
            //通过反射获取出item中的id、name、pid的属性值
            Integer id = Integer.parseInt(String.valueOf(ReflectUtil.getFieldValue(item, tmp[0])));
            Integer pid = Integer.parseInt(String.valueOf(ReflectUtil.getFieldValue(item, tmp[1])));
            String name = (String) ReflectUtil.getFieldValue(item, tmp[2]);
            if (pid == -1) {
                rootList.add(new CascadeDto(id, pid, name));
            } else {
                childList.add(new CascadeDto(id, pid, name));
            }
        }
        return getTreeSelect(rootList, childList);
    }

    private static List<CascadeView> getTreeSelect(List<CascadeDto> rootList, List<CascadeDto> childList) {
        //声明一个map，用来过滤已操作过的数据
        Map<Integer, Integer> map = Maps.newHashMapWithExpectedSize(childList.size());

        List<CascadeView> cascadeViewList = Lists.newArrayList();
        rootList.forEach(tmp -> {
            CascadeView root = new CascadeView();
            convert(tmp, root);
            cascadeViewList.add(root);
            getChildren(root, childList, map);
        });
        return cascadeViewList;
    }

    private static void getChildren(CascadeView root, List<CascadeDto> childList, Map<Integer, Integer> map) {
        List<CascadeView> children = Lists.newArrayList();
        childList.stream().filter(tmp -> !map.containsKey(tmp.getId()))
                .filter(tmp -> root.getValue().equals(tmp.getPid()))
                .forEach(tmp -> {
                    //记录已遍历的节点
                    map.put(tmp.getId(), tmp.getPid());
                    //转换和存储
                    CascadeView cascadeView = new CascadeView();
                    convert(tmp, cascadeView);
                    children.add(cascadeView);
                    //递归
                    getChildren(cascadeView, childList, map);

                });
        root.setChildren(children);
    }

    //将CascadeDto转换为CascadeView
    private static void convert(CascadeDto cascadeDto, CascadeView cascadeView) {
        cascadeView.setLabel(cascadeDto.getName());
        cascadeView.setValue(cascadeDto.getId());
    }
}
