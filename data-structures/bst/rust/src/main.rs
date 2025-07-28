#[derive(Debug)]
struct BSTNode {
    key: i32,
    left: Option<Box<BSTNode>>,
    right: Option<Box<BSTNode>>,
}

impl BSTNode {
    fn new(key: i32) -> Self {
        BSTNode {
            key: key,
            left: None,
            right: None,
        }
    }

    fn insert(node: Option<Box<BSTNode>>, key: i32) -> Option<Box<BSTNode>> {
        match node {
            None => Some(Box::new(BSTNode::new(key))),
            Some(mut n) if key <= n.key => {
                n.left = BSTNode::insert(n.left, key);
                Some(n)
            }
            Some(mut n) => {
                n.right = BSTNode::insert(n.right, key);
                Some(n)
            }
        }
    }

    fn find(node: &Option<Box<BSTNode>>, key: i32) -> bool {
        match node {
            None => false,
            Some(n) if n.key == key => true,
            Some(n) if n.key > key => BSTNode::find(&n.left, key),
            Some(n) => BSTNode::find(&n.right, key),
        }
    }
}

struct BST {
    root: Option<Box<BSTNode>>,
    size: i32,
}

impl BST {
    fn new() -> Self {
        BST {
            root: None,
            size: 0,
        }
    }

    fn insert(&mut self, key: i32) {
        self.root = BSTNode::insert(self.root.take(), key);
        self.size += 1;
    }

    fn find(&self, key: i32) -> bool {
        BSTNode::find(&self.root, key)
    }
}

fn main() {
    let mut tree = BST::new();
    tree.insert(1);
    tree.insert(0);
    tree.insert(2);
    println!("{:?}", tree.root);
    println!("{:?}", tree.find(12));
}
