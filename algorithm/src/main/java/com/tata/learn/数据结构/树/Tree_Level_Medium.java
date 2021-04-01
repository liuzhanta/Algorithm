package com.tata.learn.数据结构.树;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树-中等
 */
public class Tree_Level_Medium {


    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderII(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmpList);
        }
        return res;
    }

    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     *
     * @param root
     * @return
     */
    public int[] levelOrderI(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III (之字形打印)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmpList = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {
                    tmpList.addLast(node.val);
                } else {
                    tmpList.addFirst(node.val);

                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmpList);
        }
        return res;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 重建二叉树
    ///////////////////////////////////////////////////////////////////////////
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, preorder.length - 1);
    }

    /**
     * @param root  先序遍历的索引
     * @param left  中序遍历的索引
     * @param right 中序遍历的索引
     * @return
     */
    private TreeNode recur(int root, int left, int right) {
        if (right < left) {
            return null;
        }
        int rootVal = preorder[root];
        int rootIndex = map.get(rootVal);
        // left | root | right
        // root | left | right(root | left | right)
        TreeNode node = new TreeNode(rootVal);
        node.left = recur(root + 1, left, rootIndex - 1);
        node.right = recur(root + rootIndex - left + 1, rootIndex + 1, right);//根节点索引 + 左子树长度 + 1
        return node;
    }

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }


    ///////////////////////////////////////////////////////////////////////////
    //二叉树中和为某一值的路径
    ///////////////////////////////////////////////////////////////////////////
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }


        recur(root, sum);
        return res;
    }

    public void recur(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        sum -= node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            res.add(new LinkedList(path));
        }
        recur(node.left, sum);
        recur(node.right, sum);
        path.removeLast();
    }

    /**
     * 验证二叉搜索树
     *
     * @param root
     * @return
     */
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (prev == null) {
            prev = root;
        } else if (prev.val >= root.val) {
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }

    /**
     * 二叉树展开为链表
     *
     * @param root
     */
    List<TreeNode> result = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root==null) {
            return;
        }
        preOrder(root);
        for (int i = 1; i < result.size(); i++) {
            TreeNode prev = result.get(i - 1);
            TreeNode cur = result.get(i);
            prev.left= null;
            prev.right = cur;
        }

    }
    public void preOrder(TreeNode root){
        if(root==null){
            return ;
        }
        result.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }


}
