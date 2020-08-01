package datastructures.tree;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.data = value;
    }

    public void insert(int value){
        if(value < data){
            if(left == null){
                left = new TreeNode(value);
            } else{
                left.insert(value);
            }
        } else {
            if(right == null){
                right = new TreeNode(value);
            } else{
                right.insert(value);
            }
        }
    }

    public int getNodeCount(){
        int count = 0;
        if(left != null){
           count += left.getNodeCount();
        }
        count++;
        if(right != null){
           count += right.getNodeCount();
        }
        return count;
    }

    public boolean contains(int value){
        if(data == value) return true;
        else if(value < data){
            if(left == null){
                return false;
            } else {
                return left.contains(value);
            }
        } else{
            if(right == null){
                return false;
            } else{
                return right.contains(value);
            }
        }
    }

    public void printInOrder(){
        if(left != null){
            left.printInOrder();
        }

        System.out.print(data + "->");

        if(right != null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){
        System.out.print(data + "->");
        if(left != null){
            left.printPreOrder();
        }
        if(right != null){
            right.printPreOrder();
        }
    }

    public void printPostOrder(){
        if(left != null){
            left.printPostOrder();
        }
        if(right != null){
            right.printPostOrder();
        }
        System.out.print(data + "->");
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(10);

        System.out.println(tree.contains(10));
    }
}
