package com.hthyaq.learnadmin.common.utils.treeSelect;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ReflectUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;


public class TreeSelectUtil {
    public static <T> List<TreeSelectView> get(List<T> list) {
        String columns = "id,pid,name";
        return get(list, columns);
    }

    /**
     * @param list    原始数据
     * @param columns 和id、pid、name对应的字段名称
     */
    public static <T> List<TreeSelectView> get(List<T> list, String columns) {
        if (CollectionUtil.isEmpty(list)) throw new RuntimeException("集合为空！");
        //顶级节点
        List<TreeSelectDto> rootList = Lists.newArrayList();
        //子节点
        List<TreeSelectDto> childList = Lists.newArrayList();
        //遍历
        for (T item : list) {
            String[] tmp = columns.split(",");
            //通过反射获取出item中的id、name、pid的属性值
            Integer id = Integer.parseInt(String.valueOf(ReflectUtil.getFieldValue(item, tmp[0])));
            Integer pid = Integer.parseInt(String.valueOf(ReflectUtil.getFieldValue(item, tmp[1])));
            String name = (String) ReflectUtil.getFieldValue(item, tmp[2]);
            if (pid.equals(-1)) {
                rootList.add(new TreeSelectDto(id, pid, name));
            } else {
                childList.add(new TreeSelectDto(id, pid, name));
            }
        }
        return getTreeSelect(rootList, childList);
    }

    private static List<TreeSelectView> getTreeSelect(List<TreeSelectDto> rootList, List<TreeSelectDto> childList) {
        //声明一个map，用来过滤已操作过的数据
        Map<Integer, Integer> map = Maps.newHashMapWithExpectedSize(childList.size());

        List<TreeSelectView> treeSelectViewList = Lists.newArrayList();
        rootList.forEach(tmp -> {
            TreeSelectView root = new TreeSelectView();
            convert(tmp, root);
            treeSelectViewList.add(root);
            getChildren(root, childList, map);
        });
        return treeSelectViewList;
    }

    private static void getChildren(TreeSelectView root, List<TreeSelectDto> childList, Map<Integer, Integer> map) {
        List<TreeSelectView> children = Lists.newArrayList();
        childList.stream().filter(tmp -> !map.containsKey(tmp.getId()))
                .filter(tmp -> root.getKey().equals(tmp.getPid()))
                .forEach(tmp -> {
                    //记录已遍历的节点
                    map.put(tmp.getId(), tmp.getPid());
                    //转换和存储
                    TreeSelectView treeSelectView = new TreeSelectView();
                    convert(tmp, treeSelectView);
                    children.add(treeSelectView);
                    //递归
                    getChildren(treeSelectView, childList, map);

                });
        root.setChildren(children);
    }

    //将TreeSelectDto转换为TreeSelectView
    private static void convert(TreeSelectDto treeSelectDto, TreeSelectView treeSelectView) {
        treeSelectView.setTitle(treeSelectDto.getName());
        treeSelectView.setKey(treeSelectDto.getId());
        treeSelectView.setValue(treeSelectDto.getId());
    }
}
