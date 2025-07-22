#[derive(Debug)]
struct BSTNode {
    value: i32,
    left: Option<Box<BSTNode>>,
    right: Option<Box<BSTNode>>,
}

impl BSTNode {
    fn new(value: i32) -> Self {
        BSTNode {
            value: value,
            left: None,
            right: None,
        }
    }

    fn insert(&mut self, value: i32) {
        if value <= self.value {
            match &mut self.left {
                None => {
                    self.left = Some(Box::new(BSTNode::new(value)));
                }
                Some(node) => {
                    node.insert(value);
                }
            }
        } else {
            match &mut self.right {
                None => {
                    self.right = Some(Box::new(BSTNode::new(value)));
                }
                Some(node) => {
                    node.insert(value);
                }
            }
        }
    }

    fn preorder(&self) {
        print!("{} ", self.value);
        self.left.as_ref().map(|node| {
            node.preorder();
        });
        self.right.as_ref().map(|node| {
            node.preorder();
        });
    }
}

fn main() {
    let mut node = BSTNode::new(4);
    node.insert(2);
    node.insert(1);
    node.insert(3);
    node.insert(5);
    node.insert(6);
    node.insert(7);
    node.preorder();
}
