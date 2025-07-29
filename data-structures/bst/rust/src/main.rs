use std::cmp::Ordering;

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

    fn find(node: &mut Option<Box<BSTNode>>, key: i32) -> &mut Option<Box<BSTNode>> {
        if node.is_none() {
            return node;
        }
        match node.as_mut().unwrap().key.cmp(&key) {
            Ordering::Equal => node,
            Ordering::Greater => BSTNode::find(&mut node.as_mut().unwrap().left, key),
            Ordering::Less => BSTNode::find(&mut node.as_mut().unwrap().right, key),
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

    fn find(&mut self, key: i32) -> bool {
        match BSTNode::find(&mut self.root, key) {
            None => false,
            Some(_) => true,
        }
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
