package leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest_1110 {

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }

         @Override
         public String toString() {
             return "TreeNode{" +
                 "val=" + val +
                 ", left=" + left +
                 ", right=" + right +
                 '}';
         }
     }

    public List<TreeNode> delNodes( TreeNode root, int[] to_delete) {

         // 1. to_delete 배열을 Set으로 변환
        Set< Integer > set = new HashSet<>();
        for( int el : to_delete ) {
            set.add( el );
        }

        // 2. 지운 노드가 있는지 확인
        List< TreeNode > answer = new ArrayList<>();
        if ( !set.contains(root.val) ) answer.add( root );
        preTraverse( root, set, answer, null, false );
        return answer;
    }

    private void preTraverse( TreeNode root, Set< Integer> set, List< TreeNode> answer, TreeNode parent, boolean isLeft ) {
        if ( root == null ) return;

        // root가 지울 노드인 경우 -> 1) 부모로부터 null로 연결 끊기. 2) 자식이 살아 있으면 anwer에 담기.
        if ( set.contains( root.val ) ) {
            if ( parent != null ) {
                if ( isLeft ) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
            /* 자식 노드가 살아있는지 확인 -> 살아있으면 리스트에 담는다. */
            if ( root.left != null && !set.contains( root.left.val ) ) {
                answer.add( root.left );
            }
            if ( root.right != null && !set.contains( root.right.val ) ) {
                answer.add( root.right );
            }
        }
        preTraverse( root.left, set, answer, root, true );
        preTraverse( root.right, set, answer, root, false );
    }


    public static void main( String[] args ) {
        DeleteNodesAndReturnForest_1110 obj = new DeleteNodesAndReturnForest_1110();
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        root.left.left = new TreeNode( 4 );
        root.left.right = new TreeNode( 5 );
        root.right.left = new TreeNode( 6 );
        root.right.right = new TreeNode( 7 );
        int[] to_delete = { 3, 5 };
        System.out.println( obj.delNodes( root, to_delete ) );
    }
}
