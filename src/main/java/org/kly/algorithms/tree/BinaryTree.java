package org.kly.algorithms.tree;

import org.kly.infrastructure.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @Author konglingyao
 * @Date 2018/12/20
 */
public class BinaryTree {


    private TreeNode root = null;

    private BinaryTree() {
        root = new TreeNode(1, "rootNode(A)");
    }

    /**
     * 创建一棵二叉树
     * <pre>
     *           A
     *     B          C
     *  D     E            F
     *  </pre>
     */
    private void createBinTree(TreeNode root) {
        TreeNode newNodeB = new TreeNode(2, "B");
        TreeNode newNodeC = new TreeNode(3, "C");
        TreeNode newNodeD = new TreeNode(4, "D");
        TreeNode newNodeE = new TreeNode(5, "E");
        TreeNode newNodeF = new TreeNode(6, "F");
        TreeNode newNodeG = new TreeNode(7, "G");
        TreeNode newNodeH = new TreeNode(8, "H");

        root.left = newNodeB;
        root.right = newNodeC;
        root.left.left = newNodeD;
        root.left.right = newNodeE;
        root.right.right = newNodeF;
        root.right.left = newNodeG;
        root.right.left.right = newNodeH;


    }


    public boolean isEmpty() {
        return root == null;
    }

    //树的高度
    private int height() {
        return height(root);
    }

    //节点个数
    private int size() {
        return size(root);
    }


    private int height(TreeNode subTree) {
        if (subTree == null)
            return 0;//递归结束：空树高度为0
        else {
            int i = height(subTree.left);
            int j = height(subTree.right);
            return (i < j) ? (j + 1) : (i + 1);
        }
    }

    private int size(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        } else {
            return 1 + size(subTree.left)
                    + size(subTree.right);
        }
    }

    //返回双亲结点
    public TreeNode parent(TreeNode element) {
        return (root == null || root == element) ? null : parent(root, element);
    }

    private TreeNode parent(TreeNode subTree, TreeNode element) {
        if (subTree == null)
            return null;
        if (subTree.left == element || subTree.right == element)
            //返回父结点地址
            return subTree;
        TreeNode p;
        //现在左子树中找，如果左子树中没有找到，才到右子树去找
        if ((p = parent(subTree.left, element)) != null)
            //递归在左子树中搜索
            return p;
        else
            //递归在右子树中搜索
            return parent(subTree.right, element);
    }

    public TreeNode getleftNode(TreeNode element) {
        return (element != null) ? element.left : null;
    }

    public TreeNode getrightNode(TreeNode element) {
        return (element != null) ? element.right : null;
    }

    public TreeNode getRoot() {
        return root;
    }

    //在释放某个结点时，该结点的左右子树都已经释放，
    //所以应该采用后续遍历，当访问某个结点时将该结点的存储空间释放
    private void destroy(TreeNode subTree) {
        //删除根为subTree的子树
        if (subTree != null) {
            //删除左子树
            destroy(subTree.left);
            //删除右子树
            destroy(subTree.right);
            //删除根结点
            subTree = null;
        }
    }

    private void traverse(TreeNode subTree) {
        System.out.println("key:" + subTree.val + "--name:" + subTree.data);
        ;
        traverse(subTree.left);
        traverse(subTree.right);
    }

    //前序遍历
    private void preOrder(TreeNode subTree) {
        if (subTree != null) {
            visited(subTree);
            preOrder(subTree.left);
            preOrder(subTree.right);
        }
    }

    //中序遍历
    private void inOrder(TreeNode subTree) {
        if (subTree != null) {
            inOrder(subTree.left);
            visited(subTree);
            inOrder(subTree.right);
        }
    }

    //后续遍历
    private void postOrder(TreeNode subTree) {
        if (subTree != null) {
            postOrder(subTree.left);
            postOrder(subTree.right);
            visited(subTree);
        }
    }

    //前序遍历的非递归实现
    private void nonRecPreOrder(TreeNode treeNode) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if (treeNode != null) {
            arrayDeque.addFirst(treeNode);
        }
        while (!arrayDeque.isEmpty()) {
            treeNode = arrayDeque.pollFirst();
            visited(treeNode);
            if (treeNode.right != null) {
                arrayDeque.addFirst(treeNode.right);
            }
            if (treeNode.left != null) {
                arrayDeque.addFirst(treeNode.left);
            }

        }
    }

    //中序遍历的非递归实现
    private void nonRecInOrder(TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = p;
        while (node != null || stack.size() > 0) {
            //存在左子树
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //栈非空
            if (stack.size() > 0) {
                node = stack.pop();
                visited(node);
                node = node.right;
            }
        }
    }

    private void nonRecInOrderMine(TreeNode treeNode) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(treeNode);
        boolean ifasd = true;
        while (!arrayDeque.isEmpty()) {
            treeNode = arrayDeque.peek();
            while (ifasd && treeNode.left != null) {
                arrayDeque.addFirst(treeNode.left);
                treeNode = treeNode.left;
            }
            treeNode = arrayDeque.pop();
            visited(treeNode);
            ifasd = false;
            if (treeNode.right != null) {
                arrayDeque.addFirst(treeNode.right);
                ifasd = true;
            }
        }
    }

    //后序遍历的非递归实现
    private void noRecPostOrder(TreeNode treeNode) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(treeNode);
        TreeNode lastVisit = null;
        while (!arrayDeque.isEmpty()) {
            treeNode = arrayDeque.peek();
            if ((treeNode.left == null && treeNode.right == null)
                    || (treeNode.left == lastVisit || treeNode.right == lastVisit)) {
                lastVisit = treeNode;
                visited(treeNode);
                arrayDeque.pop();
            } else {
                if (treeNode.right != null) {
                    arrayDeque.addFirst(treeNode.right);
                }
                if (treeNode.left != null) {
                    arrayDeque.addFirst(treeNode.left);

                }
            }
        }
    }

    private void visited(TreeNode subTree) {
        subTree.isVisited = true;
        System.out.println("key:" + subTree.val + "--name:" + subTree.data);
    }


    //测试
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinTree(bt.root);
        System.out.println("the size of the tree is " + bt.size());
        System.out.println("the height of the tree is " + bt.height());

        System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
        bt.preOrder(bt.root);

        System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
        bt.inOrder(bt.root);

        System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
        bt.postOrder(bt.root);

        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
        bt.nonRecPreOrder(bt.root);

        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");
        bt.nonRecInOrder(bt.root);

        System.out.println("***非递归实现****(后序遍历)[DEBFCA]遍历*****************");
        bt.noRecPostOrder(bt.root);
    }

}