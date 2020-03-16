package org.kly.basicSkills.algorithm.wild;

import java.util.ArrayList;
import java.util.List;

/**
 * // [
 * //     '总章节',
 * //     '(1)章节一',
 * //     '(1.1)第一节',
 * //     '(1.1.1)第一小节',
 * //     '(1.1.2)第二小节',
 * //     '(1.2)第二节',
 * //     '(2)章节二',
 * //     '(2.1)第三节',
 * //     '(2.2)第四节'
 * // ];
 * @Author Colia
 * @Date 2020/3/11.
 */
public class PrintChapterTree {


    private static void printChapter(NodeTree nodeTree) {
        List<String> result = new ArrayList<>();
        print(nodeTree, result, "", -1);
        for (String val : result) {
            System.out.println(val);
        }
    }


    private static void print(NodeTree nodeTree, List<String> result ,String bef,int num) {
        bef += num < 0 ? "" : num + 1 + "";
        result.add(bef.equals("") ? bef + nodeTree.name : "(" + bef + ")" + nodeTree.name);
        if (nodeTree.children != null) {
            bef += num < 0 ? "" : ".";
            for (int i = 0; i < nodeTree.children.size(); i++) {
                print(nodeTree.children.get(i), result, bef, i);
            }
        }
    }



    public static void main(String[] args) {

        NodeTree nodeTree1 = new NodeTree("第一小节", null);

        NodeTree nodeTree2 = new NodeTree("第二小节", null);

        List<NodeTree> nodeTreeJie1List = new ArrayList<>();

        nodeTreeJie1List.add(nodeTree1);

        nodeTreeJie1List.add(nodeTree2);

        NodeTree nodeTreeJie1 = new NodeTree("第一节", nodeTreeJie1List);
        NodeTree nodeTreeJie2 = new NodeTree("第二节", null);
        NodeTree nodeTreeJie3 = new NodeTree("第三节", null);
        NodeTree nodeTreeJie4 = new NodeTree("第四节", null);
        List<NodeTree> nodeTreeZhang1List = new ArrayList<>();
        List<NodeTree> nodeTreeZhang2List = new ArrayList<>();

        nodeTreeZhang1List.add(nodeTreeJie1);
        nodeTreeZhang1List.add(nodeTreeJie2);
        nodeTreeZhang2List.add(nodeTreeJie3);
        nodeTreeZhang2List.add(nodeTreeJie4);

        NodeTree nodeTreeZhang1 = new NodeTree("第一章", nodeTreeZhang1List);

        NodeTree nodeTreeZhang2 = new NodeTree("第二章", nodeTreeZhang2List);

        List<NodeTree> nodeTreeList = new ArrayList<>();
        nodeTreeList.add(nodeTreeZhang1);
        nodeTreeList.add(nodeTreeZhang2);

        NodeTree nodeTree = new NodeTree("总章节", nodeTreeList);

        printChapter(nodeTree);
    }

    static class NodeTree{
        String name;

        List<NodeTree> children;

        NodeTree(String name,List<NodeTree> children){
            this.name = name;
            this.children = children;
        }
    }
}
