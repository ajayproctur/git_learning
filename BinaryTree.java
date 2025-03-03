
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    //Node class
    public static class Node {

        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
        }

    }

    //Display method
    public static void display(Node node) {
        if (node != null) {
            System.out.println(node.val);
            display(node.left);
            display(node.right);
        }
    }

//size->number of nodes
    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;

    }
//display the nodes and their childs

    public static void displayOne(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "-> ");
        String ansL = node.left == null ? "null " : node.left.val + " ";
        System.out.print(ansL);
        String ansR = node.right == null ? "null " : node.right.val + " ";
        System.out.print(ansR);
        System.out.println();
        displayOne(node.left);
        displayOne(node.right);

    }
    //find the sum of the nodes

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + sum(node.right) + node.val;
    }
    //find the product of the nodes

    public static int product(Node node) {
        if (node == null) {
            return 1;
        }
        return product(node.left) * product(node.right) + node.val;
    }

    //find max value
    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(node.val, Math.max(max(node.left), max(node.right)));
    }

    //find min value
    public static int min(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(node.val, Math.min(min(node.left), min(node.right)));
    }

    //find height
    public static int height(Node node) {
        if (node == null || node.left == null && node.right == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    //Pre-Order traversal->print root ->left subtree->right subtree
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "  ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //In-Order traversal->left subtree->print root ->right subtree
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + "  ");
        inOrder(node.right);
    }

    //Post-Order traversal->left subtree->right subtree->print root 
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "  ");
    }

    //Nth-level elements
    public static void nthLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.val + " ");
            return;
        }
        nthLevel(node.left, level - 1);
        nthLevel(node.right, level - 1);
    }

    // Level Order Traversal(BFS)
    public static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        if (node != null) {
            q.add(node);
        }
        while (q.size() > 0) {
            Node n = q.peek();
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
            System.out.print(n.val + " ");
            q.remove();
        }
    }

    public static int diameterOfBinaryTree(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);
        int mid = height(root.left) + height(root.right);
        if (root.left != null) {
            mid++;
        }
        if (root.right != null) {
            mid++;
        }
        int max = Math.max(leftD, Math.max(rightD, mid));
        return max;

    }

    public static boolean isBalanced(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        // if(Math.abs(height(root.left)-height(root.right))>1){
        //     return false;
        // }
        // return isBalanced(root.left) && isBalanced(root.right);
        int lh = height(root.left);
        if (root.left != null) {
            lh++;
        }
        int rh = height(root.right);
        if (root.right != null) {
            rh++;
        }
        int d = Math.abs(lh - rh);
        if (d > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //Lowest Comman Ancestor
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(p==root || q==root) return root;
        if(p==q) return p;
        boolean leftp=contains(root.left,p);
        boolean rightq=contains(root.right,q);

        if((leftp && rightq)||(!leftp && !rightq)) return root;
        if(leftp && !rightq) return lowestCommonAncestor(root.left, p, q);
        if(!leftp && rightq) return lowestCommonAncestor(root.right, p, q);
        return null;
    }

    public boolean contains(Node root,Node node){
        if(root==null) return false;
        if(root==node) return true;
        return contains(root.left, node) || contains(root.right, node);
    }

    //Invert binary tree
        public Node invertTree(Node root) {
            if(root==null) return root;
            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
    }

     public boolean isSymmetric(Node root) {
        return isSameTree(root.left,invertTree(root.right));
    }
    public boolean isSameTree(Node p, Node q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        Node root = new Node(-2);
        Node a = new Node(-4);
        Node b = new Node(-6);
        Node c = new Node(-5);
        Node d = new Node(-10);
        Node e = new Node(-1);
        root.left = a;
        root.right = d;
        a.left = b;
        a.right = c;
        d.right = e;
        // display(root);
        // displayOne(root);
        // System.out.println("Size: "+size(root));
        // System.out.println("Sum: "+sum(root));
        // System.out.println("Max: "+max(root));
        // System.out.println("Height: "+height(root));
        // System.out.println("Min: "+min(root));
        // System.out.println("Product: "+product(root));
        // preOrder(root);
        // inOrder(root);
        // postOrder(root);
        // nthLevel(root, 3);
        // bfs(root);
        diameterOfBinaryTree(root);
    }


}
